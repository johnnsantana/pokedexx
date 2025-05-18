package com.johnnsantana.pokedex.ui.feature.pokedex

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.johnnsantana.pokedex.domain.model.PokemonInfo
import com.johnnsantana.pokedex.domain.usecase.GetPokemonInfoUseCase
import com.johnnsantana.pokedex.data.repository.PokedexRepository
import kotlinx.coroutines.launch

class PokedexViewModel(
    private val pokedexRepository: PokedexRepository,
    private val getPokemonInfoUseCase: GetPokemonInfoUseCase
) : ViewModel() {

    val paging = Pager(PagingConfig(pageSize = 20)) {
        pokedexRepository.getPokemonPagingSource()
    }.flow.cachedIn(viewModelScope)

    var state by mutableStateOf(PokedexState())
        private set

    // Cache simples de PokemonInfo por nome
    private val _pokemonInfoCache = mutableStateMapOf<String, PokemonInfo>()
    val pokemonInfoCache: Map<String, PokemonInfo> get() = _pokemonInfoCache


    suspend fun getPokemonInfo(name: String): PokemonInfo? {
        return _pokemonInfoCache[name] ?: getPokemonInfoUseCase(name)?.also {
            _pokemonInfoCache[name] = it
        }
    }

    // Função para buscar info e atualizar o cache, chamada pela UI
    fun loadPokemonInfo(name: String) {
        if (_pokemonInfoCache.containsKey(name)) return
        viewModelScope.launch {
            val info = getPokemonInfoUseCase(name)
            info?.let { _pokemonInfoCache[name] = it }
        }
    }
}
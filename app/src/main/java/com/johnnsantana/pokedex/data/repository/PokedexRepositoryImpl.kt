package com.johnnsantana.pokedex.data.repository

import androidx.paging.PagingSource
import com.johnnsantana.pokedex.data.network.datasource.NetworkDataSource
import com.johnnsantana.pokedex.domain.model.Pokemon
import com.johnnsantana.pokedex.domain.model.PokemonInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.johnnsantana.pokedex.mappers.toDomain
import com.johnnsantana.pokedex.ui.feature.pokedex.paging.PokedexPagingSource

class PokedexRepositoryImpl(
    private val networkDataSource: NetworkDataSource
): PokedexRepository {

    override suspend fun getPokemonList(
        limit: Int,
        offset: Int
    ): Result<List<Pokemon>> {
        return withContext(Dispatchers.IO) {
            runCatching {
                val resultListPokemon = networkDataSource.fetchPokemonList(PAGE_SIZE, offset)
                resultListPokemon.results.map { it.toDomain() }
            }
        }
    }

    override suspend fun getPokemonInfo(name: String): Result<PokemonInfo> {
        return withContext(Dispatchers.IO) {
            runCatching {
                val resultPokemonInfo = networkDataSource.fetchPokemonInfo(name)

                resultPokemonInfo.toDomain()
            }
        }
    }

    override fun getPokemonPagingSource(): PagingSource<Int, Pokemon> {
        return PokedexPagingSource(this)
    }


    companion object {
        private const val PAGE_SIZE = 10
    }

}
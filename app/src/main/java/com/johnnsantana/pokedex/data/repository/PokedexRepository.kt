package com.johnnsantana.pokedex.data.repository

import androidx.paging.PagingSource
import com.johnnsantana.pokedex.domain.model.Pokemon
import com.johnnsantana.pokedex.domain.model.PokemonInfo

interface PokedexRepository {
    suspend fun getPokemonList(limit: Int, offset: Int): Result<List<Pokemon>>

    suspend fun getPokemonInfo(name: String): Result<PokemonInfo>

    fun getPokemonPagingSource(): PagingSource<Int, Pokemon>
}
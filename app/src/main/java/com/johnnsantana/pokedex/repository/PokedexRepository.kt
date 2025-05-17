package com.johnnsantana.pokedex.repository

import com.johnnsantana.pokedex.domain.Pokemon
import com.johnnsantana.pokedex.domain.PokemonInfo

interface PokedexRepository {
    suspend fun getPokemonList(limit: Int, offset: Int): Result<List<Pokemon>>

    suspend fun getPokemonInfo(name: String): Result<PokemonInfo>
}
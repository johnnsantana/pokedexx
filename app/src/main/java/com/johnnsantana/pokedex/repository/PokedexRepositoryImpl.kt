package com.johnnsantana.pokedex.repository

import com.johnnsantana.pokedex.datasource.NetworkDataSource
import com.johnnsantana.pokedex.domain.Pokemon
import com.johnnsantana.pokedex.domain.PokemonInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.johnnsantana.pokedex.data.mappers.toDomain

class PokedexRepositoryImpl(
    private val networkDataSource: NetworkDataSource
): PokedexRepository {

    override suspend fun getPokemonList(
        limit: Int,
        offset: Int
    ): Result<List<Pokemon>> {
        return withContext(Dispatchers.IO) {
            runCatching {
                val resultListPokemon = networkDataSource.fetchPokemonList(limit, offset)
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
}
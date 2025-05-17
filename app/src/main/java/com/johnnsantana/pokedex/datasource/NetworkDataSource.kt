package com.johnnsantana.pokedex.datasource

interface NetworkDataSource {
    suspend fun getPokemonList(limit: Int, offset: Int)

    suspend fun getPokemonInfo(name: String)
}
package com.johnnsantana.pokedex.datasource

import com.johnnsantana.pokedex.data.model.PokemonInfoResponse
import com.johnnsantana.pokedex.data.model.PokemonListResponse

interface NetworkDataSource {
    suspend fun fetchPokemonList(limit: Int, offset: Int): PokemonListResponse
    
    suspend fun fetchPokemonInfo(name: String): PokemonInfoResponse
}
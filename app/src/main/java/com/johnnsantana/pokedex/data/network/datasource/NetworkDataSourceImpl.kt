package com.johnnsantana.pokedex.data.network.datasource

import com.johnnsantana.pokedex.data.model.PokemonInfoResponse
import com.johnnsantana.pokedex.data.model.PokemonListResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.http.parameters

class NetworkDataSourceImpl(
    private val httpClient: HttpClient
): NetworkDataSource {

    override suspend fun fetchPokemonList(
        limit: Int,
        offset: Int
    ): PokemonListResponse {
        return httpClient.get("pokemon") {
            parameters {
                parameter("limit", limit)
                parameter("offset", offset)
            }
        }.body<PokemonListResponse>()
    }

    override suspend fun fetchPokemonInfo(name: String): PokemonInfoResponse {
       return httpClient.get("pokemon/$name").body<PokemonInfoResponse>()
    }
}
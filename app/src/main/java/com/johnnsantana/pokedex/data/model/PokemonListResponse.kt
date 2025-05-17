package com.johnnsantana.pokedex.data.model

import kotlinx.serialization.Serializable

@Serializable
data class PokemonListResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<BasicPokemonResponse>
)

@Serializable
data class BasicPokemonResponse(
    val name: String,
    val url: String
)

package com.johnnsantana.pokedex.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonListResponse(
    @SerialName("count")
    val count: Int,
    @SerialName("next")
    val next: String? = null,
    @SerialName("previous")
    val previous: String? = null,
    @SerialName("results")
    val results: List<BasicPokemonResponse>
)

@Serializable
data class BasicPokemonResponse(
    @SerialName("name")
    val name: String,
    @SerialName("url")
    val url: String
)

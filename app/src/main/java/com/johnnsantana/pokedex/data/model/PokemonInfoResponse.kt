package com.johnnsantana.pokedex.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonInfoResponse(
    val id: Int,
    val name: String,
    @SerialName("past_abilities")
    val pastAbilities: List<PastAbilitiesResponse>,
    val types: List<TypesResponse>
)
@Serializable
data class PastAbilitiesResponse (
    val generation: GenerationResponse
)

@Serializable
data class GenerationResponse (
    val name: String
)

@Serializable
data class TypesResponse (
    val slot: Int,
    val type: TypeResponse
)

@Serializable
data class TypeResponse (
    val name: String,
)
package com.johnnsantana.pokedex.data.model

import kotlinx.serialization.Serializable

@Serializable
data class PastAbilitiesResponse (
    val generation: List<GenerationResponse>
)

@Serializable
data class GenerationResponse (
    val name: String
)
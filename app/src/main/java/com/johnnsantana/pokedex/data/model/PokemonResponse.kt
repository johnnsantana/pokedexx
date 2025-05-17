package com.johnnsantana.pokedex.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonResponse(
    val id: Int,
    val name: String,
    @SerialName("past_abilities")
    val pastAbilities: List<PastAbilitiesResponse>,
    val types: List<TypesResponse>
)

package com.johnnsantana.pokedex.data.model

import kotlinx.serialization.Serializable

@Serializable
data class TypesResponse (
    val slot: Int,
    val type: List<TypeResponse>
)

@Serializable
data class TypeResponse (
    val name: String,
)
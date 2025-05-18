package com.johnnsantana.pokedex.domain.model

data class PokemonInfo(
    val id: Int,
    val name: String,
    val generation: String?,
    val types: String,
    val imageUrl: String
)

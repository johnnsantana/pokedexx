package com.johnnsantana.pokedex.domain

data class PokemonInfo(
    val id: Int,
    val name: String,
    val generation: String?,
    val types: List<String>,
    val imageUrl: String
)

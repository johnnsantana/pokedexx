package com.johnnsantana.pokedex.data.mappers

import com.johnnsantana.pokedex.data.model.BasicPokemonResponse
import com.johnnsantana.pokedex.data.model.PokemonInfoResponse
import com.johnnsantana.pokedex.domain.Pokemon
import com.johnnsantana.pokedex.domain.PokemonInfo

fun PokemonInfoResponse.toDomain(): PokemonInfo {
    val generationName = pastAbilities.firstOrNull()?.generation?.name

    return PokemonInfo(
        id = id,
        name = name.replaceFirstChar { it.uppercase() },
        generation = generationName,
        types = types.map { it.type.name },
        imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$id.png"
    )
}

fun BasicPokemonResponse.toDomain(): Pokemon {
    val index = url.trimEnd('/').split("/").last()
    return Pokemon(
        name = name.replaceFirstChar { it.uppercase() },
        imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$index.png"
    )
}
package com.johnnsantana.pokedex.domain.usecase

import com.johnnsantana.pokedex.domain.model.PokemonInfo
import com.johnnsantana.pokedex.data.repository.PokedexRepository

class GetPokemonInfoUseCase(
    private val repository: PokedexRepository
) {
    suspend operator fun invoke(name: String): PokemonInfo? {
        return repository.getPokemonInfo(name).getOrNull()
    }
}
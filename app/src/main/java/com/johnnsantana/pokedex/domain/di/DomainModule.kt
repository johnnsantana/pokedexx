package com.johnnsantana.pokedex.domain.di

import com.johnnsantana.pokedex.domain.usecase.GetPokemonInfoUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { GetPokemonInfoUseCase(get()) }
}
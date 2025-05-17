package com.johnnsantana.pokedex.repository.di

import com.johnnsantana.pokedex.repository.PokedexRepository
import com.johnnsantana.pokedex.repository.PokedexRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<PokedexRepository> { PokedexRepositoryImpl(get()) }
}
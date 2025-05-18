package com.johnnsantana.pokedex.data.repository.di

import com.johnnsantana.pokedex.data.repository.PokedexRepository
import com.johnnsantana.pokedex.data.repository.PokedexRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<PokedexRepository> { PokedexRepositoryImpl(get()) }
}
package com.johnnsantana.pokedex.network.di

import org.koin.dsl.module


val networkModule = module {
    single { ApiModule.provideHttClient() }
}
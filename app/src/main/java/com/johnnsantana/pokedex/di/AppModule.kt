package com.johnnsantana.pokedex.di

import com.johnnsantana.pokedex.network.di.networkModule
import org.koin.dsl.module

val appModule = module {
    includes(networkModule)
}
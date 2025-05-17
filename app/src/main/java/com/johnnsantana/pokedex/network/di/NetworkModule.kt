package com.johnnsantana.pokedex.network.di

import com.johnnsantana.pokedex.datasource.NetworkDataSource
import com.johnnsantana.pokedex.datasource.NetworkDataSourceImpl
import org.koin.dsl.module


val networkModule = module {
    single { ApiModule.provideHttClient() }
    single<NetworkDataSource> { NetworkDataSourceImpl(get()) }
}
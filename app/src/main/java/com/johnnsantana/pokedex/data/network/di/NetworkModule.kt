package com.johnnsantana.pokedex.data.network.di

import com.johnnsantana.pokedex.data.network.datasource.NetworkDataSource
import com.johnnsantana.pokedex.data.network.datasource.NetworkDataSourceImpl
import org.koin.dsl.module


val networkModule = module {
    single { ApiModule.provideHttClient() }
    single<NetworkDataSource> { NetworkDataSourceImpl(get()) }
}
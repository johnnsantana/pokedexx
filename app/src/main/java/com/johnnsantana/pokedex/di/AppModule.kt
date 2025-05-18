package com.johnnsantana.pokedex.di

import com.johnnsantana.pokedex.data.network.di.networkModule
import com.johnnsantana.pokedex.data.repository.di.repositoryModule
import com.johnnsantana.pokedex.domain.di.domainModule
import com.johnnsantana.pokedex.ui.feature.di.viewModelModule
import org.koin.dsl.module

val appModule = module {
    includes(networkModule, repositoryModule, viewModelModule, domainModule)
}
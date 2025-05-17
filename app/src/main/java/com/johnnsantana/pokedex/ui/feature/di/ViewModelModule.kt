package com.johnnsantana.pokedex.ui.feature.di


import com.johnnsantana.pokedex.ui.feature.pokedex.PokedexViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {
    viewModel { PokedexViewModel(get()) }
}
package com.johnnsantana.pokedex.ui.navigation

import kotlinx.serialization.Serializable

interface Routes {
    @Serializable object Pokedex
    @Serializable object Region
    @Serializable object Favorites
    @Serializable object Profile
}
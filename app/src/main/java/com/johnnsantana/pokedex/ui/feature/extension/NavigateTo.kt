package com.johnnsantana.pokedex.ui.feature.extension

import androidx.navigation.NavController
import androidx.navigation.NavOptions
import com.johnnsantana.pokedex.ui.navigation.Routes

fun NavController.navigateToPokedex(
    navOptions: NavOptions? = null
) {
    this.navigate(Routes.Pokedex, navOptions)
}

fun NavController.navigateToRegion(
    navOptions: NavOptions? = null
) {
    this.navigate(Routes.Region, navOptions)
}

fun NavController.navigateToFavorites(
    navOptions: NavOptions? = null
) {
    this.navigate(Routes.Favorites, navOptions)
}

fun NavController.navigateToProfile(
    navOptions: NavOptions? = null
) {
    this.navigate(Routes.Profile, navOptions)
}
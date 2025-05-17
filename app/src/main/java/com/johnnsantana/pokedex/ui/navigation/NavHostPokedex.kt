package com.johnnsantana.pokedex.ui.navigation

import android.annotation.SuppressLint
import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.johnnsantana.pokedex.ui.feature.pokedex.PokedexRoute

@SuppressLint("ContextCastToActivity")
@Composable
fun NavHostPokedex(
    navigationStatePokedex: NavigationStatePokedex
) {
    val navController = navigationStatePokedex.navController
    val activity = LocalContext.current as? Activity

    NavHost(navController = navController, startDestination = Routes.Pokedex) {
        composable<Routes.Pokedex> {
            PokedexRoute()
        }
    }
    
}
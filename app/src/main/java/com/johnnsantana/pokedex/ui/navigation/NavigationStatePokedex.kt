package com.johnnsantana.pokedex.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.johnnsantana.pokedex.ui.feature.extension.navigateToFavorites
import com.johnnsantana.pokedex.ui.feature.extension.navigateToPokedex
import com.johnnsantana.pokedex.ui.feature.extension.navigateToProfile
import com.johnnsantana.pokedex.ui.feature.extension.navigateToRegion

@Composable
fun rememberNavigationStatePokedex(
    navController: NavHostController = rememberNavController()
): NavigationStatePokedex {
    return remember(navController) {
        NavigationStatePokedex(navController)
    }
}

@Stable
class NavigationStatePokedex (
    val navController: NavHostController
) {
    val currentDestination: NavDestination?
        @Composable
        get() = navController.currentBackStackEntryAsState().value?.destination

    val currentTopLevelDestination: TopLevelDestination?
        @Composable
        get() = TopLevelDestination.entries.firstOrNull { topLevelDestination ->
            currentDestination?.hasRoute(topLevelDestination.route) == true
        }

    val topLevelDestinations = TopLevelDestination.entries


    fun navigateToTopLevelDestination(topLevelDestination: TopLevelDestination) {
        val topLevelNavOptions = navOptions {
            popUpTo(navController.graph.startDestinationId) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }

        when (topLevelDestination) {
            TopLevelDestination.POKEDEX -> navController.navigateToPokedex(topLevelNavOptions)
            TopLevelDestination.REGION -> {}
            TopLevelDestination.FAVORITES -> {}
            TopLevelDestination.PROFILE -> {}
        }
    }
}
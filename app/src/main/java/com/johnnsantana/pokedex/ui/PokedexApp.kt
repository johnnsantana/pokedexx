package com.johnnsantana.pokedex.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.johnnsantana.pokedex.ui.feature.components.BottomNavigationMenuComponent
import com.johnnsantana.pokedex.ui.navigation.NavHostPokedex
import com.johnnsantana.pokedex.ui.navigation.rememberNavigationStatePokedex


@Composable
fun PokedexApp() {
    val navigationState = rememberNavigationStatePokedex()
    Scaffold(
       bottomBar = {
           val topLevelDestinations = navigationState.topLevelDestinations.toTypedArray()
           if (topLevelDestinations.contains(navigationState.currentTopLevelDestination)) {
               BottomNavigationMenuComponent(
                   navigationState = navigationState
               )
           }
       }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            NavHostPokedex(
                navigationStatePokedex = navigationState
            )
        }

    }
}
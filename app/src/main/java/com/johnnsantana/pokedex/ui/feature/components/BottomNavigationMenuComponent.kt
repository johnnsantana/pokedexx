package com.johnnsantana.pokedex.ui.feature.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import com.johnnsantana.pokedex.ui.navigation.NavigationStatePokedex
import com.johnnsantana.pokedex.ui.navigation.rememberNavigationStatePokedex
import com.johnnsantana.pokedex.ui.theme.Normal
import com.johnnsantana.pokedex.ui.theme.PokedexTheme
import com.johnnsantana.pokedex.ui.theme.PrimaryColor
import kotlin.reflect.KClass

@Composable
fun BottomNavigationMenuComponent(
    navigationState: NavigationStatePokedex,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = modifier
            .padding(top = 1.dp),
        containerColor = MaterialTheme.colorScheme.surface,
        tonalElevation = 0.dp
    ) {
        navigationState.topLevelDestinations.forEach { topLevelDestination ->
            val selected = navigationState
                .currentDestination.isRouteInHierarchy(topLevelDestination.route)
            val label = topLevelDestination.titleRes?.let { labelResId ->
                stringResource(id = labelResId)
            }
            NavigationBarItem(
                selected = selected,
                onClick = {
                    if (!selected) {
                        navigationState.navigateToTopLevelDestination(topLevelDestination)
                    }
                },
                icon = {
                    val currentIcon = if (selected && topLevelDestination.selectedIconRes != null) {
                        topLevelDestination.selectedIconRes
                    } else {
                        topLevelDestination.iconRes
                    }
                    currentIcon?.let {
                        Icon(
                            painter = painterResource(id = it),
                            contentDescription = label,
                            tint = Color.Unspecified
                        )
                    }
                },
                label = {
                    label?.let {
                        Text(text = it)
                    }
                },
                alwaysShowLabel = true,
                colors = NavigationBarItemDefaults.colors(
                    unselectedTextColor = Normal,
                    selectedTextColor = PrimaryColor,
                    indicatorColor = Color.Transparent
                ),

                )
        }
    }
}

private fun NavDestination?.isRouteInHierarchy(route: KClass<*>) =
    this?.hierarchy?.any {
        it.hasRoute(route)
    } ?: false

@Preview
@Composable
private fun BottomNavigationMenuComponentOPreview() {
    PokedexTheme {
        BottomNavigationMenuComponent(
            navigationState = rememberNavigationStatePokedex()
        )
    }
}
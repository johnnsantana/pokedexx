package com.johnnsantana.pokedex.ui.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.johnnsantana.pokedex.R
import kotlin.reflect.KClass

enum class TopLevelDestination(
    @StringRes val titleRes: Int?,
    @DrawableRes val iconRes: Int?,
    @DrawableRes val selectedIconRes: Int? = null,
    val route: KClass<*>
) {
    POKEDEX(
        titleRes = R.string.bottom_bar_title_pokedex,
        iconRes = R.drawable.ic_pokedex_not_selected,
        selectedIconRes = R.drawable.ic_pokedex_selected,
        route = Routes.Pokedex::class,
    ),
    REGION(
        titleRes = R.string.bottom_bar_title_region,
        iconRes = R.drawable.ic_region_not_selected,
        route = Routes.Region::class,
    ),
    FAVORITES(
        titleRes = R.string.bottom_bar_title_favorites,
        iconRes = R.drawable.ic_favoriote_not_selected,
        route = Routes.Favorites::class,
    ),
    PROFILE(
        titleRes = R.string.bottom_bar_title_profile,
        iconRes = R.drawable.ic_profile_not_selected,
        route = Routes.Profile::class,
    ),
}
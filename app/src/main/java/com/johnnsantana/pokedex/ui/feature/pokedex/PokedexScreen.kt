package com.johnnsantana.pokedex.ui.feature.pokedex

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.johnnsantana.pokedex.ui.theme.PokedexTheme


@Composable
fun PokedexRoute() {
    PokedexScreen()
}

@Composable
fun PokedexScreen() {

}

@Preview
@Composable
private fun PokedexScreenPreview() {
    PokedexTheme {
        PokedexScreen()
    }
}
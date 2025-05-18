package com.johnnsantana.pokedex.ui.feature.pokedex


import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.paging.compose.collectAsLazyPagingItems
import com.johnnsantana.pokedex.ui.feature.components.CircularProgressComponent
import com.johnnsantana.pokedex.ui.feature.components.PokedexInfoItemComponent
import com.johnnsantana.pokedex.ui.theme.PokedexTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun PokedexRoute(
    viewModel: PokedexViewModel = koinViewModel()
) {
    PokedexScreen(
        viewModel = viewModel
    )
}

@Composable
fun PokedexScreen(
    viewModel: PokedexViewModel
) {
    val pagingItems = viewModel.paging.collectAsLazyPagingItems()
    val pokemonInfoCache = viewModel.pokemonInfoCache

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp)
        ,
        contentPadding = PaddingValues(0.dp)
    ) {
        items(pagingItems.itemCount) { index ->
            val pokemon = pagingItems[index] ?: return@items

            LaunchedEffect(pokemon.name) {
                viewModel.loadPokemonInfo(pokemon.name)
            }
            val pokemonInfo = pokemonInfoCache[pokemon.name]

            if (pokemonInfo != null) {
                PokedexInfoItemComponent(pokemonInfo = pokemonInfo)
            } else CircularProgressComponent()
        }

    }
}



@Preview
@Composable
private fun PokedexScreenPreview() {
    PokedexTheme {
        PokedexScreen(
            viewModel = koinViewModel()
        )
    }
}
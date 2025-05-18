package com.johnnsantana.pokedex.ui.feature.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.johnnsantana.pokedex.R
import com.johnnsantana.pokedex.domain.model.PokemonInfo
import com.johnnsantana.pokedex.ui.theme.Electric
import com.johnnsantana.pokedex.ui.theme.PokedexTheme

@Composable
fun PokedexInfoItemComponent(
    pokemonInfo: PokemonInfo,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(120.dp)
    ) {
        Row(
            modifier = modifier
                .fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
                    .padding(12.dp)
            ) {
                pokemonInfo.generation?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.labelSmall,
                    )
                }

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = pokemonInfo.name,
                    style = MaterialTheme.typography.bodyLarge,
                )
                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier
                        .width(120.dp)
                        .height(60.dp)
                        .clip(ShapeDefaults.ExtraLarge)
                        .background(Electric)
                        .padding(horizontal = 8.dp)
                    ,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Box(
                        modifier = Modifier
                            .clip(ShapeDefaults.ExtraLarge)

                            .background(Color.White)
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_pokedex_selected),
                            contentDescription = null,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = pokemonInfo.types,
                        style = MaterialTheme.typography.labelMedium
                    )
                }
            }

            Surface(
                modifier = Modifier
                    .width(126.dp)
                    .fillMaxHeight(),
                shape = ShapeDefaults.Medium,
                color = Electric,
            ) {
                Column(
                    Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    AsyncImage(
                        model = pokemonInfo.imageUrl,
                        contentDescription = null
                    )
                }
            }
        }
    }
    Spacer(modifier = Modifier.height(16.dp))
}

@Preview
@Composable
private fun PokedexInfoItemComponentPreview() {
    PokedexTheme {
        PokedexInfoItemComponent(
            pokemonInfo = PokemonInfo(
                id = 1,
                name = "Pikachu",
                generation = "N001",
                types = "Eletric",
                imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/25.png"
            )
        )
    }
}
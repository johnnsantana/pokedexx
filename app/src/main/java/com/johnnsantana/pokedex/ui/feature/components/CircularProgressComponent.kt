package com.johnnsantana.pokedex.ui.feature.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.johnnsantana.pokedex.ui.theme.PokedexTheme
import com.johnnsantana.pokedex.ui.theme.ProgressIndicatorColor


@Composable
fun CircularProgressComponent(
    modifier: Modifier = Modifier
) {
    Column(
        Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(
            modifier = modifier,
            color = ProgressIndicatorColor
        )
    }

    Spacer(modifier = modifier.height(12.dp))

}

@Preview(showBackground = true)
@Composable
private fun CircularProgressComponentPreview() {
    PokedexTheme {
        CircularProgressComponent()
    }
}
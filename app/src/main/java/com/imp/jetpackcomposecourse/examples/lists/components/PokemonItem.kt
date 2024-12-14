package com.imp.jetpackcomposecourse.examples.lists.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.imp.jetpackcomposecourse.examples.lists.data.Pokemon

@Composable
fun PokemonItem(pokemon: Pokemon,
                //Evento de deteccion de click y retorno del parametro "pokemon" en dicho evento
                onItemClick:(Pokemon) -> Unit) {
    Card(
        border = BorderStroke(width = 1.dp,
            color = Color.Black),
        modifier = Modifier.fillMaxWidth()
            .clickable {
                       onItemClick(pokemon)
            },
    ) {
        Column {
            AsyncImage(model = ImageRequest.Builder(LocalContext.current)
                .data(pokemon.imageURL)
                .crossfade(2000)
                .build(),
                contentDescription = pokemon.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Fit)
            Box(contentAlignment =  Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(android.graphics.Color.parseColor("#FF090F20")))
                    .padding(16.dp)) {
                Text(text = pokemon.name,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            }
        }
    }
}
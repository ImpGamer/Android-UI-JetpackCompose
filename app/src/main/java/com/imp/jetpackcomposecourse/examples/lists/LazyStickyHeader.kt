package com.imp.jetpackcomposecourse.examples.lists

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.imp.jetpackcomposecourse.examples.lists.components.PokemonItem
import com.imp.jetpackcomposecourse.examples.lists.data.getPokemon

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LazyStickyHeaderComponent() {
    val pokemonsFilter = getPokemon().groupBy {
        it.name.first()
    }
    
    LazyColumn(modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)) {
        pokemonsFilter.forEach() {(character,pokemons) ->
            stickyHeader {
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.DarkGray)
                    .padding(4.dp)) {
                    Text(text = character.toString(),
                        color = Color.White)
                }
            }
            items(pokemons) {pokemon ->
                PokemonItem(pokemon = pokemon,
                    onItemClick = {TODO()
                    })
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun LazyStickyHeaderComponentPreview() {
    LazyStickyHeaderComponent()
}
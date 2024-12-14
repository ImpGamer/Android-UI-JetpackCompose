package com.imp.jetpackcomposecourse.examples.lists

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.imp.jetpackcomposecourse.examples.lists.components.PokemonItem
import com.imp.jetpackcomposecourse.examples.lists.data.getPokemon

//Creacion de listas de elementos de manera vertical
@Composable
fun LazyListComponent() {
    LazyColumn(modifier = Modifier.fillMaxWidth()
        .padding(PaddingValues(8.dp)),
        verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(getPokemon()) {pokemon ->
            //Codigo o disenio que se repita 20 veces
            PokemonItem(pokemon = pokemon,
                onItemClick = {pokemon ->
                    println("Lazy Column $pokemon.name")
                })
        }
    }
}



@Preview(showSystemUi = true)
@Composable
fun LazyListComponentPreview() {
    LazyListComponent()
}
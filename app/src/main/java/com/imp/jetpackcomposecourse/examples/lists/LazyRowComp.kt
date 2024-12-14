package com.imp.jetpackcomposecourse.examples.lists

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.imp.jetpackcomposecourse.examples.lists.components.PokemonItem
import com.imp.jetpackcomposecourse.examples.lists.data.getPokemon

@Composable
fun LazyRowComp() {
    LazyRow(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        items(getPokemon()) {
            PokemonItem(pokemon = it,
                onItemClick = {pokemon ->
                    println("Lazy Row $pokemon.name")
                })
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun LazyRowCompPreview() {
    LazyRowComp()
}
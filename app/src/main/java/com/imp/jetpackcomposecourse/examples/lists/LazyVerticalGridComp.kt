package com.imp.jetpackcomposecourse.examples.lists

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.imp.jetpackcomposecourse.examples.lists.components.PokemonItem
import com.imp.jetpackcomposecourse.examples.lists.data.getPokemon

@Composable
fun LazyVerticalGridComp() {
    //Cantidad de columnas por repeticion de filas
    LazyVerticalGrid(
        //columns = GridCells.Fixed(2),
        columns = GridCells.Adaptive(140.dp),
        contentPadding = PaddingValues(8.dp),
        horizontalArrangement = Arrangement.spacedBy(9.dp),
        verticalArrangement = Arrangement.spacedBy(9.dp),
        modifier = Modifier.fillMaxWidth()
        ) {
        items(getPokemon()) {
            PokemonItem(pokemon = it,
                onItemClick = {pokemon ->
                    println("LazyVerticalGrid ${pokemon.name}")
                })
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun LazyVerticalGridCompPreview() {
    LazyVerticalGridComp()
}
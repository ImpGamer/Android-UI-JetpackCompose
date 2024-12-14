package com.imp.jetpackcomposecourse.examples.lists

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.imp.jetpackcomposecourse.examples.lists.components.PokemonItem
import com.imp.jetpackcomposecourse.examples.lists.data.getPokemon

@Composable
fun HorizontalGridComponent() {
    //Cantidad de filas declaradas
    LazyHorizontalGrid(rows = GridCells.Adaptive(200.dp),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(9.dp),
        horizontalArrangement = Arrangement.spacedBy(9.dp)) {
        items(getPokemon()) {
            PokemonItem(pokemon = it,
                onItemClick = {
                    println("LazyHorizontalGrid clciked! ${it.name}")
                })
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun HorizontalGridComponentPreview() {
    HorizontalGridComponent()
}
package com.imp.jetpackcomposecourse.examples

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ColumnsContainers() {
    Column {
        Text(
            text = "Hello World",
            fontStyle = FontStyle.Italic
        )
        Text(
            text = "Este texto deberia estar abajo"
        )
    }
}

//Funcion para previsualizar nuestros componentes Compose
@Composable
//Se pueden crear varias anotaciones @Preview para mostrar varios dispositivos con la app
@Preview(
    name = "Columns Preview",
    showSystemUi = true
)
fun previewUI() {
    ColumnsContainers()
}

@Composable
fun RowsContainers() {
    Row {
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Haz click!")
        }
        Text(text = "Este texto deberia estar a lado",
            fontSize = 20.sp,
            modifier = Modifier.padding(20.dp))
    }
}

@Composable
@Preview(name = "Rows preview", showSystemUi = true)
fun previewRows() {
    RowsContainers()
}

@Composable
fun BoxContainers() {
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier
            .background(Color.Red)
            .fillMaxSize()) {
        Text(text = "Texto dentro de una caja",
            modifier = Modifier
                .background(Color.White)
                .border(
                    width = 2.dp,
                    color = Color.Black
                )
                .padding(20.dp)
                .border(
                    width = 2.dp,
                    color = Color.Green
                )
        )
    }
}

@Composable
@Preview(name = "Boxs preview", showSystemUi = true)
fun previewBoxs() {
    BoxContainers()
}

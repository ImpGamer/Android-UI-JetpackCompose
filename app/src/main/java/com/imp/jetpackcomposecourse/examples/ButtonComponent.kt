package com.imp.jetpackcomposecourse.examples

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ButtonComponent() {
    Column {
        Button(onClick = { /*TODO*/ },) {
            Icon(imageVector = Icons.Filled.ShoppingCart, contentDescription = "Shopping")
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Buy")
        }
        Button(onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Magenta,
                contentColor = Color.Blue
            )) {
            Text(text = "Click!")
        }

        OutlinedButton(onClick = { /*TODO*/ },
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = Color.Gray,
                contentColor = Color.Blue
            ),
            border = BorderStroke(
                width = 3.dp,
                brush = Brush.horizontalGradient(
                    listOf(
                        Color.Yellow,
                        Color.Black
                    )
                )
            )
        ) {
            Text(text = "Welcome!")
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Filled.Check, contentDescription = "icon")
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun previewButtons() {
    ButtonComponent()
}
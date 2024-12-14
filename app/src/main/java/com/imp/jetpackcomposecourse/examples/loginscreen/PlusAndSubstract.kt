package com.imp.jetpackcomposecourse.examples.loginscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun PlusAndAbstract() {
    var quantity = remember {
        mutableStateOf(0)
    }
    Row(modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        ) {
        Button(onClick = {
            quantity.value++;
        }) {
            Text(text = "+")
        }
        Text(text = quantity.value.toString(),
            fontSize = 30.sp)
        Button(onClick = {
            quantity.value--;
        }) {
            Text(text = "-")
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PlusAndAbstractPreview() {
    PlusAndAbstract()
}
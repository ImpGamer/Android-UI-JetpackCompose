package com.imp.jetpackcomposecourse.examples.loginscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormComponent() {
    var text by remember {
        mutableStateOf("")
    }

    Column {
        OutlinedTextField(
            value = text,
            onValueChange = {
                text = it
            })
        Text(text = "")
    }
}

@Preview(showSystemUi = true)
@Composable
fun FormComponentPreview() {
    FormComponent()
}
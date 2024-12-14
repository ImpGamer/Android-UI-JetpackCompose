package com.imp.jetpackcomposecourse.examples

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun textField() {
    Column {
        TextField(value = "Write something", onValueChange = {value -> println(value)})

        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(value = "Hola!", onValueChange = {}
        ,label = {
            Text(text = "Escribe algo:")
            },
            leadingIcon = {
                Icon(imageVector = Icons.Filled.CheckCircle, contentDescription = "Check circle")
            },
            trailingIcon = {
                Icon(imageVector = Icons.Filled.Clear,
                    contentDescription = "Delete")
            },
            textStyle = TextStyle(
                fontSize = 20.sp,
                color = Color.Magenta
            ),
            shape = RoundedCornerShape(12.dp),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                capitalization = KeyboardCapitalization.None,
                autoCorrect = false,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = {} //Funcion o implementacion al hacer click
            )
        )
    }
}

@Preview(name = "TextFieldPreview", showSystemUi = true)
@Composable
fun previewTextField() {
    textField()
}
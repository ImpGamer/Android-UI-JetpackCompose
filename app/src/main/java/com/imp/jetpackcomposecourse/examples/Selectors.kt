package com.imp.jetpackcomposecourse.examples

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun RadioAndChecksButtons() {
    val courses:List<String> = listOf("JetPack Compose","Kotlin desde cero")

    Column {
        courses.forEach {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                RadioButton(selected = false,
                    onClick = { /*TODO*/ },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = Color.Red,
                        unselectedColor = Color.Black
                    ))
                Text(text = it)
            }
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Checkbox(checked = true,
                onCheckedChange = {},
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Green,
                    uncheckedColor = Color.Red,
                    checkmarkColor = Color.Black
                ))
            Text(text = "Accept termines")
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun RadioAndChecksPreview() {
    RadioAndChecksButtons()
}
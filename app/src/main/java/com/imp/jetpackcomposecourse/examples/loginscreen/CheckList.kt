package com.imp.jetpackcomposecourse.examples.loginscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CheckBoxListComp() {
    val coursesList = remember {
        mutableListOf("Jetpack Compose","Kotlin desde cero")
    }
    var currentElement by remember {
        mutableStateOf(coursesList.first())
    }

    Column {
        coursesList.forEach {coursename ->
            Row(modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = currentElement == coursename,
                    onClick = {
                        currentElement = coursename
                    },
                    enabled = true,
                    colors = RadioButtonDefaults.colors(
                        selectedColor = Color.Green,
                        unselectedColor = Color.Black
                    )
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = coursename)
            }
        }
    }

}

@Preview(showSystemUi = true)
@Composable
fun CheckBoxListCompPreview() {
    CheckBoxListComp()
}
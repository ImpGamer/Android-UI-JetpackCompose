package com.imp.jetpackcomposecourse.examples

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.imp.jetpackcomposecourse.R

@Composable
fun ImagesComposable() {
    Column {
        Image(painter = painterResource(id = R.drawable.default_image),
            contentDescription = "Default Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(128.dp)
                .clip(CircleShape)
                .border(
                    width = 2.dp,
                    color = Color.Gray,
                    shape = CircleShape
                ))
    }
}

@Preview(showSystemUi = true)
@Composable
fun ImagesComposablePreview() {
    ImagesComposable()
}
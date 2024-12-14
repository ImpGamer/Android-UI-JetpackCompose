package com.imp.jetpackcomposecourse.examples

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WelcomeScreen(name:String) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color(android.graphics.Color.parseColor("#073042"))),
        contentAlignment = Alignment.Center) {
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = name,
                color = Color.White,
                fontSize = 28.sp,
                fontWeight = FontWeight.Medium)
            Text(text = "Android Developer",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier= Modifier
                    .background(Color(android.graphics.Color.parseColor("#3ddc84")))
            )
        }
    }

    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Divider(thickness = 3.dp,color = Color.White)
            Row(modifier = Modifier.padding(5.dp)) {
                Icon(imageVector = Icons.Filled.Phone,
                    contentDescription = "Phone",
                    tint = Color.Green)
                //Componente que crea un espacio entre elementos
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "+1 123 (213) 233",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White)
            }
            Divider(thickness = 3.dp,color = Color.White)
            Row(modifier = Modifier.padding(15.dp)) {
                Icon(imageVector = Icons.Filled.Share,
                    contentDescription = "Share Icon",
                    tint = Color.Green)
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "@ImpDev",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp)
            }
        }
    }
}

@Preview(name = "WelComeScreenPreview", showSystemUi = true)
@Composable
fun previewWelcomeScreen() {
    WelcomeScreen("Isaac David Gordillo")
}
package com.imp.jetpackcomposecourse.examples.loginscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.imp.jetpackcomposecourse.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen() {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Box(contentAlignment = Alignment.TopCenter,
            modifier = Modifier.fillMaxWidth()) {
            Image(painter = painterResource(id = R.drawable.default_image),
                contentDescription = "EDTeam logo")
        }

        Column(modifier = Modifier.fillMaxWidth()) {
            Text(text = "Login",
                color = Color.Black,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold)

            OutlinedTextField(value = "",
                onValueChange = { TODO()},
                label = {
                    Text(text = "Username")
                },
                shape = RoundedCornerShape(24.dp),
                modifier = Modifier.fillMaxWidth())
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(value = "",
                onValueChange = { TODO()},
                label = {
                    Text(text = "Password")
                },
                shape = RoundedCornerShape(24.dp),
                modifier = Modifier.fillMaxWidth())
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedButton(onClick = { /*TODO*/ },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color.Black,
                    contentColor = Color.White
                )) {
                Text(text = "Log In",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold)
            }
        }

        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = false,
                onCheckedChange = {TODO()}
            )
            Text(text = "Remember Password")
        }
        Text(
            text = buildAnnotatedString {
                append("Did you forget your password? ")
                withStyle(style = SpanStyle(color = Color.Blue)) {
                    append("recover it here!")
                }
            },
            modifier = Modifier.fillMaxWidth()
        )
        Divider(
            thickness = 3.dp,
            color = Color.Black
        )

        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(14.dp)) {

            Text(text = "Do not you have an account yet?",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold)

            OutlinedButton(onClick = { /*TODO*/ },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Color.Black,
                    containerColor = Color.White
                )) {
                Text(text = "Sign Up")
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}
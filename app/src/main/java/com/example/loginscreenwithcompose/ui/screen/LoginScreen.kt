package com.example.loginscreenwithcompose.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.loginscreenwithcompose.R
import com.example.loginscreenwithcompose.ui.components.CustomShapeBox

@Composable
fun LoginScreen(navController: NavController) {
    val emailText = remember { mutableStateOf(TextFieldValue()) }
    val passwordText = remember { mutableStateOf(TextFieldValue()) }
    var passwordVisible by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Login",
                modifier = Modifier.padding(bottom = 32.dp),
                fontSize = 32.sp
            )
            TextField(
                value = emailText.value,
                onValueChange = { emailText.value = it },
                label = { Text(text = "Email Address") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )
            TextField(
                value = passwordText.value,
                onValueChange = { passwordText.value = it },
                label = { Text(text = "Password") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = {
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(
                            painter = painterResource(
                                id = if (passwordVisible) R.drawable.view else R.drawable.hide
                            ),
                            contentDescription = if (passwordVisible) "Hide password" else "Show password",
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            )
            CustomShapeBox(
                onClick = {
                    navController.navigate("mainScreen")
                },
                isSelectedColor = Color.Black,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            ) {
                Text("Login", color = Color.White)
            }
            CustomShapeBox(
                onClick = {
                    navController.navigate("registerScreen")
                },
                isSelectedColor = Color.Black,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            ) {
                Text("Register", color = Color.White)
            }
        }
    }
}

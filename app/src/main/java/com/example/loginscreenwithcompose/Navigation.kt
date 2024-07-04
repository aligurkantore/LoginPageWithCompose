package com.example.loginscreenwithcompose

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.loginscreenwithcompose.ui.screen.LoginScreen
import com.example.loginscreenwithcompose.ui.screen.MainScreen
import com.example.loginscreenwithcompose.ui.screen.RegisterScreen

@Composable
fun MyApp() {
    val navController = rememberNavController()
    
    NavHost(navController = navController, startDestination = "loginScreen" ) {
        composable("loginScreen") {
            LoginScreen(navController = navController)
        }
        composable("registerScreen") {
            RegisterScreen(navController = navController)
        }
        composable("mainScreen") {
            MainScreen(navController = navController)
        }
    }
}
package com.lab.compose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import presentation.ButtonScreen
import presentation.MaterialComponentGrid

@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "grid") {
        composable("grid") {
            MaterialComponentGrid(
                onButtonClick = { navController.navigate("button") }
            )
        }
        composable("button") { ButtonScreen() }
    }
}
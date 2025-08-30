package com.lab.compose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lab.compose.model.MaterialComponentName
import presentation.ButtonScreen
import presentation.MaterialComponentGrid

@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = NavigationRouteNames.HomeSceen) {
        composable(NavigationRouteNames.HomeSceen) {
            MaterialComponentGrid(
                onButtonClick = { component ->
                    when (component) {
                        MaterialComponentName.Button -> navController.navigate(NavigationRouteNames.ButtonScreen)
                        else -> {}
                    }

                }
            )
        }
        composable(NavigationRouteNames.ButtonScreen) { ButtonScreen() }
    }
}
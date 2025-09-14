package com.lab.compose.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed class AppScreen

sealed class ComponentScreen : AppScreen() {
    @Serializable
    object Button : ComponentScreen(), NavKey

    @Serializable
    object TextField : ComponentScreen(), NavKey

    @Serializable
    object Text : ComponentScreen(), NavKey

    @Serializable
    object CheckBox : ComponentScreen(), NavKey
}

sealed class HomeScreen : AppScreen() {
    @Serializable
    object Home : HomeScreen(), NavKey
}
package com.lab.compose.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed interface AppScreen : NavKey

sealed interface ComponentScreen : AppScreen {
    @Serializable
    object Button : AppScreen

    @Serializable
    object TextField : AppScreen

    @Serializable
    object Text : AppScreen

    @Serializable
    object CheckBox : ComponentScreen, NavKey
}

sealed interface HomeScreen : AppScreen {
    @Serializable
    object Home : AppScreen
}
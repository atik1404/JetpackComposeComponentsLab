package com.lab.compose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.lab.compose.model.MaterialComponentName
import com.lab.compose.presentation.ButtonScreen
import com.lab.compose.presentation.MaterialComponentGrid

@Composable
fun AppNav() {
    val backStack = rememberNavBackStack(HomeNavKey)
    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = { key ->
            when (key) {
                is HomeNavKey -> NavEntry(key) {
                    MaterialComponentGrid(
                        onButtonClick = { component ->
                            if (component == MaterialComponentName.Button)
                                backStack.add(ButtonNavKey(component.name))
                        }
                    )
                }

                is ButtonNavKey -> NavEntry(key) {
                    ButtonScreen {
                        backStack.remove(key)
                    }
                }

                else -> error("Unknown key: $key")
            }
        }
    )
}
package com.lab.compose.navigation

import androidx.navigation3.runtime.EntryProviderBuilder
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entry
import com.lab.compose.presentation.ButtonScreen
import com.lab.compose.presentation.TextFiledScreen
import com.lab.compose.presentation.TextScreen

// --- components/ComponentNavGraph.kt ---
object ComponentNavGraph {
    fun register(
        backStack: NavBackStack,
        builder: EntryProviderBuilder<NavKey>
    ) = with(builder) {
        entry(ComponentScreen.Button) {
            ButtonScreen {
                backStack.removeLastOrNull()
            }
        }
        entry(ComponentScreen.TextField) {
            TextFiledScreen {
                backStack.removeLastOrNull()
            }
        }
        entry(ComponentScreen.Text) {
            TextScreen {
                backStack.removeLastOrNull()
            }
        }
    }
}
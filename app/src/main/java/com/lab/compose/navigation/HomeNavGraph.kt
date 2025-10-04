package com.lab.compose.navigation

import androidx.navigation3.runtime.EntryProviderBuilder
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entry
import com.lab.compose.model.MaterialComponentName
import com.lab.compose.presentation.MaterialComponentGrid


// --- home/HomeNavGraph.kt ---
object HomeNavGraph {
    fun register(
        backStack: NavBackStack,
        builder: EntryProviderBuilder<NavKey>
    ) = with(builder) {
        entry (HomeScreen.Home) {
            MaterialComponentGrid { component ->
                when (component) {
                    MaterialComponentName.Button -> backStack.add(ComponentScreen.Button)
                    MaterialComponentName.TextField -> backStack.add(ComponentScreen.TextField)
                    MaterialComponentName.Text -> backStack.add(ComponentScreen.Text)
                    MaterialComponentName.Checkbox -> backStack.add(ComponentScreen.CheckBox)
                    else -> {}
                }
            }
        }
    }
}

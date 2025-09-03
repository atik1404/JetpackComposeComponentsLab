package com.lab.compose.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
object HomeNavKey : NavKey

@Serializable
data class ButtonNavKey(val id: String) : NavKey

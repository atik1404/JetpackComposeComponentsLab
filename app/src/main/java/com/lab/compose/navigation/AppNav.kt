package com.lab.compose.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay

@Composable
fun AppNav() {
    val backStack = rememberNavBackStack(HomeScreen.Home)
    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        transitionSpec = {
            val dur = 700
            (slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Left,
                tween(dur)
            ) + fadeIn(tween(dur)))
                .togetherWith(
                    slideOutOfContainer(
                        AnimatedContentTransitionScope.SlideDirection.Left,
                        tween(dur)
                    ) + fadeOut(tween(dur))
                )
        },

        // POP (back) animation
        popTransitionSpec = {
            val dur = 700
            (slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Right,
                tween(dur)
            ) + fadeIn(tween(dur)))
                .togetherWith(
                    slideOutOfContainer(
                        AnimatedContentTransitionScope.SlideDirection.Right,
                        tween(dur)
                    ) + fadeOut(tween(dur))
                )
        },
        entryProvider = entryProvider {
            HomeNavGraph.register(backStack, this)
            ComponentNavGraph.register(backStack, this)
        }
    )
}
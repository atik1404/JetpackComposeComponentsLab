package com.lab.compose.navigation

import androidx.compose.runtime.staticCompositionLocalOf
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.first

// Result manager
class NavResultManager {
    private val bus = mutableMapOf<String, MutableSharedFlow<Any>>()

    @Suppress("UNCHECKED_CAST")
    fun <T : Any> results(key: String): Flow<T> =
        bus.getOrPut(key) { MutableSharedFlow(1) } as Flow<T>

    @Suppress("UNCHECKED_CAST")
    private fun <T : Any> flow(key: String): MutableSharedFlow<T> =
        bus.getOrPut(key) {
            MutableSharedFlow<Any>(
                replay = 0,
                extraBufferCapacity = 1
            )
        } as MutableSharedFlow<T>

    suspend fun <T : Any> set(key: String, value: T) {
        flow<T>(key).emit(value)
        bus.remove(key) // drop after first delivery to avoid replays/leaks
    }

    // suspend until the first value arrives, then return and clean up
    suspend fun <T : Any> awaitOnce(key: String): T {
        val f = flow<T>(key)
        val v = f.first()
        bus.remove(key)
        return v
    }

    fun cancel(key: String) { bus.remove(key) } // optional
}

val LocalNavResultManager = staticCompositionLocalOf { NavResultManager() }

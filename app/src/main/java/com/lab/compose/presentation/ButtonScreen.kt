package com.lab.compose.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import timber.log.Timber

@Composable
fun ButtonScreen(onClicked: (id: String) -> Unit) {
    Scaffold(
        //topBar = { TopAppBar(title = { Text("Button Demo") }) }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentAlignment = Alignment.Center
        ) {
            Button(onClick = {
                onClicked.invoke("123")
            }) {
                Text("Material Button")
            }
        }
    }
}
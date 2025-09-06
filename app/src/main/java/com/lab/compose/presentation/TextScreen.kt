package com.lab.compose.presentation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.lab.compose.R as Res
import com.lab.compose.designsystem.spacing.ElevationToken
import com.lab.compose.ui.common.AppToolbar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextScreen(onClicked: () -> Unit) {
    Scaffold(
        topBar = {
            AppToolbar(
                title = stringResource(Res.string.title_text),
                modifier = Modifier.fillMaxWidth(),
                elevation = ElevationToken.medium,
                onBackClick = { onClicked.invoke() }
            )
        }
    ) { padding ->
        Text(
            text = "Hello world ",
            modifier = Modifier.padding(padding)
        )
    }
}
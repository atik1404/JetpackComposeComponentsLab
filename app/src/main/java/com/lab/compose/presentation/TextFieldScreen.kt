package com.lab.compose.presentation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.lab.compose.designsystem.spacing.ElevationToken
import com.lab.compose.ui.common.AppToolbar
import com.lab.compose.R as Res

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFiledScreen(onClicked: () -> Unit) {
    Scaffold(
        topBar = {
            AppToolbar(
                title = stringResource(Res.string.title_text_field),
                modifier = Modifier.fillMaxWidth(),
                elevation = ElevationToken.medium,
                onBackClick = {onClicked.invoke()}
            )
        }
    ) { padding ->


        TextField(
            value = "",
            onValueChange = {},
            modifier = Modifier.padding(padding)
        )
    }
}
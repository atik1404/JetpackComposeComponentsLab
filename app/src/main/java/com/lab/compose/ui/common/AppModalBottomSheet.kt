package com.lab.compose.ui.common

import SpacingToken
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShowBottomSheet(
    onDismissRequest: () -> Unit,
    cancellable: Boolean = true,
) {
    val sheetState = rememberStandardBottomSheetState(
        skipHiddenState = !cancellable,
        confirmValueChange = { target ->
            !(!cancellable && target == SheetValue.Hidden) // don't let it hide
        }
    )
    ModalBottomSheet(
        onDismissRequest = onDismissRequest,
        sheetState = sheetState,
    ) {
        // Get the available height of the bottom sheet's layout scope
        BoxWithConstraints(
            modifier = Modifier.fillMaxWidth()
        ) {
            // maxHeight here is the full window height in Dp.
            // We'll allow the sheet content to grow up to 60% of that.
            val maxSheetHeight = maxHeight * 0.75f

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(max = maxSheetHeight) // ⬅ limit how tall the sheet can get
            ) {
                // Header row
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = SpacingToken.medium)
                ) {
                    Text(
                        text = "Bottom sheet title",
                        modifier = Modifier.weight(1f),
                        fontWeight = FontWeight.Bold
                    )

                    IconButton(onClick = onDismissRequest) {
                        Icon(
                            imageVector = Icons.Default.Clear,
                            contentDescription = "Close"
                        )
                    }
                }

                // Divider
                Spacer(
                    modifier = Modifier
                        .height(1.dp)
                        .fillMaxWidth()
                        .background(Color.Gray)
                )

                // Scrollable content
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = SpacingToken.medium)
                ) {
                    items(102) { index ->
                        Text(
                            text = "Item $index",
                            modifier = Modifier.padding(vertical = SpacingToken.medium)
                        )
                    }
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
@PreviewLightDark
fun ModalPreview() {
    ShowBottomSheet(onDismissRequest = {})
}
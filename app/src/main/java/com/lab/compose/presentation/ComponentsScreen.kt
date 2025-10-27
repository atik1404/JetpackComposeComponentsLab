package com.lab.compose.presentation

import LightDarkPreview
import SpacingToken
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import appHorizontalArrangement
import appVerticalArrangement
import com.lab.compose.designsystem.spacing.ElevationToken
import com.lab.compose.designsystem.spacing.IconSizeToken
import com.lab.compose.designsystem.spacing.RadiusToken
import com.lab.compose.designsystem.theme.AppTheme
import com.lab.compose.designsystem.typography.AppTypography
import com.lab.compose.model.materialComponents
import com.lab.compose.ui.common.AppToolbar
import com.lab.compose.ui.components.AppText
import com.lab.compose.R as Res
import com.lab.compose.model.MaterialComponentEntity
import com.lab.compose.model.MaterialComponentName
import com.lab.compose.ui.common.AppDatePickerDialog
import com.lab.compose.ui.common.ShowBottomSheet
import timber.log.Timber

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MaterialComponentGrid(onItemClicked: (component: MaterialComponentName) -> Unit) {
    Scaffold(
        topBar = {
            AppToolbar(
                title = stringResource(Res.string.title_home),
                modifier = Modifier.fillMaxWidth(),
                elevation = ElevationToken.medium
            )
        }
    ) { padding ->
        var showBottomSheet by rememberSaveable { mutableStateOf(false) }
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .padding(padding),
            contentPadding = PaddingValues(SpacingToken.small),
            verticalArrangement = appVerticalArrangement(SpacingToken.medium),
            horizontalArrangement = appHorizontalArrangement(SpacingToken.medium)
        ) {
            items(materialComponents.size) { index ->
                val component = materialComponents[index]
                BuildItemCard(component) { item ->
                    showBottomSheet = true
                    //onItemClicked(item)
                }
            }
        }
        if(showBottomSheet){
//            ShowBottomSheet(
//                onDismissRequest = {
//                    showBottomSheet = false
//                }
//            )

            AppDatePickerDialog(
                onDismissRequest = {
                    showBottomSheet = false
                },
                onConfirm = {
                    Timber.e("selectedDate: $it")
                    showBottomSheet = false
                }
            )
        }
    }
}

@Composable
fun BuildItemCard(
    component: MaterialComponentEntity,
    onItemClicked: (component: MaterialComponentName) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(RadiusToken.medium))
            .clickable {
                onItemClicked(component.name)
            },
        elevation = CardDefaults.cardElevation(ElevationToken.small)
    ) {
        Column(
            modifier = Modifier
                .padding(SpacingToken.large)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BuildItemIcon(component.icon)
            Spacer(modifier = Modifier.height(SpacingToken.medium))
            BuildItemText(component.name.name)
        }
    }
}

@Composable
fun BuildItemIcon(icon: ImageVector) {
    Icon(
        imageVector = icon,
        contentDescription = "Content Description",
        modifier = Modifier.size(IconSizeToken.large)
    )
}

@Composable
fun BuildItemText(componentName: String) {
    AppText(
        text = componentName,
        modifier = Modifier.fillMaxWidth(),
        alignment = TextAlign.Center,
        textStyle = AppTypography.bodySmall
    )
}


@Composable
@LightDarkPreview
//@TabletPreview
fun CardPreview() {
    AppTheme {
        MaterialComponentGrid {

        }
    }
}
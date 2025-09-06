package com.lab.compose.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.CheckBox
import androidx.compose.material.icons.filled.DragIndicator
import androidx.compose.material.icons.filled.FontDownload
import androidx.compose.material.icons.filled.Inbox
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.TextFields
import androidx.compose.material.icons.filled.ToggleOn
import androidx.compose.material.icons.filled.TouchApp
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material.icons.filled.ViewComfy
import androidx.compose.material.icons.filled.ViewHeadline
import androidx.compose.ui.graphics.vector.ImageVector

data class MaterialComponentEntity(
    val name: MaterialComponentName,
    val icon: ImageVector
)

val materialComponents = listOf(
    MaterialComponentEntity(MaterialComponentName.Button, Icons.Default.TouchApp),
    MaterialComponentEntity(MaterialComponentName.TextField, Icons.Default.TextFields),
    MaterialComponentEntity(MaterialComponentName.Text, Icons.Default.FontDownload),
    MaterialComponentEntity(MaterialComponentName.Checkbox, Icons.Default.CheckBox),
    MaterialComponentEntity(MaterialComponentName.Switch, Icons.Default.ToggleOn),
    MaterialComponentEntity(MaterialComponentName.Slider, Icons.Default.Tune),
    MaterialComponentEntity(MaterialComponentName.Card, Icons.Default.ViewComfy),
    MaterialComponentEntity(MaterialComponentName.Dialog, Icons.Default.Inbox),
    MaterialComponentEntity(MaterialComponentName.DropdownMenu, Icons.Default.ArrowDropDown),
    MaterialComponentEntity(MaterialComponentName.TopAppBar, Icons.Default.ViewHeadline),
    MaterialComponentEntity(MaterialComponentName.BottomAppBar, Icons.Default.Menu),
    MaterialComponentEntity(MaterialComponentName.FAB, Icons.Default.Add),
    MaterialComponentEntity(MaterialComponentName.NavigationDrawer, Icons.Default.DragIndicator)
)


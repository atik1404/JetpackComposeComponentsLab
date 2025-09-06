package com.lab.compose.presentation

import LightDarkPreview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material.icons.rounded.Code
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.SkipNext
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MultiChoiceSegmentedButtonRow
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.lab.compose.designsystem.spacing.ElevationToken
import com.lab.compose.designsystem.theme.AppTheme
import com.lab.compose.designsystem.theme.backgroundColors
import com.lab.compose.ui.common.AppToolbar
import com.lab.compose.R as Res


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ButtonScreen(onClicked: () -> Unit) {
    Scaffold(
        topBar = {
            AppToolbar(
                title = stringResource(Res.string.title_button),
                modifier = Modifier.fillMaxWidth(),
                elevation = ElevationToken.medium,
                onBackClick = { onClicked.invoke() }
            )
        }
    ) { padding ->
        var segIndex by remember { mutableIntStateOf(0) }
        var segMulti by remember { mutableStateOf(setOf(0, 2)) }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(padding)
                .background(MaterialTheme.backgroundColors.primary),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            FilledButtonPlain(text = "Primary", onClick = {})
            FilledButtonWithIcons(
                text = "Continue",
                onClick = {},
                leading = Icons.Rounded.Check,
                trailing = Icons.Rounded.Code
            )

            ElevatedButtonPlain(text = "Elevated", onClick = {})
            ElevatedButtonWithIcons(text = "Add item", onClick = {}, leading = Icons.Rounded.Add)

            TonalButtonPlain(text = "Tonal", onClick = {})
            TonalButtonWithIcons(text = "Edit", onClick = {}, trailing = Icons.Rounded.Edit)

            OutlinedButtonPlain(text = "Cancel", onClick = {})
            OutlinedButtonWithIcons(text = "Next", onClick = {}, trailing = Icons.Rounded.SkipNext)

            TextButtonPlain(text = "Plain text Button", onClick = {})
            TextButtonWithIcons(text = "Learn more", onClick = {}, trailing = Icons.Rounded.Info)

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                IconButtonStandard(onClick = {}, icon = Icons.Rounded.Edit)
                IconButtonFilled(onClick = {}, icon = Icons.Rounded.Check)
                IconButtonTonal(onClick = {}, icon = Icons.Rounded.Add)
                IconButtonOutlined(onClick = {}, icon = Icons.Rounded.Code)
            }

            Spacer(Modifier.height(8.dp))
            SingleChoiceSegmentsPlain(
                options = listOf("Day", "Week", "Month"),
                selectedIndex = segIndex,
                onSelected = { segIndex = it }
            )

            SingleChoiceSegmentsWithIcons(
                options = listOf(
                    Pair(Icons.Rounded.Add, "On"),
                    Pair(Icons.Rounded.Home, "Off"),
                ),
                selectedIndex = segIndex.coerceIn(0, 1),
                onSelected = { segIndex = it }
            )

            MultiChoiceSegmentsPlain(
                options = listOf("A", "B", "C"),
                selected = segMulti,
                onSelectedChange = { segMulti = it }
            )
        }
    }
}


@Composable
fun FilledButtonPlain(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    enabled: Boolean = true,
) {
    Button(onClick = onClick, enabled = enabled, modifier = modifier) {
        Text(text)
    }
}

@Composable
fun FilledButtonWithIcons(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    leading: ImageVector? = null,
    trailing: ImageVector? = null,
    enabled: Boolean = true,
) {
    Button(onClick = onClick, enabled = enabled, modifier = modifier) {
        Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
            if (leading != null) {
                Icon(leading, contentDescription = null)
                Spacer(Modifier.width(8.dp))
            }
            Text(text)
            if (trailing != null) {
                Spacer(Modifier.width(8.dp))
                Icon(trailing, contentDescription = null)
            }
        }
    }
}

/* ---------- Elevated Button ---------- */

@Composable
fun ElevatedButtonPlain(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    enabled: Boolean = true,
) {
    ElevatedButton(onClick = onClick, enabled = enabled, modifier = modifier) {
        Text(text)
    }
}

@Composable
fun ElevatedButtonWithIcons(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    leading: ImageVector? = null,
    trailing: ImageVector? = null,
    enabled: Boolean = true,
) {
    ElevatedButton(onClick = onClick, enabled = enabled, modifier = modifier) {
        if (leading != null) {
            Icon(leading, contentDescription = null)
            Spacer(Modifier.width(8.dp))
        }
        Text(text)
        if (trailing != null) {
            Spacer(Modifier.width(8.dp))
            Icon(trailing, contentDescription = null)
        }
    }
}

/* ---------- Filled Tonal Button ---------- */

@Composable
fun TonalButtonPlain(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    enabled: Boolean = true,
) {
    FilledTonalButton(onClick = onClick, enabled = enabled, modifier = modifier) {
        Text(text)
    }
}

@Composable
fun TonalButtonWithIcons(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    leading: ImageVector? = null,
    trailing: ImageVector? = null,
    enabled: Boolean = true,
) {
    FilledTonalButton(onClick = onClick, enabled = enabled, modifier = modifier) {
        if (leading != null) {
            Icon(leading, contentDescription = null)
            Spacer(Modifier.width(8.dp))
        }
        Text(text)
        if (trailing != null) {
            Spacer(Modifier.width(8.dp))
            Icon(trailing, contentDescription = null)
        }
    }
}

/* ---------- Outlined Button ---------- */

@Composable
fun OutlinedButtonPlain(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    enabled: Boolean = true
) {
    OutlinedButton(onClick = onClick, enabled = enabled, modifier = modifier) {
        Text(text)
    }
}

@Composable
fun OutlinedButtonWithIcons(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    leading: ImageVector? = null,
    trailing: ImageVector? = null,
    enabled: Boolean = true,
) {
    OutlinedButton(onClick = onClick, enabled = enabled, modifier = modifier) {
        if (leading != null) {
            Icon(leading, contentDescription = null)
            Spacer(Modifier.width(8.dp))
        }
        Text(text)
        if (trailing != null) {
            Spacer(Modifier.width(8.dp))
            Icon(trailing, contentDescription = null)
        }
    }
}

/* ---------- Text Button ---------- */

@Composable
fun TextButtonPlain(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    enabled: Boolean = true,
) {
    TextButton(onClick = onClick, enabled = enabled, modifier = modifier) {
        Text(text)
    }
}

@Composable
fun TextButtonWithIcons(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    leading: ImageVector? = null,
    trailing: ImageVector? = null,
    enabled: Boolean = true,
) {
    TextButton(onClick = onClick, enabled = enabled, modifier = modifier) {
        if (leading != null) {
            Icon(leading, contentDescription = null)
            Spacer(Modifier.width(8.dp))
        }
        Text(text)
        if (trailing != null) {
            Spacer(Modifier.width(8.dp))
            Icon(trailing, contentDescription = null)
        }
    }
}

/* ---------- Icon Buttons (icon-only; no leading/trailing concept) ---------- */

@Composable
fun IconButtonStandard(onClick: () -> Unit, icon: ImageVector, enabled: Boolean = true) {
    IconButton(onClick = onClick, enabled = enabled) {
        Icon(icon, contentDescription = null)
    }
}

@Composable
fun IconButtonFilled(onClick: () -> Unit, icon: ImageVector, enabled: Boolean = true) {
    FilledIconButton(onClick = onClick, enabled = enabled) {
        Icon(icon, contentDescription = null)
    }
}

@Composable
fun IconButtonTonal(onClick: () -> Unit, icon: ImageVector, enabled: Boolean = true) {
    FilledTonalIconButton(onClick = onClick, enabled = enabled) {
        Icon(icon, contentDescription = null)
    }
}

@Composable
fun IconButtonOutlined(onClick: () -> Unit, icon: ImageVector, enabled: Boolean = true) {
    OutlinedIconButton(onClick = onClick, enabled = enabled) {
        Icon(icon, contentDescription = null)
    }
}

/* ---------- Segmented Buttons ---------- */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SingleChoiceSegmentsPlain(
    options: List<String>,
    selectedIndex: Int,
    onSelected: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    SingleChoiceSegmentedButtonRow(modifier) {
        options.forEachIndexed { index, label ->
            SegmentedButton(
                selected = index == selectedIndex,
                onClick = { onSelected(index) },
                shape = SegmentedButtonDefaults.itemShape(index, options.size)
            ) {
                Text(label, modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp))
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SingleChoiceSegmentsWithIcons(
    options: List<Pair<ImageVector, String>>,
    selectedIndex: Int,
    onSelected: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    SingleChoiceSegmentedButtonRow(modifier) {
        options.forEachIndexed { index, (icon, label) ->
            SegmentedButton(
                selected = index == selectedIndex,
                onClick = { onSelected(index) },
                shape = SegmentedButtonDefaults.itemShape(index, options.size)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Spacer(Modifier.width(6.dp))
                    Text(label)
                    Icon(icon, contentDescription = null)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MultiChoiceSegmentsPlain(
    options: List<String>,
    selected: Set<Int>,
    onSelectedChange: (Set<Int>) -> Unit,
    modifier: Modifier = Modifier
) {
    MultiChoiceSegmentedButtonRow(modifier) {
        options.forEachIndexed { index, label ->
            val isSelected = index in selected
            SegmentedButton(
                checked = isSelected,
                onCheckedChange = {
                    onSelectedChange(selected.toMutableSet().apply {
                        if (isSelected) remove(index) else add(index)
                    })
                },
                shape = SegmentedButtonDefaults.itemShape(index, options.size)
            ) {
                Text(label, modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp))
            }
        }
    }
}

@Composable
@LightDarkPreview
fun ButtonScreenPreview() {
    AppTheme {
        ButtonScreen {

        }
    }
}
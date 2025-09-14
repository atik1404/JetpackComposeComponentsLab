import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.state.ToggleableState
import com.lab.compose.designsystem.spacing.ElevationToken
import com.lab.compose.designsystem.theme.AppTheme
import com.lab.compose.ui.common.AppToolbar
import com.lab.compose.R as Res

// ---- Your screen: calls ALL examples below ----
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CheckboxScreen(onClicked: () -> Unit) {
    Scaffold(
        topBar = {
            AppToolbar(
                title = stringResource(Res.string.title_checkbox),
                modifier = Modifier.fillMaxWidth(),
                elevation = ElevationToken.medium,
                onBackClick = { onClicked.invoke() }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item { FilledCheckboxSample() }
            item { Divider() }
            item { OutlinedCheckboxSample() }
            item { RoundedBorderCheckboxSample() }
            item { CapsuleCheckboxSample() }
            item { CheckboxWithLeadingIconSample() }
            item { CheckboxWithTrailingIconSample() }
            item { ClickableRowCheckboxSample() }
            item { MultilineLabelCheckboxSample() }
            item { MultiColorCheckboxSample() }
            item { TriStateCheckboxSample() }
        }
    }
}


/* ---------- 1) Filled (default) ---------- */
@Composable
fun FilledCheckboxSample() {
    var checked by rememberSaveable { mutableStateOf(false) }
    Row(verticalAlignment = Alignment.CenterVertically) {
        Checkbox(checked = checked, onCheckedChange = { checked = it })
        Spacer(Modifier.width(12.dp))
        Text("Filled checkbox (default)")
    }
}

/* ---------- 2) Outlined container around checkbox ---------- */
@Composable
fun OutlinedCheckboxSample() {
    var checked by rememberSaveable { mutableStateOf(false) }
    Surface(
        shape = RoundedCornerShape(12.dp),
        tonalElevation = 0.dp,
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .toggleable(
                    value = checked,
                    role = Role.Checkbox,
                    onValueChange = { checked = it }
                )
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(checked = checked, onCheckedChange = null)
            Spacer(Modifier.width(12.dp))
            Text("Outlined container + full-row toggle")
        }
    }
}

/* ---------- 3) Rounded border (pill-ish container) ---------- */
@Composable
fun RoundedBorderCheckboxSample() {
    var checked by rememberSaveable { mutableStateOf(false) }
    val shape = RoundedCornerShape(20.dp)
    val stroke =
        if (checked) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outline
    Row(
        modifier = Modifier
            .border(1.dp, stroke, shape)
            .clip(shape)
            .toggleable(value = checked, onValueChange = { checked = it }, role = Role.Checkbox)
            .padding(horizontal = 14.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(checked = checked, onCheckedChange = null)
        Spacer(Modifier.width(10.dp))
        Text("Rounded border container")
    }
}

/* ---------- 4) Capsule (custom pill checkbox) ---------- */
@Composable
fun CapsuleCheckboxSample() {
    var checked by rememberSaveable { mutableStateOf(false) }
    val shape = CircleShape
    val container =
        if (checked) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.surface
    val border =
        if (checked) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outline

    Row(
        modifier = Modifier
            .clip(shape)
            .border(1.dp, border, shape)
            .background(container)
            .toggleable(value = checked, onValueChange = { checked = it }, role = Role.Checkbox)
            .padding(horizontal = 14.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (checked) {
            Icon(Icons.Filled.Check, contentDescription = null)
        } else {
            Box(
                Modifier
                    .size(20.dp)
                    .border(2.dp, MaterialTheme.colorScheme.outline, CircleShape)
            )
        }
        Spacer(Modifier.width(10.dp))
        Text("Capsule-style checkbox")
    }
}

/* ---------- 5) Leading icon + checkbox ---------- */
@Composable
fun CheckboxWithLeadingIconSample() {
    var checked by rememberSaveable { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .toggleable(value = checked, onValueChange = { checked = it }, role = Role.Checkbox),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(Icons.Filled.Info, contentDescription = null)
        Spacer(Modifier.width(10.dp))
        Checkbox(checked = checked, onCheckedChange = null)
        Spacer(Modifier.width(10.dp))
        Text("Leading icon + checkbox")
    }
}

/* ---------- 6) Trailing icon ---------- */
@Composable
fun CheckboxWithTrailingIconSample() {
    var checked by rememberSaveable { mutableStateOf(true) }
    Row(
        modifier = Modifier
            .toggleable(value = checked, onValueChange = { checked = it }, role = Role.Checkbox),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(checked = checked, onCheckedChange = null)
        Spacer(Modifier.width(10.dp))
        Text("Checkbox with trailing icon")
        Spacer(Modifier.width(10.dp))
        Icon(Icons.Filled.Info, contentDescription = null)
    }
}

/* ---------- 7) Clickable full row (ripple, proper a11y) ---------- */
@Composable
fun ClickableRowCheckboxSample() {
    var checked by rememberSaveable { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .toggleable(value = checked, onValueChange = { checked = it }, role = Role.Checkbox)
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(checked = checked, onCheckedChange = null)
        Spacer(Modifier.width(12.dp))
        Column {
            Text("Full row is clickable")
            Text(
                "Uses Modifier.toggleable(Role.Checkbox) for correct semantics.",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

/* ---------- 8) Multiline label ---------- */
@Composable
fun MultilineLabelCheckboxSample() {
    var checked by rememberSaveable { mutableStateOf(true) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .toggleable(value = checked, onValueChange = { checked = it }, role = Role.Checkbox),
        verticalAlignment = Alignment.Top
    ) {
        Checkbox(checked = checked, onCheckedChange = null)
        Spacer(Modifier.width(12.dp))
        Text(
            text = "This is a longer, multiline label that wraps to the next line " +
                    "and demonstrates vertical alignment to the top.",
            maxLines = 3,
            overflow = TextOverflow.Ellipsis
        )
    }
}

/* ---------- 9) Multi-color checkboxes ---------- */
@Composable
fun MultiColorCheckboxSample() {
    var red by rememberSaveable { mutableStateOf(false) }
    var green by rememberSaveable { mutableStateOf(true) }
    var amber by rememberSaveable { mutableStateOf(false) }

    Column {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = red,
                onCheckedChange = { red = it },
                colors = CheckboxDefaults.colors(
                    checkedColor = Color(0xFFEF5350),       // Red 400
                    uncheckedColor = Color(0xFFEF9A9A),     // Red 200
                    checkmarkColor = Color.White
                )
            )
            Spacer(Modifier.width(8.dp))
            Text("Red themed")
        }
        Spacer(Modifier.height(8.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = green,
                onCheckedChange = { green = it },
                colors = CheckboxDefaults.colors(
                    checkedColor = Color(0xFF66BB6A),       // Green 400
                    uncheckedColor = Color(0xFFA5D6A7),     // Green 200
                    checkmarkColor = Color.White
                )
            )
            Spacer(Modifier.width(8.dp))
            Text("Green themed")
        }
        Spacer(Modifier.height(8.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = amber,
                onCheckedChange = { amber = it },
                colors = CheckboxDefaults.colors(
                    checkedColor = Color(0xFFFFB300),       // Amber 600
                    uncheckedColor = Color(0xFFFFE082),     // Amber 200
                    checkmarkColor = Color.Black
                )
            )
            Spacer(Modifier.width(8.dp))
            Text("Amber themed")
        }
    }
}

/* ---------- 10) Tri-state (Indeterminate) ---------- */
@Composable
fun TriStateCheckboxSample() {
    var state by rememberSaveable { mutableStateOf(ToggleableState.Indeterminate) }

    fun next(s: ToggleableState) = when (s) {
        ToggleableState.Off -> ToggleableState.On
        ToggleableState.On -> ToggleableState.Off
        ToggleableState.Indeterminate -> ToggleableState.On
    }

    Row(
        modifier = Modifier
            .toggleable(
                value = state == ToggleableState.On,
                onValueChange = { state = next(state) },
                role = Role.Checkbox
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TriStateCheckbox(
            state = state,
            onClick = { state = next(state) }
        )
        Spacer(Modifier.width(12.dp))
        Text("Tri-state checkbox: $state")
    }
}

@Composable
@LightDarkPreview
fun CheckboxScreenPreview() {
    AppTheme {
        CheckboxScreen(onClicked = {})
    }
}
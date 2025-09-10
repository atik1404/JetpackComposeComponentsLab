package com.lab.compose.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
                onBackClick = { onClicked.invoke() }
            )
        }
    ) { padding ->
        val scroll = rememberScrollState()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(scroll),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            SectionTitle("Filled")
            FilledTextFieldSample()

            SectionTitle("Outlined")
            OutlinedTextFieldSample()

            SectionTitle("Rounded Border (Outlined + RoundedCornerShape)")
            RoundedBorderTextFieldSample()

            SectionTitle("Capsule / Pill Shape")
            CapsuleTextFieldSample()

            SectionTitle("Leading Icon")
            LeadingIconTextFieldSample()

            SectionTitle("Trailing Icon")
            TrailingIconTextFieldSample()

            SectionTitle("Hint (label)")
            HintTextFieldSample()

            SectionTitle("Placeholder")
            PlaceholderTextFieldSample()

            SectionTitle("Clickable (read-only)")
            ClickableTextFieldSample(onClick = { /* open a picker */ })

            SectionTitle("Multiline")
            MultilineTextFieldSample()

            SectionTitle("Password (with visibility toggle)")
            PasswordTextFieldSample()
        }
    }
}


/* ------------------------------- Pieces ------------------------------- */

@Composable
private fun SectionTitle(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.titleMedium,
        color = MaterialTheme.colorScheme.primary
    )
}

/** 1) Filled TextField */
@Composable
fun FilledTextFieldSample() {
    var value by rememberSaveable { mutableStateOf("") }
    val fm = LocalFocusManager.current
    TextField(
        value = value,
        onValueChange = { value = it },
        label = { Text("Full name") },
        singleLine = true,
        leadingIcon = { Icon(Icons.Default.Person, contentDescription = null) },
        keyboardOptions = androidx.compose.foundation.text.KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
        keyboardActions = androidx.compose.foundation.text.KeyboardActions(onDone = { fm.clearFocus() }),
        modifier = Modifier.fillMaxWidth()
    )
}

/** 2) Outlined TextField */
@Composable
fun OutlinedTextFieldSample() {
    var value by rememberSaveable { mutableStateOf("") }
    OutlinedTextField(
        value = value,
        onValueChange = { value = it },
        label = { Text("Email") },
        singleLine = true,
        leadingIcon = { Icon(Icons.Default.Email, contentDescription = null) },
        keyboardOptions = androidx.compose.foundation.text.KeyboardOptions(keyboardType = KeyboardType.Email),
        modifier = Modifier.fillMaxWidth()
    )
}

/** 3) Rounded Border (Outlined with custom shape) */
@Composable
fun RoundedBorderTextFieldSample() {
    var value by rememberSaveable { mutableStateOf("") }
    OutlinedTextField(
        value = value,
        onValueChange = { value = it },
        label = { Text("Username") },
        singleLine = true,
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.fillMaxWidth()
    )
}

/** 4) Capsule / Pill Shape (filled container + CircleShape) */
@Composable
fun CapsuleTextFieldSample() {
    var value by rememberSaveable { mutableStateOf("") }
    TextField(
        value = value,
        onValueChange = { value = it },
        placeholder = { Text("Search anything…") },
        singleLine = true,
        leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
        shape = CircleShape,
        modifier = Modifier.fillMaxWidth()
    )
}

/** 5) Leading Icon only */
@Composable
fun LeadingIconTextFieldSample() {
    var value by rememberSaveable { mutableStateOf("") }
    OutlinedTextField(
        value = value,
        onValueChange = { value = it },
        label = { Text("Phone") },
        singleLine = true,
        leadingIcon = { Icon(Icons.Default.Phone, contentDescription = null) },
        keyboardOptions = androidx.compose.foundation.text.KeyboardOptions(keyboardType = KeyboardType.Phone),
        modifier = Modifier.fillMaxWidth()
    )
}

/** 6) Trailing Icon only */
@Composable
fun TrailingIconTextFieldSample() {
    var value by rememberSaveable { mutableStateOf("") }
    OutlinedTextField(
        value = value,
        onValueChange = { value = it },
        label = { Text("Message") },
        singleLine = true,
        trailingIcon = { Icon(Icons.Default.Send, contentDescription = null) },
        modifier = Modifier.fillMaxWidth()
    )
}

/** 7) Hint via label (Material floating label) */
@Composable
fun HintTextFieldSample() {
    var value by rememberSaveable { mutableStateOf("") }
    TextField(
        value = value,
        onValueChange = { value = it },
        label = { Text("National ID (label as hint)") },
        singleLine = true,
        modifier = Modifier.fillMaxWidth()
    )
}

/** 8) Placeholder (visible when empty & not focused) */
@Composable
fun PlaceholderTextFieldSample() {
    var value by rememberSaveable { mutableStateOf("") }
    OutlinedTextField(
        value = value,
        onValueChange = { value = it },
        placeholder = { Text("e.g., Dhaka, Bangladesh") },
        singleLine = true,
        modifier = Modifier.fillMaxWidth()
    )
}

/** 9) Clickable (read-only) with overlay */
@Composable
fun ClickableTextFieldSample(onClick: () -> Unit) {
    var value by rememberSaveable { mutableStateOf("Tap to pick a date") }
    Box(modifier = Modifier.fillMaxWidth()) {
        OutlinedTextField(
            value = value,
            onValueChange = {},
            readOnly = true,
            label = { Text("Date") },
            trailingIcon = { Icon(Icons.Default.CalendarToday, contentDescription = null) },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(
            modifier = Modifier
                .matchParentSize()
                .clickable {
                    value = "2025-09-10"
                    onClick()
                }
        )
    }
}

/** 10) Multiline TextField with counter */
@Composable
fun MultilineTextFieldSample() {
    var value by rememberSaveable { mutableStateOf("") }
    val maxChars = 200
    OutlinedTextField(
        value = value,
        onValueChange = { if (it.length <= maxChars) value = it },
        label = { Text("Address (multiline)") },
        placeholder = { Text("House, Street, City, ZIP") },
        minLines = 3,
        maxLines = 6,
        supportingText = { Text("${value.length} / $maxChars") },
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 120.dp)
    )
}

/** 11) Password with visibility toggle */
@Composable
fun PasswordTextFieldSample() {
    var password by rememberSaveable { mutableStateOf("") }
    var visible by rememberSaveable { mutableStateOf(false) }
    val fm = LocalFocusManager.current

    OutlinedTextField(
        value = password,
        onValueChange = { password = it },
        label = { Text("Password") },
        leadingIcon = { Icon(Icons.Default.Lock, contentDescription = null) },
        trailingIcon = {
            IconButton(onClick = { visible = !visible }) {
                Icon(
                    imageVector = if (visible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                    contentDescription = if (visible) "Hide password" else "Show password"
                )
            }
        },
        singleLine = true,
        visualTransformation = if (visible) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = androidx.compose.foundation.text.KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        ),
        keyboardActions = androidx.compose.foundation.text.KeyboardActions(onDone = { fm.clearFocus() }),
        modifier = Modifier.fillMaxWidth()
    )
}

/* ------------------------------- Previews ------------------------------- */

@Composable
private fun PreviewContainer(content: @Composable () -> Unit) {
    MaterialTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                content()
            }
        }
    }
}

/* Overall screen previews */
@Preview(showBackground = true, name = "Showcase - Light")
@Composable
private fun Preview_TextFieldShowcase_Light() = PreviewContainer { TextFiledScreen { } }

@Preview(showBackground = true, name = "Showcase - Dark")
@Composable
private fun Preview_TextFieldShowcase_Dark() {
    MaterialTheme(colorScheme = darkColorScheme()) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            TextFiledScreen { }
        }
    }
}

/* Individual example previews */

@Preview(showBackground = true, name = "Filled")
@Composable
private fun Preview_FilledTextField() = PreviewContainer { FilledTextFieldSample() }

@Preview(showBackground = true, name = "Outlined")
@Composable
private fun Preview_OutlinedTextField() = PreviewContainer { OutlinedTextFieldSample() }

@Preview(showBackground = true, name = "Rounded Border")
@Composable
private fun Preview_RoundedBorderTextField() = PreviewContainer { RoundedBorderTextFieldSample() }

@Preview(showBackground = true, name = "Capsule / Pill")
@Composable
private fun Preview_CapsuleTextField() = PreviewContainer { CapsuleTextFieldSample() }

@Preview(showBackground = true, name = "Leading Icon")
@Composable
private fun Preview_LeadingIconTextField() = PreviewContainer { LeadingIconTextFieldSample() }

@Preview(showBackground = true, name = "Trailing Icon")
@Composable
private fun Preview_TrailingIconTextField() = PreviewContainer { TrailingIconTextFieldSample() }

@Preview(showBackground = true, name = "Hint (Label)")
@Composable
private fun Preview_HintTextField() = PreviewContainer { HintTextFieldSample() }

@Preview(showBackground = true, name = "Placeholder")
@Composable
private fun Preview_PlaceholderTextField() = PreviewContainer { PlaceholderTextFieldSample() }

@Preview(showBackground = true, name = "Clickable (Read-only)")
@Composable
private fun Preview_ClickableTextField() =
    PreviewContainer { ClickableTextFieldSample(onClick = {}) }

@Preview(showBackground = true, name = "Multiline")
@Composable
private fun Preview_MultilineTextField() = PreviewContainer { MultilineTextFieldSample() }

@Preview(showBackground = true, name = "Password")
@Composable
private fun Preview_PasswordTextField() = PreviewContainer { PasswordTextFieldSample() }

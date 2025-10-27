package com.lab.compose.presentation

import LightDarkPreview
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.SentimentDissatisfied
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.lab.compose.designsystem.spacing.ElevationToken
import com.lab.compose.designsystem.spacing.RadiusToken
import com.lab.compose.designsystem.theme.AppTheme
import com.lab.compose.designsystem.theme.backgroundColors
import com.lab.compose.designsystem.theme.strokeColors
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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(MaterialTheme.backgroundColors.primary)
                .padding(padding)
                .padding(SpacingToken.medium),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            BoxTextFieldSample()
            SectionTitle("Filled")
            FilledTextFieldSample()
            Spacer(Modifier.height(SpacingToken.extraSmall))

            SectionTitle("Outlined")
            OutlinedTextFieldSample()
            Spacer(Modifier.height(SpacingToken.extraSmall))

            SectionTitle("Rounded Border (Outlined + RoundedCornerShape)")
            RoundedBorderTextFieldSample()
            Spacer(Modifier.height(SpacingToken.extraSmall))

            SectionTitle("Capsule / Pill Shape")
            CapsuleTextFieldSample()
            Spacer(Modifier.height(SpacingToken.extraSmall))

            SectionTitle("Leading Icon")
            LeadingIconTextFieldSample()
            Spacer(Modifier.height(SpacingToken.extraSmall))

            SectionTitle("Trailing Icon")
            TrailingIconTextFieldSample()
            Spacer(Modifier.height(SpacingToken.extraSmall))

            SectionTitle("Hint (label)")
            HintTextFieldSample()
            Spacer(Modifier.height(SpacingToken.extraSmall))

            SectionTitle("Placeholder")
            PlaceholderTextFieldSample()
            Spacer(Modifier.height(SpacingToken.extraSmall))

            SectionTitle("Clickable (read-only)")
            ClickableTextFieldSample(onClick = { /* open a picker */ })
            Spacer(Modifier.height(SpacingToken.extraSmall))

            SectionTitle("Multiline")
            MultilineTextFieldSample()
            Spacer(Modifier.height(SpacingToken.extraSmall))

            SectionTitle("Password (with visibility toggle)")
            PasswordTextFieldSample()
            Spacer(Modifier.height(SpacingToken.extraSmall))


            var text by remember { mutableStateOf("") }

            val cities = listOf(
                "Dhaka",
                "Chattogram",
                "Rajshahi",
                "Khulna",
                "Sylhet",
                "Barishal",
                "Rangpur",
                "Mymensingh"
            )

            AutoCompleteTextField(
                label = "Select City",
                allOptions = cities,
                value = text,
                onValueChange = { text = it },
                onOptionSelected = { selected ->
                    // you can do extra work here if needed
                    // e.g. close keyboard, trigger API, etc.
                    println("User picked: $selected")
                }
            )
        }
    }
}


/* ------------------------------- Pieces ------------------------------- */

@Composable
private fun SectionTitle(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.bodySmall,
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
        modifier = Modifier.fillMaxWidth(),
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,   // ← hide underline
            unfocusedIndicatorColor = Color.Transparent,
        )
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
        trailingIcon = { Icon(Icons.Default.SentimentDissatisfied, contentDescription = null) },
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

@Composable
fun BoxTextFieldSample() {
    Column {
        Text(
            text = "Sample Text in Box",
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Light
        )
        Spacer(modifier = Modifier.height(SpacingToken.micro))

        var text by rememberSaveable { mutableStateOf("") }

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            placeholder = { Text("Search anything…") },
            singleLine = true,
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
            shape = RoundedCornerShape(RadiusToken.large),
            modifier = Modifier
                .fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.backgroundColors.primary,
                unfocusedContainerColor = MaterialTheme.backgroundColors.primary,
                disabledContainerColor = MaterialTheme.backgroundColors.primary,
                errorContainerColor = MaterialTheme.backgroundColors.primary,
                focusedIndicatorColor = MaterialTheme.strokeColors.primary,
                unfocusedIndicatorColor = MaterialTheme.strokeColors.primary,
            )
        )

        Spacer(modifier = Modifier.height(SpacingToken.micro))

        Text(
            text = "Invalid TextField Example",
            color = MaterialTheme.colorScheme.error,
            style = MaterialTheme.typography.bodySmall,
            fontWeight = FontWeight.Light
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AutoCompleteTextField(
    modifier: Modifier = Modifier,
    label: String = "",
    allOptions: List<String>,
    value: String,
    onValueChange: (String) -> Unit,
    onOptionSelected: (String) -> Unit = {},
    enabled: Boolean = true,
    isError: Boolean = false,
    supportingText: String? = null,
) {
    var expanded by remember { mutableStateOf(false) }

    // filter suggestions based on current text
//    val filteredOptions = remember(value, allOptions) {
//        if (value.isBlank()) {
//            allOptions   // or emptyList() if you don't want to show all initially
//        } else {
//            allOptions.filter {
//                it.contains(value, ignoreCase = true)
//            }
//        }
//    }

    // close menu if no matches
    val shouldShowMenu = expanded && allOptions.isNotEmpty()

    ExposedDropdownMenuBox(
        expanded = shouldShowMenu,
        onExpandedChange = { wantExpand ->
            // only allow expand if we actually have something to show
            expanded = wantExpand && allOptions.isNotEmpty()
        },
        modifier = modifier
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = {
                onValueChange(it)
                expanded = true // as soon as user types, open
            },
            modifier = Modifier
                .fillMaxWidth()
                .menuAnchor(
                    MenuAnchorType.PrimaryNotEditable,
                    true
                ), // required for ExposedDropdownMenuBox
            enabled = enabled,
            isError = isError,
            label = { if (label.isNotEmpty()) Text(label) },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(
                    expanded = shouldShowMenu
                )
            },
            supportingText = {
                if (isError && supportingText != null) {
                    Text(text = supportingText)
                }
            },
            singleLine = true,
            readOnly = true
        )

        ExposedDropdownMenu(
            expanded = shouldShowMenu,
            onDismissRequest = { expanded = false },
        ) {
            allOptions.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option) },
                    onClick = {
                        onValueChange(option)           // update text in field
                        onOptionSelected(option)        // callback for parent (optional)
                        expanded = false
                    },
                    contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                )
            }
        }
    }
}


@Composable
@LightDarkPreview
private fun TextFieldScreenPreview() {
    AppTheme {
        TextFiledScreen {

        }
    }
}

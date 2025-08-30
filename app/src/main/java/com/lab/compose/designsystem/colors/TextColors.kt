package com.lab.compose.designsystem.colors

// TextColors.kt
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import com.lab.compose.designsystem.theme.Brand

data class TextColors(
    val primary: Color,          // default body/title on surfaces
    val secondary: Color,        // subdued body, hints
    val tertiary: Color,         // extra-subdued captions
    val inverse: Color,          // text on inverse surfaces
    val success: Color,          // success text
    val warning: Color,          // warning text
    val error: Color,            // error text
    val link: Color,             // hyperlinks
)

val LocalTextColors = staticCompositionLocalOf {
    TextColors(
        primary = ColorPalette.Gray950,
        secondary = ColorPalette.Gray500,
        tertiary = ColorPalette.Gray200,
        inverse = ColorPalette.Gray50,
        success = ColorPalette.Green500,
        warning = ColorPalette.Yellow500,
        error = ColorPalette.Red600,
        link = ColorPalette.Blue500
    )
}

fun textColorsForLight() = TextColors(
    primary = ColorPalette.Gray900,
    secondary = ColorPalette.Gray600,
    tertiary = ColorPalette.Gray500,
    inverse = ColorPalette.Gray100,
    success = ColorPalette.Green500,
    warning = ColorPalette.Yellow700,
    error = ColorPalette.Red700,
    link = Brand.Primary
)

fun textColorsForDark() = TextColors(
    primary = ColorPalette.Gray100,
    secondary = ColorPalette.Gray400,
    tertiary = ColorPalette.Gray500,
    inverse = ColorPalette.Gray900,
    success = ColorPalette.Green300,
    warning = ColorPalette.Yellow300,
    error = ColorPalette.Red300,
    link = Brand.Primary
)

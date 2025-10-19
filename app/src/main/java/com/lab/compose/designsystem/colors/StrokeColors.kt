package com.lab.compose.designsystem.colors

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class StrokesColors(
    val primary: Color,
    val secondary: Color,
    val tertiary: Color,
    val focusedBorder: Color,
    val unfocusedBorder: Color,
    val successBorder: Color,
    val errorBorder: Color,
    val warningBorder: Color,
    val disabledBorder: Color,
)

val LocalStrokeColors = staticCompositionLocalOf {
    StrokesColors(
        primary = ColorPalette.Gray950,
        secondary = ColorPalette.Gray500,
        tertiary = ColorPalette.Gray200,
        focusedBorder = ColorPalette.Blue500,
        unfocusedBorder = ColorPalette.Gray400,
        successBorder = ColorPalette.Green500,
        errorBorder = ColorPalette.Red500,
        warningBorder = ColorPalette.Yellow500,
        disabledBorder = ColorPalette.Gray300,
    )
}

fun strokesColorsForLight() = StrokesColors(
    primary = ColorPalette.Gray900,
    secondary = ColorPalette.Gray600,
    tertiary = ColorPalette.Gray500,
    focusedBorder = ColorPalette.Blue600,
    unfocusedBorder = ColorPalette.Gray400,
    successBorder = ColorPalette.Green600,
    errorBorder = ColorPalette.Red600,
    warningBorder = ColorPalette.Yellow600,
    disabledBorder = ColorPalette.Gray300,
)

fun strokesColorsForDark() = StrokesColors(
    primary = ColorPalette.Gray100,
    secondary = ColorPalette.Gray400,
    tertiary = ColorPalette.Gray500,
    focusedBorder = ColorPalette.Blue400,
    unfocusedBorder = ColorPalette.Gray600,
    successBorder = ColorPalette.Green400,
    errorBorder = ColorPalette.Red400,
    warningBorder = ColorPalette.Yellow400,
    disabledBorder = ColorPalette.Gray700,
)
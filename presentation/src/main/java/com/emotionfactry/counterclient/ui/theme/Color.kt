package com.emotionfactry.counterclient.ui.theme

import androidx.compose.material.Colors
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

internal fun appColors(isDarkTheme: Boolean = true) : Colors {
    return if (isDarkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }
}

internal val LightColorPalette = lightColors(
    primary = Color(0xFFCEF0F9),
    primaryVariant = Color(0xFFBBE8F2),
    secondary = Color(0xFF3D8B9D),
    secondaryVariant = Color(0xFF4DA3B7),
    background = Color(0xFFE7FCFF),
    surface = Color(0xFFD1F7FC),
    error = Color(202,70,70),
    onPrimary = Color(0,16,21),
    onSecondary = Color(0,16,21),
    onBackground = Color(0,16,21),
    onSurface = Color(0,16,21),
    onError = Color(82,19,19)
)

internal val DarkColorPalette = darkColors(
    primary = Color(6,29,34),
    primaryVariant = Color(58,99,104),
    secondary = Color(0,67,79),
    secondaryVariant = Color(68,145,164),
    background = Color(0,16,21),
    surface = Color(3,27,33),
    error = Color(202,70,70),
    onPrimary = Color(244,244,244),
    onSecondary = Color(244,244,244),
    onBackground = Color(244,244,244),
    onSurface = Color(244,244,244),
    onError = Color(255,195,199)
)
package com.emotionfactry.counterclient.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf

@Composable
fun CounterClientTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = appColors(darkTheme)

    val icons = appIcons()

    CompositionLocalProvider(
        LocalColors(darkTheme) provides colors,
        LocalDimensions provides AppTheme.dimensions,
        LocalTypography provides AppTheme.typography,
        LocalIcons provides icons
    ) {
        MaterialTheme(colors = colors) {
            content()
        }
    }
}

internal fun LocalColors(isDarkTheme: Boolean) = staticCompositionLocalOf { appColors(isDarkTheme) }
internal val LocalDimensions = staticCompositionLocalOf { AppDimensions() }
internal val LocalTypography = staticCompositionLocalOf { AppTypography() }
internal val LocalIcons = staticCompositionLocalOf { appIcons() }

object AppTheme {
    val colors: Colors
    @Composable
    @ReadOnlyComposable
    get() = LocalColors(isSystemInDarkTheme()).current

    val typography: AppTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current
    val dimensions: AppDimensions
        @Composable
        @ReadOnlyComposable
        get() = LocalDimensions.current
    val icons: AppIcons
        @Composable
        @ReadOnlyComposable
        get() = LocalIcons.current
}
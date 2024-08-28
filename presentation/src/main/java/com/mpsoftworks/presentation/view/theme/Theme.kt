package com.mpsoftworks.presentation.view.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.mpsoftworks.presentation.utils.isDarkThemeEnabled

@Composable
fun CounterClientTheme(
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalColors provides appColors(isDarkThemeEnabled(LocalContext.current)),
        LocalDimensions provides AppTheme.dimensions,
        LocalTypography provides AppTheme.typography,
        LocalIcons provides appIcons()
    ) {
        content()
    }
}

internal val LocalColors = staticCompositionLocalOf { lightThemeMap() }
internal val LocalDimensions = staticCompositionLocalOf { AppDimensions() }
internal val LocalTypography = staticCompositionLocalOf { AppTypography() }
internal val LocalIcons = staticCompositionLocalOf { appIcons() }

/**
 * Theme params
 * @property colors theme colors
 * @property typography theme types
 * @property dimensions theme dimens
 * @property icons theme icons
 */
object AppTheme {
    val colors: Map<ThemeEntities, Color>
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current

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

@Composable
@ReadOnlyComposable
fun ThemeEntities.getColor(): Color = AppTheme.colors.getValue(this)
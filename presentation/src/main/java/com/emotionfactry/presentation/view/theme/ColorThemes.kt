package com.emotionfactry.presentation.view.theme

// import androidx.compose.material3.ColorScheme
import androidx.compose.ui.graphics.Color

internal fun appColors(isDarkTheme: Boolean = false) : Map<ThemeEntities, Color> {
    return if (isDarkTheme) {
        darkThemeMap()
    } else {
        lightThemeMap()
    }
}

public fun lightThemeMap(): Map<ThemeEntities, Color> = mapOf(
    ThemeEntities.Background0 to White100,
    ThemeEntities.Background1 to White85,
    ThemeEntities.BackgroundPrimary0 to Cyan1,
    ThemeEntities.BackgroundPrimary1 to Cyan2,
    ThemeEntities.BackgroundSecondary0 to Teal1,
    ThemeEntities.BackgroundSecondary1 to Teal2,
    ThemeEntities.ElementPrimary0 to Cyan6,
    ThemeEntities.ElementPrimary1 to Cyan7,
    ThemeEntities.ElementPrimaryWarning to Red2,
    ThemeEntities.ElementSecondary0 to Teal6,
    ThemeEntities.ElementSecondary1 to Teal7,
    ThemeEntities.ElementSecondaryWarning to Brown2,
    ThemeEntities.ElementBorder0 to Cyan8,
    ThemeEntities.ElementBorder1 to Teal8,
    ThemeEntities.ElementBorderWarning to Red10,
    ThemeEntities.ElementContentPrimary0 to Cyan9,
    ThemeEntities.ElementContentPrimary1 to Teal9,
    ThemeEntities.ElementContentPrimaryWarning to Brown9,
    ThemeEntities.ElementContentSecondary0 to Cyan10,
    ThemeEntities.ElementContentSecondary1 to Teal10,
    ThemeEntities.ElementContentSecondaryWarning to Red10
)

public fun darkThemeMap(): Map<ThemeEntities, Color> = mapOf(
    ThemeEntities.Background0 to Black100,
    ThemeEntities.Background1 to Black85,
    ThemeEntities.BackgroundPrimary0 to Cyan11,
    ThemeEntities.BackgroundPrimary1 to Cyan10,
    ThemeEntities.BackgroundSecondary0 to Teal10,
    ThemeEntities.BackgroundSecondary1 to Teal9,
    ThemeEntities.ElementPrimary0 to BlueGrey9,
    ThemeEntities.ElementPrimary1 to BlueGrey10,
    ThemeEntities.ElementPrimaryWarning to Red2,
    ThemeEntities.ElementSecondary0 to DeepPurple10,
    ThemeEntities.ElementSecondary1 to DeepPurple9,
    ThemeEntities.ElementSecondaryWarning to Brown2,
    ThemeEntities.ElementBorder0 to Cyan8,
    ThemeEntities.ElementBorder1 to Teal8,
    ThemeEntities.ElementBorderWarning to Red10,
    ThemeEntities.ElementContentPrimary0 to Cyan9,
    ThemeEntities.ElementContentPrimary1 to Teal9,
    ThemeEntities.ElementContentPrimaryWarning to Brown9,
    ThemeEntities.ElementContentSecondary0 to DeepPurple5,
    ThemeEntities.ElementContentSecondary1 to DeepPurple6,
    ThemeEntities.ElementContentSecondaryWarning to Red10
)



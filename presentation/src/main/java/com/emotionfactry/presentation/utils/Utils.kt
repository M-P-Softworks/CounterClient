package com.emotionfactry.presentation.utils

import android.content.Context
import android.content.res.Configuration

internal fun isDarkThemeEnabled(context: Context): Boolean {
    val currentMode = context.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
    return currentMode == Configuration.UI_MODE_NIGHT_YES
}
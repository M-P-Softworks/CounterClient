package com.mpsoftworks.presentation.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.mpsoftworks.presentation.R
import com.mpsoftworks.presentation.view.theme.AppTheme
import com.mpsoftworks.presentation.view.theme.LocalColors
import com.mpsoftworks.presentation.view.theme.Red2
import com.mpsoftworks.presentation.view.theme.ThemeEntities
import com.mpsoftworks.presentation.view.theme.getColor

data class CounterGroupImage(
    val imageResource: Int = R.drawable.ic_color_square,
    val imageColor: Color = Red2
)
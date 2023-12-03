package com.emotionfactry.presentation.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.emotionfactry.presentation.R
import com.emotionfactry.presentation.view.theme.AppTheme
import com.emotionfactry.presentation.view.theme.LocalColors
import com.emotionfactry.presentation.view.theme.Red2
import com.emotionfactry.presentation.view.theme.ThemeEntities
import com.emotionfactry.presentation.view.theme.getColor

data class CounterGroupImage(
    val imageResource: Int = R.drawable.ic_color_square,
    val imageColor: Color = Red2
)
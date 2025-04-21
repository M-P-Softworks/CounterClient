package com.mpsoftworks.presentation.model

import android.app.Application
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import com.mpsoftworks.presentation.R
import com.mpsoftworks.presentation.view.theme.AppTheme
import com.mpsoftworks.presentation.view.theme.LocalColors
import com.mpsoftworks.presentation.view.theme.Red2
import com.mpsoftworks.presentation.view.theme.ThemeEntities
import com.mpsoftworks.presentation.view.theme.getColor
import dagger.hilt.android.qualifiers.ApplicationContext

data class CounterGroupImage(
    val imageResource: ImageBitmap? = null,
    val imageColor: Color = Red2
)
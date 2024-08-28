package com.mpsoftworks.presentation.view.theme

import androidx.annotation.DrawableRes
import com.mpsoftworks.presentation.R

data class AppIcons(
    val logo: AppIcon,
    val plus: AppIcon,
    val minus: AppIcon,
    val group: AppIcon,
    val question: AppIcon,
    val burger: AppIcon,
    val settings: AppIcon
)

data class AppIcon(
    @DrawableRes val drawableIcon: Int,
    val description: String?)

fun appIcons(): AppIcons =
    AppIcons(
        logo = AppIcon(R.drawable.ic_color_square, "logo"),
        plus = AppIcon(R.drawable.ic_color_square, "plus"),
        minus = AppIcon(R.drawable.ic_color_square, "minus"),
        group = AppIcon(R.drawable.ic_color_square, "group"),
        question = AppIcon(R.drawable.ic_color_square, "question"),
        burger = AppIcon(R.drawable.ic_color_square, "burger"),
        settings = AppIcon(R.drawable.ic_color_square, "settings")
    )
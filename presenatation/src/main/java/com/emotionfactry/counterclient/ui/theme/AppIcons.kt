package com.emotionfactry.counterclient.ui.theme

import androidx.annotation.DrawableRes
import com.emotionfactry.counterclient.R

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
        logo = AppIcon(R.drawable.ic_item_group, "logo"),
        plus = AppIcon(R.drawable.ic_item_group, "plus"),
        minus = AppIcon(R.drawable.ic_item_group, "minus"),
        group = AppIcon(R.drawable.ic_item_group, "group"),
        question = AppIcon(R.drawable.ic_item_group, "question"),
        burger = AppIcon(R.drawable.ic_item_group, "burger"),
        settings = AppIcon(R.drawable.ic_item_group, "settings")
    )
package com.mpsoftworks.presentation.utils

import android.content.Context
import android.content.res.Configuration
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asAndroidBitmap
import com.mpsoftworks.model.CounterGroup
import com.mpsoftworks.model.InitialCountersData
import com.mpsoftworks.presentation.model.CounterGroupImage
import com.mpsoftworks.presentation.model.ListItem
import com.mpsoftworks.presentation.model.main.MainListState
import java.io.ByteArrayOutputStream
import androidx.compose.ui.graphics.asImageBitmap


internal fun isDarkThemeEnabled(context: Context): Boolean {
    val currentMode = context.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
    return currentMode == Configuration.UI_MODE_NIGHT_YES
}

internal fun InitialCountersData.toMainListState(): MainListState {
    val items = groups.flatMapIndexed { index, group ->
        counters.getOrNull(index)?.map { counter ->
            ListItem(
                itemGroupImage = createCounterGroupImage(group),
                itemHeader = counter.header ?: "No title",
                itemText = counter.text ?: "Unnamed",
                itemCurrentValue = counter.counterValue.v.toString()
            )
        } ?: emptyList()
    }

    return MainListState(itemsCounterList = items)
}

private fun createCounterGroupImage(group: CounterGroup): CounterGroupImage {

    return CounterGroupImage(group.bitmap?.asImageBitmap(), Color(group.color))
}

fun ImageBitmap.toByteArray(imageBitmap: ImageBitmap): ByteArray {
    val bitmap = imageBitmap.asAndroidBitmap()
    val stream = ByteArrayOutputStream()
    bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
    return stream.toByteArray()
}

fun ByteArray.toImageBitmap(byteArray: ByteArray): ImageBitmap {
    val bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)
    return bitmap.asImageBitmap()
}

package com.emotionfactry.presentation.view.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.emotionfactry.presentation.R
import com.emotionfactry.presentation.model.CounterGroupImage
import com.emotionfactry.presentation.model.ListItem
import com.emotionfactry.presentation.view.theme.AppTheme
import com.emotionfactry.presentation.view.theme.ThemeEntities
import com.emotionfactry.presentation.view.theme.getColor

/**
 * Settings item.
 */
@Composable
internal fun SettingsItem(
    modifier: Modifier = Modifier,
    listItem: ListItem
) {
    val cornerShape = RoundedCornerShape(AppTheme.dimensions.itemCornerRadius)

    Row(
        modifier = modifier
            .background(
                color = ThemeEntities.BackgroundPrimary0.getColor(),
                shape = cornerShape
            )
            .border(
                width = 1.dp,
                color = ThemeEntities.ElementBorder0.getColor(),
                shape = cornerShape
            )
            .padding(all = AppTheme.dimensions.paddingM),
        verticalAlignment = Alignment.CenterVertically
    ) {
        SettingsImage(listItem.itemGroupImage)
        ItemTextContainer(
            modifier = Modifier
                .padding(horizontal = AppTheme.dimensions.paddingM)
                .weight(1.0f),
            listItem.itemHeader,
            listItem.itemText
        )
    }
}

@Composable
private fun SettingsImage(itemGroupImage: CounterGroupImage) {
    Image(
        painter = painterResource(id = itemGroupImage.imageResource),
        contentDescription = null,
        alignment = Alignment.BottomCenter
    )
}

@Composable
private fun ItemTextContainer(
    modifier: Modifier = Modifier,
    textHeader: String,
    text: String) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {
        ItemHeader(textHeader)
        ItemText(text)
    }
}

@Composable
private fun ItemHeader(textHeader: String) {
    Text(
        textHeader,
        maxLines = 1,
        style = AppTheme.typography.h6,
        modifier = Modifier
            .padding(
                bottom = AppTheme.dimensions.paddingS
            )
    )
}

@Composable
private fun ItemText(text: String) {
    Text(
        text,
        maxLines = 3,
        style = AppTheme.typography.subtitle2,
        modifier = Modifier
            .padding(
                bottom = AppTheme.dimensions.paddingS
            )
    )
}

@Composable
@Preview
private fun Preview() {
    val image = CounterGroupImage(R.drawable.ic_color_square, Color.Green)
    Surface {
        Column(Modifier
            .padding(all = 12.dp)
            .width(400.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            SettingsItem(
                listItem = ListItem())
        }

    }
}

package com.emotionfactry.counterclient.ui.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.emotionfactry.counterclient.R

@Composable
fun MainListItem(){
    Surface {
        Row(modifier = Modifier) {
            Column(modifier = Modifier){
                Image(
                    painter = painterResource(id = R.drawable.ic_item_group),
                    contentDescription = null,
                    modifier = Modifier.padding(top = 40.dp, bottom = 16.dp)
                )
            }
            Column(modifier = Modifier) {

            }
            Column(modifier = Modifier) {

            }
        }
    }
}

@Composable
@Preview
fun previewItem(){
    MainListItem()
}
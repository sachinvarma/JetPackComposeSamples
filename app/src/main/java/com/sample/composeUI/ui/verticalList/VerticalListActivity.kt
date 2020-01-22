package com.sample.composeUI.ui.verticalList

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.core.Alignment
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.core.setContent
import androidx.ui.foundation.DrawImage
import androidx.ui.foundation.VerticalScroller
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.Divider
import androidx.ui.res.imageResource
import com.sample.composeUI.R

class VerticalListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            createVerticalListView()
        }
    }

    @Composable
    fun createVerticalListView() {
        VerticalScroller {
            Column(arrangement = Arrangement.Center) {
                (0..10).forEachIndexed { index, _ ->
                    verticalListCompose(index)
                    Divider(color = Color.Blue, height = 1.dp)
                }
            }
        }
    }

    @Composable
    fun verticalListCompose(itemIndex: Int) {
        Align(alignment = Alignment.Center) {

            Padding(left = 8.dp, right = 8.dp, top = 8.dp, bottom = 8.dp) {
                Column {
                    val image = +imageResource(R.drawable.ic_android)

                    Container(
                        height = 150.dp,
                        width = 150.dp, alignment = Alignment.Center
                    ) {
                        DrawImage(image, Color.Green)
                        (Text("Item $itemIndex"))
                    }

                }
            }
        }
    }
}
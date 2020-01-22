package com.sample.composeUI.ui.horizontalList

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.core.Alignment
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.core.setContent
import androidx.ui.foundation.DrawImage
import androidx.ui.foundation.HorizontalScroller
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.MaterialTheme
import androidx.ui.res.imageResource
import com.sample.composeUI.R

class HorizontalListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            createVerticalListView()
        }
    }

    @Composable
    fun createVerticalListView() {
        MaterialTheme {
            HorizontalScroller {
                Row {
                    (0..10).forEachIndexed { index, _ ->
                        verticalListCompose(index)
                    }
                }
            }

        }
    }

    @Composable
    fun verticalListCompose(itemIndex: Int) {
        Padding(left = 8.dp, right = 8.dp, top = 8.dp, bottom = 8.dp) {
            FlexRow(crossAxisAlignment = CrossAxisAlignment.Center) {
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
    }
}
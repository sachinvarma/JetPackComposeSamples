package com.sample.composeUI.ui.toolBarNavigationScreen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.core.setContent
import androidx.ui.core.sp
import androidx.ui.foundation.DrawImage
import androidx.ui.foundation.VerticalScroller
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.AppBarIcon
import androidx.ui.material.MaterialTheme
import androidx.ui.material.TopAppBar
import androidx.ui.res.imageResource
import androidx.ui.text.TextStyle
import androidx.ui.text.font.FontWeight
import com.sample.composeUI.R

class AppbarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                appBars()
            }
        }
    }

    @Composable
    fun appBars() {
        val image = +imageResource(R.drawable.ic_logo)
        Column {
            TopAppBar(
                color = Color.Blue,
                navigationIcon = {
                    AppBarIcon(
                        +imageResource(id = R.drawable.ic_arrow_back)
                    ) {
                        onBackPressed()
                    }
                },
                title = {
                    Text(
                        text = "Toolbar",
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
            )

            VerticalScroller {

                Column(
                    arrangement = Arrangement.Center, modifier = Spacing(16.dp)
                ) {

                    Center {

                        Container(
                            height = 200.dp,
                            width = 200.dp,
                            expanded = true
                        ) {
                            DrawImage(image, Color.Green)
                        }
                    }


                    HeightSpacer(20.dp)

                    Text(
                        "Jetpack Compose is a modern toolkit for building native Android UI. Jetpack Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.\n" +
                                "\n" +
                                "In this tutorial, you'll build a simple UI component with declarative functions. You won't be editing any XML layouts or directly creating the UI widgets. Instead, you will call Jetpack Compose functions to say what elements you want, and the Compose compiler will do the rest.\n Lesson 1: Composable functions\n" +
                                "Jetpack Compose is built around composable functions. These functions let you define your app's UI programmatically by describing its shape and data dependencies, rather than focusing on the process of the UI's construction. To create a composable function, just add the @Composable annotation to the function name.Add a text element\n" +
                                "To begin, follow the Jetpack Compose setup instructions, and create an app using the Empty Compose Activity template. Then add a text element to your blank activity. You do this by defining a content block, and calling the Text() function.\n" +
                                "\n" +
                                "The setContent block defines the activity's layout. Instead of defining the layout contents with an XML file, we call composable functions. Jetpack Compose uses a custom Kotlin compiler plugin to transform these composable functions into the app's UI elements. For example, the Text() function is defined by the Compose UI library; you call that function to declare a text element in your app.",
                        style = TextStyle(
                            fontSize = 16.sp,
                            color = Color.Gray
                        )
                    )

                    HeightSpacer(20.dp)
                }
            }
        }
    }
}


package com.sample.composeUI.ui.splashScreen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.core.*
import androidx.ui.foundation.DrawImage
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.res.imageResource
import androidx.ui.text.TextStyle
import androidx.ui.text.font.FontWeight
import com.sample.composeUI.R
import com.sample.composeUI.ui.homeScreen.HomeScreenActivity

/**
 * Class used to show the Splash Screen
 */
class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { splashScreenCompose() }
        navigateToHomeScreen()
    }

    /**
     * Function to navigate to HomeScreen
     */
    private fun navigateToHomeScreen() {
        Handler().postDelayed({
            startActivity(Intent(this, HomeScreenActivity::class.java))
            finish()
        }, 3000)
    }

    @Composable
    fun splashScreenCompose() {
        val image = +imageResource(R.drawable.ic_logo)
        Align(alignment = Alignment.Center) {
            Column(
                modifier = Spacing(16.dp), arrangement = Arrangement.Center
            ) {
                Container(
                    height = 200.dp,
                    width = 200.dp,
                    expanded = true
                ) {
                    DrawImage(image, Color.Green)
                }

                Text(
                    "Welcome to Compose Samples",
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }
    }

}
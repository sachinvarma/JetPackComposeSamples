package com.sample.composeUI.ui.homeScreen

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.state
import androidx.compose.unaryPlus
import androidx.ui.core.*
import androidx.ui.foundation.shape.RectangleShape
import androidx.ui.foundation.shape.border.Border
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.*
import com.sample.composeUI.ui.horizontalList.HorizontalListActivity
import com.sample.composeUI.ui.toolBarNavigationScreen.AppbarActivity
import com.sample.composeUI.ui.verticalList.VerticalListActivity

class HomeScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            homeScreenCompose()
        }
    }


    @Composable
    fun homeScreenCompose() {

        Align(
            alignment = Alignment.Center
        ) {
            Column(
                arrangement = Arrangement.Center,
                modifier = Spacing(16.dp),
                children = {
                    Button(
                        modifier = Height(50.dp) wraps Expanded,
                        text = "Appbar", onClick = {
                            startActivity(
                                Intent(
                                    this@HomeScreenActivity,
                                    AppbarActivity::class.java
                                )
                            )
                        }, style = ContainedButtonStyle(
                            color = Color.White,
                            shape = RectangleShape,
                            rippleColor = Color.DarkGray,
                            elevation = Dp(4f)
                        )
                    )

                    HeightSpacer(10.dp)

                    Button(
                        modifier = Height(50.dp) wraps Expanded,
                        text = "HorizontalListView", onClick = {
                            startActivity(
                                Intent(
                                    this@HomeScreenActivity,
                                    HorizontalListActivity::class.java
                                )
                            )
                        }, style = OutlinedButtonStyle(
                            color = Color.Black,
                            contentColor = Color.White,
                            shape = RectangleShape,
                            elevation = Dp(4f)
                        )
                    )

                    HeightSpacer(10.dp)

                    Button(
                        modifier = Height(50.dp) wraps Expanded,
                        text = "VerticalListView", onClick = {
                            startActivity(
                                Intent(
                                    this@HomeScreenActivity,
                                    VerticalListActivity::class.java
                                )
                            )
                        }, style = OutlinedButtonStyle(
                            color = Color.Red,
                            shape = RoundedCornerShape(10),
                            contentColor = Color.White,
                            elevation = Dp(4f)
                        )
                    )

                    HeightSpacer(10.dp)

                    AlertDialogButton()
                }
            )
        }

    }

}

@Composable
fun AlertDialogButton() {
    val openDialog = +state { DialogVisibleModel(false) }

    Button(
        modifier = Height(50.dp) wraps Expanded,
        text = "Alert Dialog", onClick = {
            openDialog.value = DialogVisibleModel(true)
        }, style = OutlinedButtonStyle(
            Border(color = Color.Red, width = 1.dp),
            shape = RoundedCornerShape(50), //50% percent
            contentColor = Color.Red,
            color = Color.White,
            elevation = Dp(4f)
        )
    )


    if (openDialog.value.visible) {
        AlertDialog(

            onCloseRequest = {
                // Because we are not setting openDialog.value to false here,
                // the user can close this dialog only via one of the buttons we provide.
            },
            title = {
                Text(text = "Title")
            },
            text = {
                Text(
                    "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s"
                )
            },
            confirmButton = {
                Button("Confirm", onClick = {
                    openDialog.value = DialogVisibleModel(false)
                })
            },
            dismissButton = {
                if (!openDialog.value.dismissPushed)
                    Button("Dismiss", onClick = {
                        openDialog.value = DialogVisibleModel(false, true)
                    })
                else {
                    //hidden
                }
            },
            buttonLayout = AlertDialogButtonLayout.SideBySide
        )
    }
}

data class DialogVisibleModel(val visible: Boolean, val dismissPushed: Boolean = false)


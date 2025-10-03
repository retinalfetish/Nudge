package com.unary.nudge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.unary.nudge.ui.theme.NudgeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NudgeTheme {
                NudgeHost(
//                    colors = NudgeDefaults.nudgeColors(
//                        infoContainerColor = Color.Gray,
//                        infoContentColor = Color.White
//                    ),
//                    shape = MaterialTheme.shapes.extraLarge
                ) {
                    Surface(modifier = Modifier.fillMaxSize()) {
                        val buttons = remember {
                            listOf(
                                "Info" to { Nudge.info(message = "Info message.") },
                                "Success" to { Nudge.success(message = "Yay, success!") },
                                "Warning" to { Nudge.warning(message = "Some warning.") },
                                "Error" to { Nudge.error(message = "Oops, error!") }
                            )
                        }

                        Row(
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            modifier = Modifier
                                .fillMaxWidth()
                                .statusBarsPadding()
                        ) {
                            buttons.forEach { (label, onClick) ->
                                Button(onClick = onClick) {
                                    Text(text = label)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
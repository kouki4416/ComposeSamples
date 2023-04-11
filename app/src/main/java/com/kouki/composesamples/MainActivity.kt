package com.kouki.composesamples

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.kouki.composesamples.ui.MainScreen
import com.kouki.composesamples.ui.theme.ComposeSamplesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // save this to shared preference
            var darkTheme by remember { mutableStateOf(false) }
            ComposeSamplesTheme(darkTheme = darkTheme){
                MainScreen(
                    darkTheme = darkTheme,
                    onSwitched = {darkTheme = !darkTheme}
                )
            }
        }
    }
}
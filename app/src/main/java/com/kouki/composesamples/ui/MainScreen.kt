package com.kouki.composesamples.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MainScreen(
    darkTheme: Boolean,
    onSwitched: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ThemeSwitch(
            isDarkTheme = darkTheme,
            onClick = onSwitched
        )
    }
}

@Preview
@Composable
fun previewThemeSwitch() {
    ThemeSwitch(
        isDarkTheme = false,
        onClick = {}
    )
}

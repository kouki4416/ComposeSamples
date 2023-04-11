package com.kouki.composesamples.ui

import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.Nightlight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun ThemeSwitch(
    isDarkTheme: Boolean,
    size: Dp = 100.dp,
    iconSize: Dp = size / 3,
    padding: Dp = 10.dp,
    parentShape: Shape = CircleShape,
    toggleShape: Shape = CircleShape,
    animationSpec: AnimationSpec<Dp> = tween(durationMillis = 300),
    onClick: () -> Unit
) {
    val offset by animateDpAsState(
        targetValue = if (isDarkTheme) 0.dp else size,
        animationSpec = animationSpec
    )
    // スイッチ全体
    Box(modifier = Modifier
        .width(size * 2)
        .height(size)
        .clip(shape = parentShape)
        .clickable { onClick() }
        .background(MaterialTheme.colorScheme.secondaryContainer)
    ) {
        // スイッチ
        Box(
            modifier = Modifier
                .size(size)
                .offset(x = offset)
                .padding(all = padding)
                .clip(shape = toggleShape)
                .background(MaterialTheme.colorScheme.primary)
        ) {}
        // 月アイコン
        Box(
            modifier = Modifier.size(size),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                modifier = Modifier.size(iconSize),
                imageVector = Icons.Default.Nightlight,
                contentDescription = "Theme Icon",
                tint = MaterialTheme.colorScheme.surface
            )
        }
        // 太陽アイコン
        Box(
            modifier = Modifier.size(size)
                .offset(x = size),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                modifier = Modifier.size(iconSize),
                imageVector = Icons.Default.LightMode,
                contentDescription = "Theme Icon",
                tint = MaterialTheme.colorScheme.surface
            )
        }
    }
}
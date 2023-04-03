package com.loogika.ysearch.screen

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.loogika.ysearch.core.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    onNavigateToSearch: () -> Unit
) {
    val scale = remember { Animatable(0.5f) }

    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.3f,
            animationSpec = tween(
                durationMillis = 500,
                easing = {
                    OvershootInterpolator(2f).getInterpolation(it)
                }
            )
        )
        delay(3000L)
        onNavigateToSearch()
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_alert),
            contentDescription = "Launcher",
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .size(300.dp)
        )
    }
}
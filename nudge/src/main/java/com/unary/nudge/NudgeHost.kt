package com.unary.nudge

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import com.unary.nudge.internal.NudgeManager
import com.unary.nudge.ui.NudgeContainer
import com.unary.nudge.ui.theme.NudgeColors
import com.unary.nudge.ui.theme.NudgeDefaults

/**
 * A composable container that hosts and displays queued Nudge notifications.
 *
 * Should wrap your app's content at the top level (e.g., inside your `NavHost` or `Scaffold`).
 *
 * @param modifier Modifier for the container.
 * @param colors Defines the colors for each type.
 * @param shape Shape of the notification cards.
 * @param content The given Composable content.
 */
@Composable
fun NudgeHost(
    modifier: Modifier = Modifier,
    colors: NudgeColors = NudgeDefaults.nudgeColors(),
    shape: Shape = NudgeDefaults.shape,
    content: @Composable () -> Unit
) {
    val notifications by NudgeManager.notifications.collectAsState()

    Box(modifier = modifier) {
        content()

        NudgeContainer(
            modifier = Modifier.fillMaxSize(),
            notifications = notifications,
            onClick = { item -> NudgeManager.removeNotification(item = item) },
            colors = colors,
            shape = shape
        )
    }
}
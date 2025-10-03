package com.unary.nudge.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape

/**
 * Provides default styling and configuration for Nudge notifications.
 *
 * These values follow the current [MaterialTheme] and can be overridden to customize the
 * appearance of notifications.
 */
object NudgeDefaults {

    /**
     * Returns a [NudgeColors] that defines the color styling for each notification type.
     *
     * Colors are derived from the current [MaterialTheme.colorScheme] and each container and
     * content color can be overridden.
     *
     * @param infoContainerColor Info notification container color.
     * @param infoContentColor Info notification content color.
     * @param successContainerColor Success notification container color.
     * @param successContentColor Success notification content color.
     * @param warningContainerColor Warning notification container color.
     * @param warningContentColor Warning notification content color.
     * @param errorContainerColor Error notification container color.
     * @param errorContentColor Error notification content color.
     *
     * @return A [NudgeColors] instance of colors.
     */
    @Composable
    fun nudgeColors(
        infoContainerColor: Color = MaterialTheme.colorScheme.primary,
        infoContentColor: Color = MaterialTheme.colorScheme.onPrimary,
        successContainerColor: Color = MaterialTheme.colorScheme.secondary,
        successContentColor: Color = MaterialTheme.colorScheme.onSecondary,
        warningContainerColor: Color = MaterialTheme.colorScheme.tertiary,
        warningContentColor: Color = MaterialTheme.colorScheme.onTertiary,
        errorContainerColor: Color = MaterialTheme.colorScheme.error,
        errorContentColor: Color = MaterialTheme.colorScheme.onError
    ): NudgeColors =
        NudgeColors(
            infoContainerColor = infoContainerColor,
            infoContentColor = infoContentColor,
            successContainerColor = successContainerColor,
            successContentColor = successContentColor,
            warningContainerColor = warningContainerColor,
            warningContentColor = warningContentColor,
            errorContainerColor = errorContainerColor,
            errorContentColor = errorContentColor
        )

    /** Default shape for cards. */
    val shape: Shape
        @Composable get() = MaterialTheme.shapes.medium
}
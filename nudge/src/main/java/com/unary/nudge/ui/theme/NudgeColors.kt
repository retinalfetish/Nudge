package com.unary.nudge.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

/**
 * Defines the full color scheme for all Nudge notification types.
 *
 * Each type (info, success, warning, error) has its own colors for container and content.
 *
 * @param infoContainerColor Info notification container color.
 * @param infoContentColor Info notification content color.
 * @param successContainerColor Success notification container color.
 * @param successContentColor Success notification content color.
 * @param warningContainerColor Warning notification container color.
 * @param warningContentColor Warning notification content color.
 * @param errorContainerColor Error notification container color.
 * @param errorContentColor Error notification content color.
 */
@Immutable
class NudgeColors(
    val infoContainerColor: Color,
    val infoContentColor: Color,
    val successContainerColor: Color,
    val successContentColor: Color,
    val warningContainerColor: Color,
    val warningContentColor: Color,
    val errorContainerColor: Color,
    val errorContentColor: Color
)
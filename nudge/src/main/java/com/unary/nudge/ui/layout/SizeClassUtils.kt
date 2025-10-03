package com.unary.nudge.ui.layout

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

private val COMPACT_WIDTH = 600.dp
private val MEDIUM_WIDTH = 840.dp

/**
 * Determines the appropriate [WidthSizeClass] based on the current layout width.
 *
 * @param maxWidth Maximum width of the layout.
 *
 * @return A [WidthSizeClass] for responsive layouts.
 */
internal fun rememberWidthSizeClass(maxWidth: Dp): WidthSizeClass {
    return when {
        maxWidth < COMPACT_WIDTH -> WidthSizeClass.Compact
        maxWidth < MEDIUM_WIDTH -> WidthSizeClass.Medium
        else -> WidthSizeClass.Expanded
    }
}
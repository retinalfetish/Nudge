package com.unary.nudge.ui.layout

/**
 * Represents a width-based size class for responsive layouts.
 */
internal sealed interface WidthSizeClass {

    /** For small devices like phones. */
    object Compact : WidthSizeClass

    /** Tablets in portrait orientation. */
    object Medium : WidthSizeClass

    /** Landscape tablets or desktops. */
    object Expanded : WidthSizeClass
}
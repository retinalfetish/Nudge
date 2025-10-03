package com.unary.nudge.internal

import androidx.compose.runtime.Immutable

/**
 * Represents a single notification to be displayed.
 *
 * @property id A unique identifier.
 * @property message The notification message text.
 * @property type The type of notification.
 */
@Immutable
internal data class NudgeItem(
    val id: Long,
    val message: String,
    val type: NudgeType
)
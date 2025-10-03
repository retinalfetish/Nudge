package com.unary.nudge.internal

import com.unary.nudge.ui.NudgeContainer

/**
 * Represents the type of a notification.
 *
 * Used internally by [NudgeContainer] to determine the color of a notification.
 */
internal sealed class NudgeType(val label: String) {

    /** Neutral information message. */
    object Info : NudgeType(label = "Information")

    /** Positive message for success. */
    object Success : NudgeType(label = "Success")

    /** Non-critical issue or alert. */
    object Warning : NudgeType(label = "Warning")

    /** An error or failure message */
    object Error : NudgeType(label = "Error")
}
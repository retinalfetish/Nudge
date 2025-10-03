package com.unary.nudge

import com.unary.nudge.internal.NudgeManager
import com.unary.nudge.internal.NudgeType

/**
 * Entry point for displaying transient Nudge notifications.
 *
 * Use the provided functions to display messages with different levels of importance.
 * This requires [NudgeHost] to be present in the composition hierarchy.
 */
object Nudge {

    /**
     * Displays an informational message.
     *
     * Useful for neutral messages such as updates or non-critical status changes.
     *
     * @param message The text to display.
     * @param durationMillis Duration of message visibility.
     */
    fun info(
        message: String,
        durationMillis: Long = 4000L
    ) {
        NudgeManager.addNotification(
            type = NudgeType.Info,
            message = message,
            durationMillis = durationMillis
        )
    }

    /**
     * Displays a success message.
     *
     * Typically used to confirm the result of a successful event or user action.
     *
     * @param message The text to display.
     * @param durationMillis Duration of message visibility.
     */
    fun success(
        message: String,
        durationMillis: Long = 4000L
    ) {
        NudgeManager.addNotification(
            type = NudgeType.Success,
            message = message,
            durationMillis = durationMillis
        )
    }

    /**
     * Displays a warning message.
     *
     * Can be used to inform the user of a potential problem or unexpected state.
     *
     * @param message The text to display.
     * @param durationMillis Duration of message visibility.
     */
    fun warning(
        message: String,
        durationMillis: Long = 4000L
    ) {
        NudgeManager.addNotification(
            type = NudgeType.Warning,
            message = message,
            durationMillis = durationMillis
        )
    }

    /**
     * Displays an error message.
     *
     * Appropriate for communicating failures, exceptions, or other serious issues.
     *
     * @param message The text to display.
     * @param durationMillis Duration of message visibility.
     */
    fun error(
        message: String,
        durationMillis: Long = 4000L
    ) {
        NudgeManager.addNotification(
            type = NudgeType.Error,
            message = message,
            durationMillis = durationMillis
        )
    }
}
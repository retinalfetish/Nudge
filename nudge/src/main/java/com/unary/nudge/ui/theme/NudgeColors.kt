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
) {

    /**
     * Returns a copy of this [NudgeColors], optionally overriding values.
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
     * @return A new [NudgeColors] instance.
     */
    fun copy(
        infoContainerColor: Color = this.infoContainerColor,
        infoContentColor: Color = this.infoContentColor,
        successContainerColor: Color = this.successContainerColor,
        successContentColor: Color = this.successContentColor,
        warningContainerColor: Color = this.warningContainerColor,
        warningContentColor: Color = this.warningContentColor,
        errorContainerColor: Color = this.errorContainerColor,
        errorContentColor: Color = this.errorContentColor
    ): NudgeColors = NudgeColors(
        infoContainerColor = infoContainerColor,
        infoContentColor = infoContentColor,
        successContainerColor = successContainerColor,
        successContentColor = successContentColor,
        warningContainerColor = warningContainerColor,
        warningContentColor = warningContentColor,
        errorContainerColor = errorContainerColor,
        errorContentColor = errorContentColor
    )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is NudgeColors) return false

        if (infoContainerColor != other.infoContainerColor) return false
        if (infoContentColor != other.infoContentColor) return false
        if (successContainerColor != other.successContainerColor) return false
        if (successContentColor != other.successContentColor) return false
        if (warningContainerColor != other.warningContainerColor) return false
        if (warningContentColor != other.warningContentColor) return false
        if (errorContainerColor != other.errorContainerColor) return false
        if (errorContentColor != other.errorContentColor) return false

        return true
    }

    override fun hashCode(): Int {
        var result = infoContainerColor.hashCode()

        result = 31 * result + infoContentColor.hashCode()
        result = 31 * result + successContainerColor.hashCode()
        result = 31 * result + successContentColor.hashCode()
        result = 31 * result + warningContainerColor.hashCode()
        result = 31 * result + warningContentColor.hashCode()
        result = 31 * result + errorContainerColor.hashCode()
        result = 31 * result + errorContentColor.hashCode()

        return result
    }
}
package com.unary.nudge.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.unary.nudge.internal.NudgeItem
import com.unary.nudge.internal.NudgeType
import com.unary.nudge.ui.layout.WidthSizeClass
import com.unary.nudge.ui.layout.rememberWidthSizeClass
import com.unary.nudge.ui.theme.NudgeColors

private val FIXED_WIDTH = 360.dp
//private val MAX_HEIGHT = 240.dp

/**
 * Internal layout container for active Nudge messages.
 *
 * Arranges messages in a vertical stack at the bottom of the screen, adapting layout based on
 * available width (compact, medium, or expanded).
 *
 * @param notifications Current list of notifications.
 * @param onClick Callback to remove a message.
 * @param colors Colors of the notification types.
 * @param shape Shape of the notification cards.
 * @param modifier Modifier for the container.
 */
@Composable
internal fun NudgeContainer(
    notifications: List<NudgeItem>,
    onClick: (NudgeItem) -> Unit,
    colors: NudgeColors,
    shape: Shape,
    modifier: Modifier = Modifier
) {
    BoxWithConstraints(
        contentAlignment = Alignment.BottomCenter,
        modifier = modifier
    ) {
        val widthSizeClass = rememberWidthSizeClass(maxWidth = maxWidth)

        val widthModifier = when (widthSizeClass) {
            WidthSizeClass.Compact -> Modifier.fillMaxWidth()
            else -> Modifier.width(FIXED_WIDTH)
        }

        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp),
            contentPadding = PaddingValues(horizontal = 8.dp),
            modifier = widthModifier
//                .heightIn(max = MAX_HEIGHT)
                .navigationBarsPadding(),
            reverseLayout = true
        ) {
            items(
                items = notifications,
                key = { it.id }
            ) { item ->
                val (containerColor, contentColor) = when (item.type) {
                    NudgeType.Info -> colors.infoContainerColor to colors.infoContentColor
                    NudgeType.Success -> colors.successContainerColor to colors.successContentColor
                    NudgeType.Warning -> colors.warningContainerColor to colors.warningContentColor
                    NudgeType.Error -> colors.errorContainerColor to colors.errorContentColor
                }

                NudgeCard(
                    modifier = Modifier
                        .fillMaxWidth()
                        .animateItem()
                        .clickable { onClick(item) },
                    item = item,
                    containerColor = containerColor,
                    contentColor = contentColor,
                    shape = shape
                )
            }
        }
    }
}
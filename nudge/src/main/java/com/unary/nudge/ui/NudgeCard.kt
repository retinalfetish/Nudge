package com.unary.nudge.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.semantics.LiveRegionMode
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.liveRegion
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.unary.nudge.internal.NudgeItem

/**
 * A visual representation of a single notification item.
 *
 * Used internally by [NudgeContainer] to render notifications with the appropriate colors
 * and shape.
 *
 * @param item Notification data to display.
 * @param containerColor Container color of the card.
 * @param contentColor Content color of the card.
 * @param shape The shape of the card.
 * @param modifier Modifier for the card.
 */
@Composable
internal fun NudgeCard(
    item: NudgeItem,
    containerColor: Color,
    contentColor: Color,
    shape: Shape,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.semantics {
            contentDescription = item.type.label
            liveRegion = LiveRegionMode.Polite
        },
        colors = CardDefaults.cardColors(
            containerColor = containerColor,
            contentColor = contentColor
        ),
        shape = shape
    ) {
        Text(
            modifier = Modifier.padding(16.dp),
            text = item.message,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}
package com.unary.nudge.internal

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.concurrent.atomic.AtomicLong

/**
 * Internal manager responsible for handling notification state and timing.
 *
 * Maintains a state list of [NudgeItem]s that is updated as they are added and removed, and
 * removes each notification after a specified duration.
 */
internal object NudgeManager {

    private val _notifications = MutableStateFlow<List<NudgeItem>>(emptyList())

    /** Currently active notifications. */
    val notifications = _notifications.asStateFlow()

    private val coroutineScope = CoroutineScope(context = SupervisorJob() + Dispatchers.Main)
    private val jobs = mutableMapOf<Long, Job>()

    private val nextId = AtomicLong()

    /**
     * Adds a new notification to the queue and schedules its removal.
     *
     * @param type The type of notification.
     * @param message The text content.
     * @param durationMillis Duration before auto-dismissal.
     */
    fun addNotification(
        type: NudgeType,
        message: String,
        durationMillis: Long
    ) {
        val item = NudgeItem(
            id = nextId.incrementAndGet(),
            message = message,
            type = type
        )

        _notifications.update { current -> listOf(item) + current }

        val job = coroutineScope.launch {
            delay(timeMillis = durationMillis)
            removeNotification(item = item)
        }

        jobs[item.id] = job
    }

    /**
     * Removes a notification from the queue and auto-dismissal.
     *
     * @param item The notification to remove.
     */
    fun removeNotification(item: NudgeItem) {
        _notifications.update { current -> current.filterNot { it.id == item.id } }
        jobs.remove(key = item.id)?.cancel()
    }
}
package com.degel.honoralarm.features.alarm_screen.domain.model

data class Alarm(
    val id: Int? = null,
    val time: String?,
    val label: String? = "",
    val days: List<Day>? = emptyList(),
    val vibrate: Boolean? = false,
    val scheduled: Boolean? = true,
    val oneTimeAlarm: Boolean? = false,
)

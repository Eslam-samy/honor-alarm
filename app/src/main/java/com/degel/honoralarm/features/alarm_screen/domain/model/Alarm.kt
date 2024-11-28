package com.degel.honoralarm.features.alarm_screen.domain.model

data class Alarm(
    val id: Int,
    val time: String,
    val label: String,
    val days: List<Day>,
    val vibrate: Boolean,
    val scheduled: Boolean,
)

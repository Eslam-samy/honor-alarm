package com.degel.honoralarm.features.alarm_screen.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Alarm")
data class AlarmEntity(
    @PrimaryKey(autoGenerate = true) val id: Int?,
    val time: String?,
    val label: String?,
    val days: List<DayEntity>?,
    val vibrate: Boolean?,
    val scheduled: Boolean?,
    val oneTimeAlarm: Boolean?,
)

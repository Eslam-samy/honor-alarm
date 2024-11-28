package com.degel.honoralarm.features.alarm_screen.domain.repository

import com.degel.honoralarm.features.alarm_screen.domain.model.Alarm
import kotlinx.coroutines.flow.Flow

interface AlarmRepository {

    fun getAlarms(): Flow<List<Alarm>>
    suspend fun insertAlarm(alarm: Alarm)
    suspend fun deleteAlarm(alarm: Alarm)
    suspend fun updateAlarm(alarm: Alarm)
}
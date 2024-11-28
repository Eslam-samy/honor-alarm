package com.degel.honoralarm.features.alarm_screen.data.repository

import com.degel.honoralarm.features.alarm_screen.data.date_source.local.AlarmDao
import com.degel.honoralarm.features.alarm_screen.data.mappers.toDataModel
import com.degel.honoralarm.features.alarm_screen.data.mappers.toDomainModel
import com.degel.honoralarm.features.alarm_screen.domain.model.Alarm
import com.degel.honoralarm.features.alarm_screen.domain.repository.AlarmRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AlarmRepositoryImpl(
    private val alarmDao: AlarmDao
) : AlarmRepository {
    override fun getAlarms(): Flow<List<Alarm>> {
        return alarmDao.getAllAlarms().map {
            it.map { it.toDomainModel() }
        }
    }

    override suspend fun insertAlarm(alarm: Alarm) {
        alarmDao.insertAlarm(alarm.toDataModel())
    }

    override suspend fun deleteAlarm(alarm: Alarm) {
        alarmDao.deleteAlarm(alarm.toDataModel())
    }

    override suspend fun updateAlarm(alarm: Alarm) {
        alarmDao.updateAlarm(alarm.toDataModel())
    }
}
package com.degel.honoralarm.features.alarm_screen.domain.usecase

import com.degel.honoralarm.features.alarm_screen.domain.model.Alarm
import com.degel.honoralarm.features.alarm_screen.domain.repository.AlarmRepository

class DeleteAlarmUseCase(
    private val alarmRepository: AlarmRepository
) {
    suspend operator fun invoke(alarm: Alarm) {
        alarmRepository.deleteAlarm(alarm)
    }


}
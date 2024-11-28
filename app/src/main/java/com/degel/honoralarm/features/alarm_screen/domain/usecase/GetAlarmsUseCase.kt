package com.degel.honoralarm.features.alarm_screen.domain.usecase

import com.degel.honoralarm.features.alarm_screen.domain.repository.AlarmRepository

class GetAlarmsUseCase(
    private val alarmRepository: AlarmRepository
) {
    operator fun invoke() = alarmRepository.getAlarms()
}
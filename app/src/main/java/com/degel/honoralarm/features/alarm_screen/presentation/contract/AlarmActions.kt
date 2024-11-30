package com.degel.honoralarm.features.alarm_screen.presentation.contract

import com.degel.honoralarm.features.alarm_screen.domain.model.Alarm
import java.time.LocalTime

sealed class AlarmActions {
    data class OnDeleteAlarm(val alarm: Alarm) : AlarmActions()
    data class OnCreateNewAlarm(val time: LocalTime) : AlarmActions()
    data class OnUpdateAlarm(val alarm: Alarm) : AlarmActions()



}
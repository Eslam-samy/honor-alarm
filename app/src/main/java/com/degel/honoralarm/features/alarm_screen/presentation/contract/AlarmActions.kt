package com.degel.honoralarm.features.alarm_screen.presentation.contract

import com.degel.honoralarm.features.alarm_screen.domain.model.Alarm

sealed class AlarmActions {
    data class OnDeleteAlarm(val alarm: Alarm) : AlarmActions()


}
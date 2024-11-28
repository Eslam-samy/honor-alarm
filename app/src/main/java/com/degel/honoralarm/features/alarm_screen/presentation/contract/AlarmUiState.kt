package com.degel.honoralarm.features.alarm_screen.presentation.contract

import com.degel.honoralarm.features.alarm_screen.domain.model.Alarm

data class AlarmUiState(
    val isLoading: Boolean = false,
    val data:List<Alarm> = emptyList()
)

package com.degel.honoralarm.features.alarm_screen.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.degel.honoralarm.features.alarm_screen.domain.model.Alarm
import com.degel.honoralarm.features.alarm_screen.domain.usecase.DeleteAlarmUseCase
import com.degel.honoralarm.features.alarm_screen.domain.usecase.GetAlarmsUseCase
import com.degel.honoralarm.features.alarm_screen.domain.usecase.InsertAlarmUseCase
import com.degel.honoralarm.features.alarm_screen.domain.usecase.UpdateAlarmUseCase
import com.degel.honoralarm.features.alarm_screen.presentation.contract.AlarmActions
import com.degel.honoralarm.features.alarm_screen.presentation.contract.AlarmUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.time.LocalTime

class AlarmViewModel(
    private val getAlarmsUseCase: GetAlarmsUseCase,
    private val updateAlarmUseCase: UpdateAlarmUseCase,
    private val deleteAlarmUseCase: DeleteAlarmUseCase,
    private val insertAlarmUseCase: InsertAlarmUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(AlarmUiState())
    val state = _state
        .onStart {
            observeAlarms()
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            _state.value
        )

    private fun observeAlarms() {
        getAlarmsUseCase()
            .onEach {
                _state.value = _state.value.copy(
                    data = it
                )
            }
            .launchIn(viewModelScope)
    }

    fun onEvent(event: AlarmActions) {
        when (event) {
            is AlarmActions.OnDeleteAlarm -> {
//                deleteAlarmUseCase(event.alarm)
            }

            is AlarmActions.OnCreateNewAlarm -> {
                createAlarm(event.time)
            }

            is AlarmActions.OnUpdateAlarm -> {
                updateAlarm(event.alarm)
            }
        }
    }

    private fun updateAlarm(alarm: Alarm) {
        viewModelScope.launch {
            updateAlarmUseCase(alarm)
        }
    }

    private fun createAlarm(time: LocalTime) {
        viewModelScope.launch {
            insertAlarmUseCase(
                alarm = Alarm(
                    time = time.toString(),
                    oneTimeAlarm = true
                )
            )
        }
    }
}
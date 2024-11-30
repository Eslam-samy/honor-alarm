package com.degel.honoralarm.features.alarm_screen.presentation.screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.degel.honoralarm.features.alarm_screen.presentation.components.AlarmItemComponent
import com.degel.honoralarm.features.alarm_screen.presentation.components.TimePickerDialog
import com.degel.honoralarm.features.alarm_screen.presentation.contract.AlarmActions
import com.degel.honoralarm.features.alarm_screen.presentation.contract.AlarmUiState
import com.degel.honoralarm.features.alarm_screen.presentation.viewModel.AlarmViewModel
import java.time.LocalTime


@Composable
fun AlarmScreenRoute(
    viewModel: AlarmViewModel,
    modifier: Modifier = Modifier,
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    AlarmScreen(
        state = state,
        modifier = modifier,
        onEvent = viewModel::onEvent
    )

}


@Composable
fun AlarmScreen(
    state: AlarmUiState,
    modifier: Modifier = Modifier,
    onEvent: (AlarmActions) -> Unit = {},
) {
    var showTimePicker by remember { mutableStateOf(false) }

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    )
    {
        if (showTimePicker) {
            TimePickerDialog(
                onDismissRequest = { showTimePicker = false },
                onTimeConfirm = { time ->
                    showTimePicker = false
                    onEvent.invoke(
                        AlarmActions.OnCreateNewAlarm(
                            time = time
                        )
                    )

                },
                initialTime = LocalTime.now()
            )
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)

        ) {
            items(state.data) { alarm ->
                AlarmItemComponent(
                    alarm = alarm,
                    onTitleChanged = {
                        onEvent.invoke(
                            AlarmActions.OnUpdateAlarm(
                                alarm.copy(
                                    label = it
                                )
                            )
                        )
                    },
                    onScheduledChanged = {
                        onEvent.invoke(
                            AlarmActions.OnUpdateAlarm(
                                alarm.copy(
                                    scheduled = it
                                )
                            )
                        )
                    }
                )
            }
        }
        IconButton(
            onClick = {
                showTimePicker = true
            },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp)
                .size(100.dp)
                .clip(
                    shape = CircleShape
                )
                .background(
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                ),

            ) {
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primaryContainer,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}
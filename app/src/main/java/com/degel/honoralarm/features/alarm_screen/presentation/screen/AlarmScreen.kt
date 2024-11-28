package com.degel.honoralarm.features.alarm_screen.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.degel.honoralarm.features.alarm_screen.presentation.components.AlarmItemComponent
import com.degel.honoralarm.features.alarm_screen.presentation.contract.AlarmUiState
import com.degel.honoralarm.features.alarm_screen.presentation.viewModel.AlarmViewModel


@Composable
fun AlarmScreenRoute(
    viewModel: AlarmViewModel,
    modifier: Modifier = Modifier
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    AlarmScreen(
        state = state,
        modifier = modifier
    )

}


@Composable
fun AlarmScreen(
    state: AlarmUiState,
    modifier: Modifier = Modifier,
) {

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    )
    {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)

        ) {
            items(state.data) {
                AlarmItemComponent(
                    alarm = it
                )

            }
        }
    }
}
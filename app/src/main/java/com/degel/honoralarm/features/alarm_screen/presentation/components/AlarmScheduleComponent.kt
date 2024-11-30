package com.degel.honoralarm.features.alarm_screen.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.degel.honoralarm.R
import com.degel.honoralarm.features.alarm_screen.domain.model.Day
import com.degel.honoralarm.features.utils.getWeekDays
import java.time.LocalTime
import java.time.format.DateTimeFormatter

@Preview(showBackground = true)
@Composable
fun AlarmScheduleComponent(
    modifier: Modifier = Modifier,
    days: List<Day> = listOf(),
    scheduled: Boolean = true,
    onScheduledChanged: (Boolean) -> Unit = {},
    time: String = "16:40",
) {
    val textColor = if (scheduled) Color.Unspecified else MaterialTheme.colorScheme.surfaceVariant
    val text = if (!scheduled) {
        stringResource(R.string.not_scheduled)
    } else if (
        days.isEmpty()
    ) {
        // Parse the timeText to LocalTime
        val formatter = DateTimeFormatter.ofPattern("HH:mm") // Assuming time is in HH:mm format
        val parsedTime = LocalTime.parse(time, formatter)
        // Get current time
        val currentTime = LocalTime.now()
        // Compare the parsed time with the current time
        if (parsedTime.isBefore(currentTime)) {
            stringResource(R.string.tomorrow)
        } else {
            stringResource(R.string.today)
        }
    } else {
        days.joinToString(", ") { it.name }
    }
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier
                .weight(1f)
        ) {
            Text(
                text = text,
                style = MaterialTheme.typography.labelMedium.copy(
                    color = textColor
                )
            )

        }

        Switch(
            checked = scheduled,
            onCheckedChange = onScheduledChanged
        )

    }

}
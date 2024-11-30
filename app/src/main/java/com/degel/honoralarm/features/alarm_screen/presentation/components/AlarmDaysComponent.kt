package com.degel.honoralarm.features.alarm_screen.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.degel.honoralarm.features.alarm_screen.domain.model.Day
import com.degel.honoralarm.features.utils.getWeekDaysAsChar

@Composable
fun AlarmDaysComponent(
    modifier: Modifier = Modifier,
    days: List<Day>?,
) {

    val shortDays = getWeekDaysAsChar()

    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween

    ) {
        shortDays.forEach { day ->
            val isSelected =
                days?.any { it.id == day.id }
                    ?: false // Check if the day is in the list of selected days

            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(30.dp)
                    .background(
                        color = if (isSelected) Color.Green else Color.Magenta, // Change color based on selection
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = day.name,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.Medium
                    ),
                )

            }
        }
    }
}
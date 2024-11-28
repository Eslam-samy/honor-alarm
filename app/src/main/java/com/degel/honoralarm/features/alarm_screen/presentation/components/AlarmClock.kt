package com.degel.honoralarm.features.alarm_screen.presentation.components

import android.provider.AlarmClock
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun AlarmClock(
    modifier: Modifier = Modifier,
    title: String = "15:20",
    day: Boolean = true,
    enabled: Boolean = false
) {
    val textColor = if (enabled) Color.Unspecified else MaterialTheme.colorScheme.surfaceVariant
    val fontWeight = if (enabled) FontWeight.Medium else FontWeight.Normal
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.Bottom
    ) {
        Text(
            title,
            style = MaterialTheme.typography.displayMedium.copy(
                fontWeight = fontWeight,
                color = textColor
            )
        )
        Spacer(
            modifier = Modifier
                .width(16.dp)
        )
        Text(
            if (day) "AM" else "PM",
            style = MaterialTheme.typography.bodyMedium.copy(
                fontWeight = fontWeight,
                color = textColor
            ),
            modifier = Modifier.padding(bottom = 8.dp),
        )
    }
}
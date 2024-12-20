package com.degel.honoralarm.features.alarm_screen.presentation.components

import android.content.res.Resources.Theme
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.Label
import androidx.compose.material.icons.filled.ArrowDropDownCircle
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Label
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.Label
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.degel.honoralarm.features.alarm_screen.domain.model.Alarm
import kotlin.math.exp

@Composable
fun AlarmItemComponent(
    modifier: Modifier = Modifier,
    alarm: Alarm,
    onTitleChanged: (String?) -> Unit = {},
    onScheduledChanged: (Boolean) -> Unit = {},
) {

    var expanded by remember {
        mutableStateOf(false)
    }
    var showTitleDialog by remember {
        mutableStateOf(false)
    }

    Box(
        modifier = modifier
            .clip(
                shape = RoundedCornerShape(20.dp)
            )
            .clickable {
                expanded = !expanded
            }
            .background(color = MaterialTheme.colorScheme.surfaceContainer)
            .padding(vertical = 8.dp, horizontal = 16.dp)


    ) {
        Column {
            // for alarm title
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                TitleComponent(
                    expanded = expanded,
                    enabled = alarm.scheduled == true,
                    title = alarm.label
                ) {
                    if (expanded) {
                        showTitleDialog = true
                    } else {
                        expanded = false
                    }
                }
                ExpandedIcon(
                    modifier = Modifier
                        .size(18.dp),
                    isExpanded = expanded,
                    onClick = {
                        expanded = !expanded
                    },
                )
            }
            if (expanded) {
                Spacer(
                    modifier = Modifier
                        .height(16.dp)
                )
            }
            // for the clock
            AlarmClock(
                time = alarm.time,
                enabled = alarm.scheduled == true,
            )
            Spacer(
                modifier = Modifier
                    .height(16.dp)
            )
            AlarmScheduleComponent(
                scheduled = alarm.scheduled == true,
                onScheduledChanged = onScheduledChanged
            )
            if (expanded) {
                Spacer(
                    modifier = Modifier
                        .height(16.dp)
                )
                AlarmDaysComponent(
                    days = alarm.days
                )

            }


        }

        if (showTitleDialog) {
            AlarmTitleDialog(
                onDismissRequest = {
                    showTitleDialog = false
                },
                initialTitle = alarm.label,
                onTitleConfirm = {
                    showTitleDialog = false
                    onTitleChanged(it)
                }
            )
        }
    }
}
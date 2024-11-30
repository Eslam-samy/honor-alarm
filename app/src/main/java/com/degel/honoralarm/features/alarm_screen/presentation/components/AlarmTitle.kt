package com.degel.honoralarm.features.alarm_screen.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.Label
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun RowScope.TitleComponent(
    modifier: Modifier = Modifier,
    title: String? = null,
    expanded: Boolean,
    enabled: Boolean,
    onClicked: () -> Unit,
) {
    val textColor = if (enabled) Color.Unspecified else MaterialTheme.colorScheme.surfaceVariant
    Box(
        modifier = modifier
            .weight(1f)
            .fillMaxHeight(),
    ) {
        if (expanded) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable(onClick = onClicked),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier
                        .size(18.dp),
                    imageVector = Icons.AutoMirrored.Outlined.Label,
                    contentDescription = null,
                )
                Spacer(
                    modifier = Modifier
                        .width(8.dp)
                )
                if (!title.isNullOrEmpty())
                    Text(
                        title,
                        style = MaterialTheme.typography.labelMedium.copy(
                            color = textColor
                        )
                    )

            }
        }
    }
}
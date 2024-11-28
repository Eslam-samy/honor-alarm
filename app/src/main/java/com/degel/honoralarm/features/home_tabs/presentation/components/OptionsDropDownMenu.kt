package com.degel.honoralarm.features.home_tabs.presentation.components

import androidx.compose.animation.core.tween
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.degel.honoralarm.R
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.ui.graphics.graphicsLayer

@Composable
fun OptionsDropDownMenu(
    modifier: Modifier = Modifier,
    isShown: Boolean,
    onChangeState: () -> Unit
) {
    val transitionAlpha = animateFloatAsState(
        targetValue = if (isShown) 1f else 0f,
        animationSpec = tween(durationMillis = 200), label = "" // Controls the fade duration
    )

    val transitionHeight = animateDpAsState(
        targetValue = if (isShown) 300.dp else 0.dp, // Adjust the target height as necessary
        animationSpec = tween(durationMillis = 50), label = ""
    )

    DropdownMenu(
        modifier = Modifier
            .fillMaxWidth(0.5f)
            .background(
                color = MaterialTheme.colorScheme.secondaryContainer,
                shape = RoundedCornerShape(30.dp)
            )
            .heightIn(0.dp, transitionHeight.value) // Animate the height change
            .animateContentSize() // Animate content size changes
            .graphicsLayer(alpha = transitionAlpha.value), // Apply fade animation
        expanded = isShown, // Menu visibility
        onDismissRequest = onChangeState, // Hide menu on outside click
        offset = DpOffset(
            x = (-10).dp,
            y = 5.dp
        ),
    ) {
        DropdownMenuItem(
            text = {
                Text(stringResource(R.string.screen_saver))
            },
            onClick = {
                onChangeState() // Close menu
            }
        )
        DropdownMenuItem(
            text = {
                Text(stringResource(R.string.settings))
            },
            onClick = {
                onChangeState() // Close menu
            }
        )
        DropdownMenuItem(
            text = {
                Text(stringResource(R.string.privacy_policy))
            },
            onClick = {
                onChangeState() // Close menu
            }
        )
        DropdownMenuItem(
            text = {
                Text(stringResource(R.string.send_feedback))
            },
            onClick = {
                onChangeState() // Close menu
            }
        )
        DropdownMenuItem(
            text = {
                Text(stringResource(R.string.help))
            },
            onClick = {
                onChangeState() // Close menu
            }
        )

    }
}

package com.degel.honoralarm.features.alarm_screen.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import com.degel.honoralarm.R
import kotlinx.coroutines.job
import java.time.LocalTime
import kotlin.coroutines.coroutineContext


@Composable
fun AlarmTitleDialog(
    modifier: Modifier = Modifier,
    initialTitle: String? = "",
    onDismissRequest: () -> Unit,
    onTitleConfirm: (String?) -> Unit,

    ) {
    var title by remember {
        mutableStateOf(initialTitle ?: "")
    }
    val focusRequester = remember {
        androidx.compose.ui.focus.FocusRequester()
    }

    LaunchedEffect(Unit) {
        coroutineContext.job.invokeOnCompletion {
            focusRequester.requestFocus()
        }
    }
    AlertDialog(
        modifier = Modifier.fillMaxWidth(),
        onDismissRequest = onDismissRequest,
        properties = DialogProperties(
            usePlatformDefaultWidth = true
        ),

        text = {
            OutlinedTextField(
                label = {
                    Text(text = stringResource(R.string.label))
                },
                modifier = modifier.focusRequester(focusRequester),
                value = title,
                onValueChange = {
                    title = it
                }
            )
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onTitleConfirm(title)
                }) {
                Text(stringResource(R.string.ok))
            }
        },
        dismissButton = {
            TextButton(onClick = onDismissRequest) {
                Text("Cancel")
            }
        }
    )
}
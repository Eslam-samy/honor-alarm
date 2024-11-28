package com.degel.honoralarm.features.home_tabs.presentation.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight

@Composable
fun DropDownMenuText(
    modifier: Modifier = Modifier,
    text:String

) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.titleSmall.copy(
            fontWeight = FontWeight.Medium

        )
    )
}
package com.degel.honoralarm.features.home_tabs.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppbar(
    scrollBehavior: TopAppBarScrollBehavior,
    modifier: Modifier = Modifier,
    title: String = "",
    onMoreClicked: () -> Unit = {},
) {
    var showMenu by remember { mutableStateOf(false) } // Tracks menu visibility
    TopAppBar(
        scrollBehavior = scrollBehavior,
        title = {
            Text(title)
        },
        actions = {
            IconButton(onClick = {
                showMenu = !showMenu
            }) {
                Icon(
                    imageVector = Icons.Filled.MoreVert,
                    contentDescription = null
                )
            }
            OptionsDropDownMenu(
                isShown = showMenu,
                onChangeState = {
                    showMenu = !showMenu
                }
            )
        }
    )
}
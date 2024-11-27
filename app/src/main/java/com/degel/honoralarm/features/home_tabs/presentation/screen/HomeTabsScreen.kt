package com.degel.honoralarm.features.home_tabs.presentation.screen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Alarm
import androidx.compose.material.icons.filled.Hotel
import androidx.compose.material.icons.filled.HourglassTop
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material.icons.outlined.Alarm
import androidx.compose.material.icons.outlined.Hotel
import androidx.compose.material.icons.outlined.HourglassTop
import androidx.compose.material.icons.outlined.Schedule
import androidx.compose.material.icons.outlined.Timer
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.util.fastForEachIndexed
import com.degel.honoralarm.R
import com.degel.honoralarm.features.home_tabs.presentation.ui_models.BottomNavigationItem

@Composable
fun HomeTabsScreen(modifier: Modifier = Modifier) {
    val items = listOf(
        BottomNavigationItem(
            title = stringResource(id = R.string.alarm),
            icon = Icons.Outlined.Alarm,
        ),
        BottomNavigationItem(
            title = stringResource(id = R.string.clock),
            icon = Icons.Outlined.Schedule,
        ),
        BottomNavigationItem(
            title = stringResource(id = R.string.timer),
            icon = Icons.Outlined.HourglassTop,
        ),
        BottomNavigationItem(
            title = stringResource(id = R.string.timer),
            icon = Icons.Outlined.Timer,
        ),
        BottomNavigationItem(
            title = stringResource(id = R.string.bed_time),
            icon = Icons.Filled.Hotel,
        ),
    )
    var selectedIndex by rememberSaveable {
        mutableIntStateOf(0)
    }
    Scaffold(
        modifier = modifier,

        bottomBar = {

            NavigationBar (

            ){
//                items.fastForEachIndexed { i, bottomNavigationItem ->
//                    NavigationBarItem(
//                        selected = selectedIndex == i,
//                        onClick = {
//                            selectedIndex = i
//                        },
//                        label = {
//                            Text(text = bottomNavigationItem.title)
//                        },
//                        icon = {
//                            Icon(imageVector = bottomNavigationItem.icon, contentDescription = null)
//                        })
//                }
            }
        }
    ) {
        it

    }
}
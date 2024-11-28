package com.degel.honoralarm.features.home_tabs.presentation.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Hotel
import androidx.compose.material.icons.outlined.Alarm
import androidx.compose.material.icons.outlined.HourglassTop
import androidx.compose.material.icons.outlined.Schedule
import androidx.compose.material.icons.outlined.Timer
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEachIndexed
import com.degel.honoralarm.R
import com.degel.honoralarm.features.home_tabs.presentation.ui_models.BottomNavigationItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.input.nestedscroll.nestedScroll
import com.degel.honoralarm.features.home_tabs.presentation.components.MyTopAppbar
import com.degel.honoralarm.features.alarm_screen.presentation.screen.AlarmScreen
import com.degel.honoralarm.features.alarm_screen.presentation.screen.AlarmScreenRoute
import com.degel.honoralarm.features.alarm_screen.presentation.viewModel.AlarmViewModel
import com.degel.honoralarm.features.utils.AutoResizedText
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Preview
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
            title = stringResource(id = R.string.stop_watch),
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

    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

    Scaffold(modifier = modifier
        .nestedScroll(scrollBehavior.nestedScrollConnection),
        bottomBar = {
            NavigationBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp)

            ) {
                items.fastForEachIndexed { i, bottomNavigationItem ->
                    NavigationBarItem(modifier = Modifier.height(56.dp),
                        selected = selectedIndex == i,
                        onClick = {
                            selectedIndex = i
                        },
                        label = {
                            AutoResizedText(
                                modifier = Modifier,
                                text = bottomNavigationItem.title,
                                style = MaterialTheme.typography.labelSmall.copy(
                                    fontWeight = if (selectedIndex == i) FontWeight.Bold else FontWeight.Medium
                                ),
                            )
                        },
                        icon = {
                            Icon(imageVector = bottomNavigationItem.icon, contentDescription = null)
                        })
                }
            }
        }, topBar = {
            MyTopAppbar(
                scrollBehavior = scrollBehavior,
                title = items[selectedIndex].title,
                onMoreClicked = {

                }
            )
        }) {
        val viewModel = koinViewModel<AlarmViewModel>()
        AlarmScreenRoute(
            viewModel = viewModel,
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        )

    }
}
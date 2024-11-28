package com.degel.honoralarm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.degel.honoralarm.features.home_tabs.presentation.screen.HomeTabsScreen
import com.degel.honoralarm.ui.theme.HonorAlarmTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HonorAlarmTheme {
                HomeTabsScreen(
                    modifier = Modifier
//                            .padding(innerPadding)
                        .fillMaxSize()
                )
            }
        }
    }
}


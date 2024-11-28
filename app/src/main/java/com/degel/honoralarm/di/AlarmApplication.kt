package com.degel.honoralarm.di

import android.app.Application
import com.degel.honoralarm.features.alarm_screen.di.alarmModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.Level

class AlarmApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@AlarmApplication)
            modules(
                buildList {
                    addAll(
                        listOf(
                            alarmModule
                        )
                    )
                })
        }
    }
}
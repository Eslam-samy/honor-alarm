package com.degel.honoralarm.features.alarm_screen.di

import androidx.room.Room
import com.degel.honoralarm.features.alarm_screen.data.date_source.local.AlarmDataBase
import com.degel.honoralarm.features.alarm_screen.data.repository.AlarmRepositoryImpl
import com.degel.honoralarm.features.alarm_screen.domain.repository.AlarmRepository
import com.degel.honoralarm.features.alarm_screen.domain.usecase.DeleteAlarmUseCase
import com.degel.honoralarm.features.alarm_screen.domain.usecase.GetAlarmsUseCase
import com.degel.honoralarm.features.alarm_screen.domain.usecase.InsertAlarmUseCase
import com.degel.honoralarm.features.alarm_screen.domain.usecase.UpdateAlarmUseCase
import com.degel.honoralarm.features.alarm_screen.presentation.viewModel.AlarmViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.Module
import org.koin.dsl.bind
import org.koin.dsl.module

val alarmModule = module{

    single {
        Room.databaseBuilder(
            androidContext(), AlarmDataBase::class.java, "alarm_database"
        ).fallbackToDestructiveMigration().build()
    }
    single {
        get<AlarmDataBase>().alarmDao()
    }

    factory<AlarmRepository> {
        AlarmRepositoryImpl(get())
    } bind AlarmRepository::class


    factory {
        GetAlarmsUseCase(get())
    }
    factory {
        DeleteAlarmUseCase(get())
    }
    factory {
        InsertAlarmUseCase(get())
    }
    factory {
        UpdateAlarmUseCase(get())
    }

    viewModelOf(::AlarmViewModel)


}
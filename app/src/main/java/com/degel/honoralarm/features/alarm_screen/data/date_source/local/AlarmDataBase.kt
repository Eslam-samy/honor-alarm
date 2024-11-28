package com.degel.honoralarm.features.alarm_screen.data.date_source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.degel.honoralarm.features.alarm_screen.data.model.AlarmEntity

@Database(
    entities = [AlarmEntity::class],
    version = 1,
    exportSchema = true
)
@TypeConverters(
    DaysTypeConverter::class
)
abstract class AlarmDataBase : RoomDatabase() {
    abstract fun alarmDao(): AlarmDao
}
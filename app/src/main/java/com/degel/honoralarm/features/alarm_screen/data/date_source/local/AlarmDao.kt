package com.degel.honoralarm.features.alarm_screen.data.date_source.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.degel.honoralarm.features.alarm_screen.data.model.AlarmEntity
import com.degel.honoralarm.features.alarm_screen.domain.model.Alarm
import kotlinx.coroutines.flow.Flow

@Dao
interface AlarmDao {

    @Query("SELECT * FROM alarm")
    fun getAllAlarms(): Flow<List<AlarmEntity>>

    @Query("SELECT * FROM alarm WHERE id = :id")
    suspend fun getAlarmById(id: Int): AlarmEntity

    @Delete
    suspend fun deleteAlarm(alarm: AlarmEntity)

    @Update
    suspend fun updateAlarm(alarm: AlarmEntity)


    @Query("DELETE FROM alarm")
    suspend fun deleteAllAlarms()

    @Query("DELETE FROM alarm WHERE id = :id")
    suspend fun deleteAlarmById(id: Int)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAlarm(alarm: AlarmEntity)


}
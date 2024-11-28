package com.degel.honoralarm.features.alarm_screen.data.mappers

import com.degel.honoralarm.features.alarm_screen.data.model.AlarmEntity
import com.degel.honoralarm.features.alarm_screen.data.model.DayEntity
import com.degel.honoralarm.features.alarm_screen.domain.model.Alarm
import com.degel.honoralarm.features.alarm_screen.domain.model.Day

fun AlarmEntity.toDomainModel(): Alarm = Alarm(
    id = id,
    days = days.map { it.toDomain() },
    time = time,
    scheduled = scheduled,
    label = label,
    vibrate = vibrate

)

fun DayEntity.toDomain(): Day = Day(
    id = id,
    name = name,
    selected = selected
)

fun Alarm.toDataModel(): AlarmEntity = AlarmEntity(
    id = id,
    days = days.map { it.toDataModel() },
    time = time,
    scheduled = scheduled,
    label = label,
    vibrate = vibrate

)

fun Day.toDataModel(): DayEntity = DayEntity(
    id = id,
    name = name,
    selected = selected
)
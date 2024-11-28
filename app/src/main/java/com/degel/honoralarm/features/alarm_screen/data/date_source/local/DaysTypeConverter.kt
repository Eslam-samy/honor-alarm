package com.degel.honoralarm.features.alarm_screen.data.date_source.local

import androidx.room.TypeConverter
import com.degel.honoralarm.features.alarm_screen.data.model.DayEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.Base64

class DaysTypeConverter {
    private val gson = Gson()

    // Converter for List<Addres?>
    @TypeConverter
    fun fromDaysList(value: List<DayEntity>?): String? {
        return gson.toJson(value)
    }

    @TypeConverter
    fun toDaysList(value: String?): List<DayEntity>? {
        val listType = object : TypeToken<List<DayEntity>?>() {}.type
        return gson.fromJson(value, listType)
    }

}
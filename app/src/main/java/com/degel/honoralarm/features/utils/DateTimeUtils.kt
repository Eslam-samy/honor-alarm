package com.degel.honoralarm.features.utils

import com.degel.honoralarm.features.alarm_screen.domain.model.Day
import java.time.DayOfWeek
import java.time.format.TextStyle
import java.util.Calendar
import java.util.Locale


fun getWeekDays(): List<Day> {
    // Map over DayOfWeek entries and return a list of Day objects
    return DayOfWeek.entries.toTypedArray().mapIndexed { index, dayOfWeek ->
        Day(
            id = index, // The index of the day
            name = dayOfWeek.getDisplayName(
                TextStyle.SHORT,
                Locale.getDefault()
            ) // Short name of the day
        )
    }
}
fun getWeekDaysAsChar(): List<Day> {
    // Map over DayOfWeek entries and return a list of Day objects with single character names
    return DayOfWeek.entries.toTypedArray().mapIndexed { index, dayOfWeek ->
        Day(
            id = index, // The index of the day
            name = dayOfWeek.getDisplayName(
                TextStyle.SHORT,
                Locale.getDefault()
            ).firstOrNull().toString() // Get the first character of the short name
        )
    }
}

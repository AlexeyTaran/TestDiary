package com.taran.testdiary.data.db.converter

import androidx.room.TypeConverter
import java.util.*

class CalendarConverter {

    @TypeConverter
    fun fromTimestamp(value: Long): Calendar {
        return Calendar.getInstance().apply { timeInMillis = value }
    }

    @TypeConverter
    fun toTimestamp(calendar: Calendar): Long {
        return calendar.timeInMillis
    }
}
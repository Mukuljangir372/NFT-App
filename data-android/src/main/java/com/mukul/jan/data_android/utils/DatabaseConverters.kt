package com.mukul.jan.data_android.utils

import androidx.room.TypeConverter
import java.util.*

class DatabaseConverters {

    @TypeConverter
    fun fromDate(date: Date?) : Long?{
        return date?.time
    }

    @TypeConverter
    fun toDate(date: Long?) : Date? {
        return date?.let { Date(it) }
    }

}
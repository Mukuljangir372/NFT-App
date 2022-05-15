package com.mukul.jan.core_android.network

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.mukul.jan.core_android.network.NetworkUtils.DATE_DASH_HMS
import com.mukul.jan.core_android.network.NetworkUtils.UTC_FORMAT
import com.mukul.jan.core_android.network.NetworkUtils.YEAR_MONTH_DAY_WITH_DASH
import java.lang.reflect.Type
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class DateDeserializer : JsonDeserializer<Date> {

    override fun deserialize(
        element: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): Date? {
        val date = element!!.asString

        if (date.matches("^[0-9]*\$".toRegex()))
            return Date(date.toLong())
        else {
            val format = when {
                date.contains("Z", ignoreCase = true) -> SimpleDateFormat(UTC_FORMAT, Locale.ENGLISH)
                date.contains(":") -> SimpleDateFormat(DATE_DASH_HMS, Locale.ENGLISH)
                else -> SimpleDateFormat(YEAR_MONTH_DAY_WITH_DASH, Locale.ENGLISH)
            }

            format.timeZone = TimeZone.getTimeZone("IST")

            return try {
                format.parse(date)!!
            } catch (exp: ParseException) {
                exp.printStackTrace()
                null
            }
        }

    }
}
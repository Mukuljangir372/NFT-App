package com.mukul.jan.core_android.network

object NetworkUtils {
    private const val HOUR_MINUTE_SECONDS = "HH:mm:ss"
    const val YEAR_MONTH_DAY_WITH_DASH = "yyyy-MM-dd"

    const val UTC_FORMAT = "$YEAR_MONTH_DAY_WITH_DASH'T'$HOUR_MINUTE_SECONDS.SSS'Z'"
    const val DATE_DASH_HMS = "$YEAR_MONTH_DAY_WITH_DASH $HOUR_MINUTE_SECONDS"
}
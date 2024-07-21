package com.example.kukufmassignment.utils

import java.text.SimpleDateFormat
import java.util.Locale
import java.util.TimeZone

object CommonUtils {

    fun getDateTime(dateTime: String?): String?{
        dateTime?.let {
            val utcFormat = SimpleDateFormat(AppConstants.UTC_DATE_FORMAT, Locale.getDefault()).apply {
                timeZone = TimeZone.getTimeZone("UTC")
        }
            try {
                val date = utcFormat.parse(dateTime)
                val displayFormat = SimpleDateFormat(AppConstants.DISPLAY_DATE_FORMAT, Locale.getDefault())
                return displayFormat.format(date)
            }catch (e: Exception){}
    }
        return null
    }

}
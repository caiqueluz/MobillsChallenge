package com.caiqueluz.mobillschallenge

import java.text.SimpleDateFormat
import java.util.*

class DateConverter {

    fun convert(date: Date): String {
        val formatter = SimpleDateFormat.getInstance()
        return formatter.format(date)
    }
}

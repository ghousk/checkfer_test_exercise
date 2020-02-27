package com.innovativequest.checkfer_test_exercise.util

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Ghous Khan on 2020-02-27
 */
object Utils {

    private val INPUT_DATE_FORMAT_FULL = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
    private val OUTPUT_DATE_FORMAT = SimpleDateFormat("dd MMMM yyyy")


    fun getDateInDisplayableFormat(inputDateStr: String?): String{
        return OUTPUT_DATE_FORMAT.format(INPUT_DATE_FORMAT_FULL.parse(inputDateStr))
    }

    fun getCurrentTime(): Long {
        return Date().time
    }
}
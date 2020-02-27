package com.innovativequest.checkfer_test_exercise.model

import androidx.room.TypeConverter

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object Converters {

        @TypeConverter
        @JvmStatic
        fun fromString(data: String?): BadgeCounts {

            var gson = Gson()
            if (data == null) {
                return BadgeCounts()
            }

            val objectType = object : TypeToken<BadgeCounts>() {
            }.type

            return gson.fromJson(data, objectType)
        }

        @TypeConverter
        @JvmStatic
        fun toString(someObject: BadgeCounts): String {
            var gson = Gson()

            return gson.toJson(someObject)
        }

    @TypeConverter
    @JvmStatic
    fun fromStringToDataListItemResponse(data: String?): List<DataListItem>? {

        var gson = Gson()
        if (data == null) {
            return ArrayList<DataListItem>()
        }

        val objectType = object : TypeToken<List<DataListItem>>() {
        }.type

        return gson.fromJson(data, objectType)
    }

    @TypeConverter
    @JvmStatic
    fun fromDataListItemResponsesToString(someObject: List<DataListItem>?): String {
        var gson = Gson()

        return gson.toJson(someObject)
    }
}

package com.example.kukufmassignment.utils

import androidx.room.TypeConverter
import com.example.kukufmassignment.model.LaunchFailureDetails
import com.example.kukufmassignment.model.LaunchSite
import com.example.kukufmassignment.model.Links
import com.example.kukufmassignment.model.Rocket
import com.example.kukufmassignment.model.Telemetry
import com.example.kukufmassignment.model.Timeline
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {
    @TypeConverter
    fun fromLaunchSite(value: LaunchSite?): String? {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun toLaunchSite(value: String?): LaunchSite? {
        val type = object : TypeToken<LaunchSite?>() {}.type
        return Gson().fromJson(value, type)
    }

    @TypeConverter
    fun fromLinks(value: Links?): String? {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun toLinks(value: String): Links? {
        val type = object : TypeToken<Links?>() {}.type
        return Gson().fromJson(value, type)
    }

    @TypeConverter
    fun fromMissionId(value: List<String?>?): String? {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun toMissionId(value: String?): List<String?> ?{
        val type = object : TypeToken<List<String?>>() {}.type
        return Gson().fromJson(value, type)
    }

    @TypeConverter
    fun fromRocket(value: Rocket?): String? {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun toRocket(value: String?): Rocket? {
        val type = object : TypeToken<Rocket?>() {}.type
        return Gson().fromJson(value, type)
    }


    @TypeConverter
    fun fromTelemetry(value: Telemetry?): String? {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun toTelemetry(value: String?): Telemetry? {
        val type = object : TypeToken<Telemetry?>() {}.type
        return Gson().fromJson(value, type)
    }



    @TypeConverter
    fun fromTimeline(value: Timeline?): String? {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun toTimeline(value: String?): Timeline? {
        val type = object : TypeToken<Timeline?>() {}.type
        return Gson().fromJson(value, type)
    }

    @TypeConverter
    fun fromLaunchFailureDetails(value: LaunchFailureDetails?): String? {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun toLaunchFailureDetails(value: String?): LaunchFailureDetails? {
        val type = object : TypeToken<LaunchFailureDetails?>() {}.type
        return Gson().fromJson(value, type)
    }
}

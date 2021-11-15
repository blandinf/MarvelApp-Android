package com.blandinf.marvelapp.networking.remote

import com.google.gson.annotations.SerializedName

/** The attributes of the Date object */
@Suppress("unused")
data class DateRemote (
    @SerializedName("Type") val type: DateType,
    @SerializedName("Date") val date: String
)

enum class DateType {
    FocDate,
    OnsaleDate
}
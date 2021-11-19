package com.blandinf.marvelapp.networking.remote.models

import com.google.gson.annotations.SerializedName

/** The attributes of the Date object */
@Suppress("unused")
data class DateRemote(
    @SerializedName("type") val type: DateType,
    @SerializedName("date") val date: String
)

enum class DateType {
    @SerializedName("focDate")
    FocDate,

    @SerializedName("onsaleDate")
    OnsaleDate
}
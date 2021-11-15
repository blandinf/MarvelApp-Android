package com.blandinf.marvelapp.networking.remote

import com.google.gson.annotations.SerializedName

/** The attributes of the Serie object */
@Suppress("unused")
data class SerieRemote (
    @SerializedName("ResourceURI") val resourceURI: String,
    @SerializedName("Name") val name: String
)
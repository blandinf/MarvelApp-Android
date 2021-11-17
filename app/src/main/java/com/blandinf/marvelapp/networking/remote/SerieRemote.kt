package com.blandinf.marvelapp.networking.remote

import com.google.gson.annotations.SerializedName

/** The attributes of the Serie object */
@Suppress("unused")
data class SerieRemote (
    @SerializedName("resourceURI") val resourceURI: String,
    @SerializedName("name") val name: String
)
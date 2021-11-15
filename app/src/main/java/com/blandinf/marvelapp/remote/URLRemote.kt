package com.blandinf.marvelapp.remote

import com.google.gson.annotations.SerializedName

/** The attributes of the URL object */
@Suppress("unused")
data class URLRemote (
    @SerializedName("Type") val type: URLType,
    @SerializedName("Url") val url: String
)

enum class URLType {
    Detail,
    Purchase
}
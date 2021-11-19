package com.blandinf.marvelapp.networking.remote.models

import com.google.gson.annotations.SerializedName

/** The attributes of the URL object */
@Suppress("unused")
data class URLRemote(
    @SerializedName("type") val type: URLType,
    @SerializedName("url") val url: String
)

enum class URLType {
    @SerializedName("detail")
    Detail,

    @SerializedName("purchase")
    Purchase
}
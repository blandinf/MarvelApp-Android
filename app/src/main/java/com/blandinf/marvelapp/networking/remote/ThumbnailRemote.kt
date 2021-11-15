package com.blandinf.marvelapp.networking.remote

import com.google.gson.annotations.SerializedName

/** The attributes of the Thumbnail object */
@Suppress("unused")
data class ThumbnailRemote (
    @SerializedName("Path") val path: String,
    @SerializedName("Extension") val extension: Extension
)

enum class Extension {
    Jpg
}
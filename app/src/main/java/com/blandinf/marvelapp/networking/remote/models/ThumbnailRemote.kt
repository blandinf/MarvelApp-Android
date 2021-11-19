package com.blandinf.marvelapp.networking.remote.models

import com.google.gson.annotations.SerializedName

/** The attributes of the Thumbnail object */
@Suppress("unused")
data class ThumbnailRemote(
    @SerializedName("path") val path: String,
    @SerializedName("extension") val extension: Extension
)

enum class Extension {
    @SerializedName("jpg")
    jpg
}
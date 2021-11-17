package com.blandinf.marvelapp.networking.remote

import com.google.gson.annotations.SerializedName

/** The attributes of the Creator object */
@Suppress("unused")
data class CreatorRemote (
    @SerializedName("available") val available: Long,
    @SerializedName("collectionURI") val collectionURI: String,
    @SerializedName("items") val items: List<CreatorItemRemote>,
    @SerializedName("returned") val returned: Long
)
package com.blandinf.marvelapp.networking.remote

import com.google.gson.annotations.SerializedName

/** The attributes of the Character object */
@Suppress("unused")
data class CharacterRemote (
    @SerializedName("available") val available: Long,
    @SerializedName("collectionURI") val collectionURI: String,
    @SerializedName("items") val items: List<SerieRemote>,
    @SerializedName("returned") val returned: Long
)
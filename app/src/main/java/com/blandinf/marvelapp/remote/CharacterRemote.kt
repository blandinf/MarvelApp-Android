package com.blandinf.marvelapp.remote

import com.google.gson.annotations.SerializedName

/** The attributes of the Character object */
@Suppress("unused")
data class CharacterRemote (
    @SerializedName("Available") val available: Long,
    @SerializedName("CollectionURI") val collectionURI: String,
    @SerializedName("Items") val items: List<SerieRemote>,
    @SerializedName("Returned") val returned: Long
)
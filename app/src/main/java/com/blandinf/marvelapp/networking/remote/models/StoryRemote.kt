package com.blandinf.marvelapp.networking.remote.models

import com.google.gson.annotations.SerializedName

/** The attributes of the Story object */
@Suppress("unused")
data class StoryRemote(
    @SerializedName("available") val available: Long,
    @SerializedName("collectionURI") val collectionURI: String,
    @SerializedName("items") val items: List<StoryItemRemote>,
    @SerializedName("returned") val returned: Long
)
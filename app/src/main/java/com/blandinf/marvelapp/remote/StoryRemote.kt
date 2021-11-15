package com.blandinf.marvelapp.remote

import com.google.gson.annotations.SerializedName

/** The attributes of the Story object */
@Suppress("unused")
data class StoryRemote (
    @SerializedName("Available") val available: Long,
    @SerializedName("CollectionURI") val collectionURI: String,
    @SerializedName("Items") val items: List<StoryItemRemote>,
    @SerializedName("Returned") val returned: Long
)
package com.blandinf.marvelapp.remote

import com.google.gson.annotations.SerializedName

/** The attributes of the Creator object */
@Suppress("unused")
data class CreatorRemote (
    @SerializedName("Available") val available: Long,
    @SerializedName("CollectionURI") val collectionURI: String,
    @SerializedName("Items") val items: List<CreatorItemRemote>,
    @SerializedName("Returned") val returned: Long
)
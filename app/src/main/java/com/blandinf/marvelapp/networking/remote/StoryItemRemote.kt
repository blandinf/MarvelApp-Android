package com.blandinf.marvelapp.networking.remote

import com.google.gson.annotations.SerializedName

/** The attributes of the Story Item object */
@Suppress("unused")
data class StoryItemRemote (
    @SerializedName("resourceURI") val resourceURI: String,
    @SerializedName("name") val name: String,
    @SerializedName("type") val type: ItemType
)

enum class ItemType {
    @SerializedName("cover")
    Cover,
    @SerializedName("interiorStory")
    InteriorStory,
    @SerializedName("promo")
    Promo
}
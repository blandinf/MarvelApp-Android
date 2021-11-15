package com.blandinf.marvelapp.remote

import com.google.gson.annotations.SerializedName

/** The attributes of the Story Item object */
@Suppress("unused")
data class StoryItemRemote (
    @SerializedName("ResourceURI") val resourceURI: String,
    @SerializedName("Name") val name: String,
    @SerializedName("Type") val type: ItemType
)

enum class ItemType {
    Cover,
    InteriorStory,
    Promo
}
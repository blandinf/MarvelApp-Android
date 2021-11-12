package com.blandinf.marvelapp.models

data class StoryItem (
    val resourceURI: String,
    val name: String,
    val type: ItemType
)

enum class ItemType {
    Cover,
    InteriorStory,
    Promo
}
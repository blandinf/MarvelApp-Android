package com.blandinf.marvelapp.models

data class Story (
    val available: Long,
    val collectionURI: String,
    val items: List<StoryItem>,
    val returned: Long
)
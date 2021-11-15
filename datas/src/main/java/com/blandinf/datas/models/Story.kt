package com.blandinf.datas.models

data class Story (
    val available: Long,
    val collectionURI: String,
    val items: List<StoryItem>,
    val returned: Long
)
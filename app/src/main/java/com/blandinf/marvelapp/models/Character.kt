package com.blandinf.marvelapp.models

data class Character (
    val available: Long,
    val collectionURI: String,
    val items: List<Serie>,
    val returned: Long
)
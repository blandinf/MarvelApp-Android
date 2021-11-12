package com.blandinf.marvelapp.models

data class Creator (
    val available: Long,
    val collectionURI: String,
    val items: List<CreatorsItem>,
    val returned: Long
)
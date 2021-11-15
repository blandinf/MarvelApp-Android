package com.blandinf.datas.models

data class Character (
    val available: Long,
    val collectionURI: String,
    val items: List<Serie>,
    val returned: Long
)
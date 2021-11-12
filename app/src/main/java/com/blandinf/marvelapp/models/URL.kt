package com.blandinf.marvelapp.models

data class URL (
    val type: URLType,
    val url: String
)

enum class URLType {
    Detail,
    Purchase
}
package com.blandinf.datas.models

data class URL (
    val type: URLType,
    val url: String
)

enum class URLType {
    Detail,
    Purchase
}
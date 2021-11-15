package com.blandinf.datas.models

data class Thumbnail (
    val path: String,
    val extension: Extension
)

enum class Extension {
    Jpg
}
package com.blandinf.datas.models

data class TextObject (
    val type: TextObjectType,
    val language: Language,
    val text: String
)

enum class Language {
    EnUs
}

enum class TextObjectType {
    IssueSolicitText
}
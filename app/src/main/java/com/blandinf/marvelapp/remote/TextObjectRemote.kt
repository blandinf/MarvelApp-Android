package com.blandinf.marvelapp.remote

import com.google.gson.annotations.SerializedName

/** The attributes of the TextObject object */
@Suppress("unused")
data class TextObjectRemote (
    @SerializedName("Type") val type: TextObjectType,
    @SerializedName("Language") val language: Language,
    @SerializedName("Text") val text: String
)

enum class Language {
    EnUs
}

enum class TextObjectType {
    IssueSolicitText
}
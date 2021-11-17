package com.blandinf.marvelapp.networking.remote

import com.google.gson.annotations.SerializedName

/** The attributes of the TextObject object */
@Suppress("unused")
data class TextObjectRemote (
    @SerializedName("type") val type: TextObjectType,
    @SerializedName("language") val language: Language,
    @SerializedName("text") val text: String
)

enum class Language {
    @SerializedName("enUs")
    EnUs
}

enum class TextObjectType {
    @SerializedName("issueSolicitText")
    IssueSolicitText
}
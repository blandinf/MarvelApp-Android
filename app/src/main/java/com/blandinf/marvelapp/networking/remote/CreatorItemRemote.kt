package com.blandinf.marvelapp.networking.remote

import com.google.gson.annotations.SerializedName

/** The attributes of the Creator Item object */
@Suppress("unused")
data class CreatorItemRemote (
    @SerializedName("resourceURI") val resourceURI: String,
    @SerializedName("name") val name: String,
    @SerializedName("role") val role: Role
)

enum class Role {
    @SerializedName("colorist")
    Colorist,
    @SerializedName("editor")
    Editor,
    @SerializedName("inker")
    Inker,
    @SerializedName("letterer")
    Letterer,
    @SerializedName("penciler")
    Penciler,
    @SerializedName("penciller")
    Penciller,
    @SerializedName("pencillerCover")
    PencillerCover,
    @SerializedName("writer")
    Writer
}
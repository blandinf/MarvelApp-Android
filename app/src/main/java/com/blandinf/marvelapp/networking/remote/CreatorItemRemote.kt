package com.blandinf.marvelapp.networking.remote

import com.google.gson.annotations.SerializedName

/** The attributes of the Creator Item object */
@Suppress("unused")
data class CreatorItemRemote (
    @SerializedName("ResourceURI") val resourceURI: String,
    @SerializedName("Name") val name: String,
    @SerializedName("Role") val role: Role
)

enum class Role {
    Colorist,
    Editor,
    Inker,
    Letterer,
    Penciler,
    Penciller,
    PencillerCover,
    Writer
}
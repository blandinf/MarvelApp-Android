package com.blandinf.datas.models

data class CreatorItem (
    val resourceURI: String,
    val name: String,
    val role: Role
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
package com.blandinf.marvelapp.mappers

import com.blandinf.marvelapp.networking.remote.models.ComicRemote
import com.blandinf.marvelapp.ui.models.ComicUiModel

fun toComicUiModel(comicRemote: ComicRemote): ComicUiModel.Comic {
    return ComicUiModel.Comic(
        title = comicRemote.title,
        thumbnail = comicRemote.thumbnail
    )
}
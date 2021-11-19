package com.blandinf.marvelapp.ui.models

import com.blandinf.marvelapp.networking.remote.models.ThumbnailRemote

sealed interface ComicUiModel {
    data class Comic constructor(
        val title: String,
        val thumbnail: ThumbnailRemote
    )
}
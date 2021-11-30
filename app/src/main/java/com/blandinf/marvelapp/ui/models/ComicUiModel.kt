package com.blandinf.marvelapp.ui.models

import androidx.recyclerview.widget.DiffUtil
import com.blandinf.marvelapp.networking.remote.models.ThumbnailRemote

sealed interface ComicUiModel {
    data class Comic(
        val id: Long,
        val title: String,
        val thumbnail: ThumbnailRemote
    ) {
        companion object : DiffUtil.ItemCallback<Comic>() {
            override fun areItemsTheSame(oldItem: Comic, newItem: Comic): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Comic, newItem: Comic): Boolean {
                return oldItem == newItem
            }
        }
    }
}
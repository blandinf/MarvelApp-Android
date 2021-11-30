package com.blandinf.marvelapp.ui.catalog

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import com.blandinf.marvelapp.ui.models.ComicUiModel
import com.blandinf.marvelapp.ui.widget.CardComicViewHolder

class CatalogAdapter(private val onClickOnComic: (ComicUiModel.Comic) -> Unit) :
    PagingDataAdapter<ComicUiModel.Comic, CardComicViewHolder>(
        ComicUiModel.Comic.Companion
    ) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardComicViewHolder {
        return CardComicViewHolder.newInstance(parent) {
            this.width = ViewGroup.LayoutParams.MATCH_PARENT
        }
    }

    override fun onBindViewHolder(holder: CardComicViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it, onClickOnComic) }
    }
}
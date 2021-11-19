package com.blandinf.marvelapp.ui.catalog

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.blandinf.marvelapp.ui.models.ComicUiModel
import com.blandinf.marvelapp.ui.widget.CardComicViewHolder

class CatalogAdapter : RecyclerView.Adapter<CardComicViewHolder>() {

    private var items: List<ComicUiModel.Comic> = emptyList()

    fun setItems(items: List<ComicUiModel.Comic>) {
        this.items = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardComicViewHolder {
        return CardComicViewHolder.newInstance(parent) {
            this.width = ViewGroup.LayoutParams.MATCH_PARENT
        }
    }

    override fun onBindViewHolder(holder: CardComicViewHolder, position: Int) {
        items[position].let { holder.bind(it) }
    }

    override fun getItemCount(): Int = items.count()
}
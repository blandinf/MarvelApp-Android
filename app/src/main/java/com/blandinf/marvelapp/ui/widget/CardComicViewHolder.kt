package com.blandinf.marvelapp.ui.widget

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.updateLayoutParams
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.blandinf.marvelapp.R
import com.blandinf.marvelapp.databinding.ViewHolderCardComicBinding
import com.blandinf.marvelapp.networking.remote.models.ComicRemote

class CardComicViewHolder private constructor(private val binding: ViewHolderCardComicBinding) :
    RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun newInstance(
            parent: ViewGroup,
            block: (ViewGroup.LayoutParams.() -> Unit)? = null
        ): CardComicViewHolder {
            return CardComicViewHolder(
                ViewHolderCardComicBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                ).apply {
                    block?.let(this.root::updateLayoutParams)
                })
        }

        const val IMAGE_SIZE = "portrait_medium"
    }

    fun bind(comic: ComicRemote) {
        binding.cardComicTitle.text = comic.title

        val pathBuilder = StringBuilder().apply {
            append(comic.thumbnail.path)
            append("/")
            append(IMAGE_SIZE)
            append(".")
            append(comic.thumbnail.extension)
        }
        val path = pathBuilder.toString()

        binding.cardComicImage.load(path) {
            crossfade(R.integer.default_anim_duration)
            placeholder(R.drawable.img_placeholder)
        }

        binding.root.setOnClickListener {
            Log.d("((click", "click on $it $comic")
        }
    }
}
package com.blandinf.marvelapp.ui.catalog

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.blandinf.marvelapp.R
import com.blandinf.marvelapp.networking.remote.ComicRemote

class CatalogAdapter(
    private val dataset: List<ComicRemote>,
    private val callback: () -> Unit
) : RecyclerView.Adapter<CatalogAdapter.ViewHolder>() {

    companion object {
        const val IMAGE_SIZE = "portrait_medium"
    }

    inner class ViewHolder(private val root: View) : RecyclerView.ViewHolder(root) {
        fun bind(item: ComicRemote) {
            val title = root.findViewById<TextView>(R.id.comic_title)
            val image = root.findViewById<ImageView>(R.id.comic_image)

            title.text = item.title

            val pathBuilder = StringBuilder().apply {
                append(item.thumbnail.path)
                append("/")
                append(IMAGE_SIZE)
                append(".")
                append(item.thumbnail.extension)
            }
            val path = pathBuilder.toString()

            image.load(path) {
                crossfade(R.integer.default_anim_duration)
                placeholder(R.drawable.img_placeholder)
            }

            root.setOnClickListener {
                callback()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.view_holder_card_comic, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(dataset[position])

    override fun getItemCount(): Int = dataset.count()
}
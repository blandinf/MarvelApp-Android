package com.blandinf.marvelapp.extensions

import android.net.Uri
import android.widget.ImageView
import coil.ImageLoader
import coil.request.Disposable
import coil.request.ImageRequest
import com.blandinf.marvelapp.R
import okhttp3.HttpUrl

fun ImageView.load(
    imageLoader: ImageLoader,
    url: HttpUrl?,
    block: ImageRequest.Builder.() -> Unit = {},
): Disposable {
    return imageLoader.enqueue(
        ImageRequest.Builder(context)
            .data(url)
            .target(this)
            .crossfade(resources.getInteger(R.integer.default_anim_duration))
            .placeholder(R.drawable.img_placeholder)
            .fallback(R.drawable.img_placeholder)
            .error(R.drawable.img_placeholder)
            .apply(block)
            .build()
    )
}

fun ImageView.load(
    imageLoader: ImageLoader,
    path: String?,
    block: ImageRequest.Builder.() -> Unit = {},
): Disposable {
    return imageLoader.enqueue(
        ImageRequest.Builder(context)
            .data(path)
            .target(this)
            .crossfade(resources.getInteger(R.integer.default_anim_duration))
            .placeholder(R.drawable.img_placeholder)
            .fallback(R.drawable.img_placeholder)
            .error(R.drawable.img_placeholder)
            .apply(block)
            .build()
    )
}

fun ImageView.load(
    imageLoader: ImageLoader,
    uri: Uri?,
    block: ImageRequest.Builder.() -> Unit = {},
): Disposable {
    return imageLoader.enqueue(
        ImageRequest.Builder(context)
            .data(uri)
            .target(this)
            .crossfade(resources.getInteger(R.integer.default_anim_duration))
            .placeholder(R.drawable.img_placeholder)
            .fallback(R.drawable.img_placeholder)
            .error(R.drawable.img_placeholder)
            .apply(block)
            .build()
    )
}
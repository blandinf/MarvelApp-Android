package com.blandinf.marvelapp.networking.remote.models

import com.google.gson.annotations.SerializedName

/** The attributes of the Comic object */
@Suppress("unused")
data class ComicRemote(
    @SerializedName("id") val id: Long,
    @SerializedName("digitalId") val digitalId: Long,
    @SerializedName("title") val title: String,
    @SerializedName("issueNumber") val issueNumber: Long,
    @SerializedName("variantDescription") val variantDescription: String,
    @SerializedName("description") val description: String? = null,
    @SerializedName("modified") val modified: String,
    @SerializedName("isbn") val isbn: String,
    @SerializedName("upc") val upc: String,
    @SerializedName("diamondCode") val diamondCode: DiamondCode,
    @SerializedName("ean") val ean: String,
    @SerializedName("issn") val issn: String,
    @SerializedName("format") val format: Format,
    @SerializedName("pageCount") val pageCount: Long,
    @SerializedName("textObjects") val textObjects: List<TextObjectRemote>,
    @SerializedName("resourceURI") val resourceURI: String,
    @SerializedName("urls") val urls: List<URLRemote>,
    @SerializedName("series") val series: SerieRemote,
    @SerializedName("variants") val variants: List<SerieRemote>,
    @SerializedName("collections") val collections: List<Any?>,
    @SerializedName("collectedIssues") val collectedIssues: List<SerieRemote>,
    @SerializedName("dates") val dates: List<DateRemote>,
    @SerializedName("prices") val prices: List<PriceRemote>,
    @SerializedName("thumbnail") val thumbnail: ThumbnailRemote,
    @SerializedName("images") val images: List<ThumbnailRemote>,
    @SerializedName("creators") val creators: CreatorRemote,
    @SerializedName("characters") val characters: CharacterRemote,
    @SerializedName("stories") val stories: StoryRemote,
    @SerializedName("events") val events: CharacterRemote
)

enum class DiamondCode {
    @SerializedName("")
    Empty,

    @SerializedName("jul190068")
    Jul190068
}

enum class Format {
    @SerializedName("comic")
    Comic,

    @SerializedName("digest")
    Digest,

    @SerializedName("")
    Empty,

    @SerializedName("tradePaperback")
    TradePaperback
}



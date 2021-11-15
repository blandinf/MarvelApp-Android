package com.blandinf.marvelapp.networking.remote

import com.google.gson.annotations.SerializedName

/** The attributes of the Comic object */
@Suppress("unused")
data class ComicRemote (
    @SerializedName("Id")  val id: Long,
    @SerializedName("DigitalID")  val digitalID: Long,
    @SerializedName("Title")  val title: String,
    @SerializedName("IssueNumber")  val issueNumber: Long,
    @SerializedName("VariantDescription")  val variantDescription: String,
    @SerializedName("Description")  val description: String? = null,
    @SerializedName("Modified")  val modified: String,
    @SerializedName("Isbn")  val isbn: String,
    @SerializedName("Upc")  val upc: String,
    @SerializedName("DiamondCode")  val diamondCode: DiamondCode,
    @SerializedName("Ean")  val ean: String,
    @SerializedName("Issn")  val issn: String,
    @SerializedName("Format")  val format: Format,
    @SerializedName("PageCount")  val pageCount: Long,
    @SerializedName("TextObjects")  val textObjects: List<TextObjectRemote>,
    @SerializedName("ResourceURI")  val resourceURI: String,
    @SerializedName("Urls")  val urls: List<URLRemote>,
    @SerializedName("Series")  val series: SerieRemote,
    @SerializedName("Variants")  val variants: List<SerieRemote>,
    @SerializedName("Collections")  val collections: List<Any?>,
    @SerializedName("CollectedIssues")  val collectedIssues: List<SerieRemote>,
    @SerializedName("Dates")  val dates: List<DateRemote>,
    @SerializedName("Prices")  val prices: List<PriceRemote>,
    @SerializedName("Thumbnail")  val thumbnail: ThumbnailRemote,
    @SerializedName("Images")  val images: List<ThumbnailRemote>,
    @SerializedName("Creators")  val creators: CreatorRemote,
    @SerializedName("Character")  val character: CharacterRemote,
    @SerializedName("Stories")  val stories: StoryRemote,
    @SerializedName("Events")  val events: CharacterRemote
)

enum class DiamondCode {
    Empty,
    Jul190068
}

enum class Format {
    Comic,
    Digest,
    Empty,
    TradePaperback
}



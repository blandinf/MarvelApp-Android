package com.blandinf.marvelapp.models

data class Comic (
    val id: Long,
    val digitalID: Long,
    val title: String,
    val issueNumber: Long,
    val variantDescription: String,
    val description: String? = null,
    val modified: String,
    val isbn: String,
    val upc: String,
    val diamondCode: DiamondCode,
    val ean: String,
    val issn: String,
    val format: Format,
    val pageCount: Long,
    val textObjects: List<TextObject>,
    val resourceURI: String,
    val urls: List<URL>,
    val series: Serie,
    val variants: List<Serie>,
    val collections: List<Any?>,
    val collectedIssues: List<Serie>,
    val dates: List<Date>,
    val prices: List<Price>,
    val thumbnail: Thumbnail,
    val images: List<Thumbnail>,
    val creators: Creator,
    val character: Character,
    val stories: Story,
    val events: Character
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



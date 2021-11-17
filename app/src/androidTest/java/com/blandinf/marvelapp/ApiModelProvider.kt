package com.blandinf.marvelapp

import com.blandinf.marvelapp.networking.remote.*

object ApiModelProvider {
    fun provideComic() = ComicRemote(
        id = 82967,
        digitalId = 0,
        title = "Marvel Previews (2017)",
        issueNumber = 0,
        variantDescription = "",
        description = null,
        modified = "2019-11-07T08:46:15-0500",
        isbn = "",
        upc = "75960608839302811",
        diamondCode = DiamondCode.Empty,
        ean = "",
        issn = "",
        format = Format.Empty,
        pageCount = 112,
        textObjects = emptyList(),
        resourceURI = "http://gateway.marvel.com/v1/public/comics/82967",
        urls = listOf(
            URLRemote(
                type = URLType.Detail,
                url = "http://marvel.com/comics/issue/82967/marvel_previews_2017?utm_campaign=apiRef&utm_source=06e6c775eb39c531415805a82a692817"
            )
        ),
        series = SerieRemote(
            resourceURI = "http://gateway.marvel.com/v1/public/series/23665",
            name = "Marvel Previews (2017 - Present)"
        ),
        variants = listOf(
            SerieRemote(
                resourceURI = "http://gateway.marvel.com/v1/public/comics/82965",
                name = "Marvel Previews (2017)"
            )
        ),
        collections = emptyList(),
        collectedIssues = emptyList(),
        dates = listOf(
            DateRemote(
                type = DateType.OnsaleDate,
                date = "2099-10-30T00:00:00-0500"
            )
        ),
        prices = listOf(
            PriceRemote(
                type = PriceType.PrintPrice,
                price = 0.0
            )
        ),
        thumbnail = ThumbnailRemote(
            path = "http://i.annihil.us/u/prod/marvel/i/mg/b/40/image_not_available",
            extension = Extension.Jpg
        ),
        images = emptyList(),
        creators = CreatorRemote(
            available = 1,
            collectionURI = "http://gateway.marvel.com/v1/public/comics/82967/creators",
            items = listOf(
                CreatorItemRemote(
                    resourceURI = "http://gateway.marvel.com/v1/public/creators/10021",
                    name = "Jim Nausedas",
                    role = Role.Editor
                )
            ),
            returned = 1
        ),
        characters = CharacterRemote(
            available = 0,
            collectionURI = "http://gateway.marvel.com/v1/public/comics/82967/characters",
            items = emptyList(),
            returned = 0
        ),
        stories = StoryRemote(
            available = 0,
            collectionURI = "http://gateway.marvel.com/v1/public/comics/82967/stories",
            items = emptyList(),
            returned = 0
        ),
        events = CharacterRemote(
            available = 0,
            collectionURI = "http://gateway.marvel.com/v1/public/comics/82967/events",
            items = emptyList(),
            returned = 0
        )
    )
}
package com.blandinf.marvelapp.networking.api

import androidx.test.platform.app.InstrumentationRegistry
import com.blandinf.marvelapp.ApiModelProvider
import com.blandinf.marvelapp.networking.NetworkingModules
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.net.ssl.HttpsURLConnection
import com.blandinf.marvelapp.test.R as T

class ComicApiTest {

    private lateinit var api: ComicApi
    private lateinit var mockServer: MockWebServer

    @Before
    fun setUp() {
        mockServer = MockWebServer().also {
            it.start()
        }
        api = Retrofit.Builder().baseUrl(mockServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create()).build().create()
    }

    @After
    fun tearDown() {}

    @Test
    fun getComics() = runBlocking {
        val fileContent = InstrumentationRegistry
            .getInstrumentation()
            .context
            .resources
            .openRawResource(T.raw.comics)
            .bufferedReader()
            .readText()

        mockServer.enqueue(MockResponse().apply {
            this.setHeader("Content-Type", "application/json; charset=UTF-8")
            this.setResponseCode(HttpsURLConnection.HTTP_OK)
            this.setBody(fileContent)
        })
        val response = api.getComics()

        assertEquals(200, response.code())
        assertEquals(1, response.body()?.data?.results?.count())

        val expected = ApiModelProvider.provideComic()
        assertEquals(expected, response.body()?.data?.results?.firstOrNull())

        assertEquals(expected.id, response.body()?.data?.results?.firstOrNull()?.id)
        assertEquals(expected.digitalId, response.body()?.data?.results?.firstOrNull()?.digitalId)
        assertEquals(expected.title, response.body()?.data?.results?.firstOrNull()?.title)
        assertEquals(expected.issueNumber, response.body()?.data?.results?.firstOrNull()?.issueNumber)
        assertEquals(expected.variantDescription, response.body()?.data?.results?.firstOrNull()?.variantDescription)
        assertEquals(expected.description, response.body()?.data?.results?.firstOrNull()?.description)
        assertEquals(expected.modified, response.body()?.data?.results?.firstOrNull()?.modified)
        assertEquals(expected.isbn, response.body()?.data?.results?.firstOrNull()?.isbn)
        assertEquals(expected.upc, response.body()?.data?.results?.firstOrNull()?.upc)
        assertEquals(expected.diamondCode, response.body()?.data?.results?.firstOrNull()?.diamondCode)
        assertEquals(expected.ean, response.body()?.data?.results?.firstOrNull()?.ean)
        assertEquals(expected.issn, response.body()?.data?.results?.firstOrNull()?.issn)
        assertEquals(expected.format, response.body()?.data?.results?.firstOrNull()?.format)
        assertEquals(expected.pageCount, response.body()?.data?.results?.firstOrNull()?.pageCount)
        assertEquals(expected.textObjects, response.body()?.data?.results?.firstOrNull()?.textObjects)
        assertEquals(expected.resourceURI, response.body()?.data?.results?.firstOrNull()?.resourceURI)
        assertEquals(expected.urls, response.body()?.data?.results?.firstOrNull()?.urls)
        assertEquals(expected.series, response.body()?.data?.results?.firstOrNull()?.series)
        assertEquals(expected.variants, response.body()?.data?.results?.firstOrNull()?.variants)
        assertEquals(expected.collections, response.body()?.data?.results?.firstOrNull()?.collections)
        assertEquals(expected.collectedIssues, response.body()?.data?.results?.firstOrNull()?.collectedIssues)
        assertEquals(expected.dates, response.body()?.data?.results?.firstOrNull()?.dates)
        assertEquals(expected.prices, response.body()?.data?.results?.firstOrNull()?.prices)
        assertEquals(expected.thumbnail, response.body()?.data?.results?.firstOrNull()?.thumbnail)
        assertEquals(expected.images, response.body()?.data?.results?.firstOrNull()?.images)
        assertEquals(expected.creators, response.body()?.data?.results?.firstOrNull()?.creators)
        assertEquals(expected.characters, response.body()?.data?.results?.firstOrNull()?.characters)
        assertEquals(expected.stories, response.body()?.data?.results?.firstOrNull()?.stories)
        assertEquals(expected.events, response.body()?.data?.results?.firstOrNull()?.events)
    }
}
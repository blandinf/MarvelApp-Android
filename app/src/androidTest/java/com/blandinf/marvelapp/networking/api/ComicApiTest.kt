package com.blandinf.marvelapp.networking.api

import com.blandinf.marvelapp.networking.NetworkingModules
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test

class ComicApiTest {
    private lateinit var api: ComicApi

    @Before
    fun setUp() {
        api = NetworkingModules.retrofit.create(ComicApi::class.java)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun getComics() = runBlocking {
        val response = api.getComics()
    }
}
package com.blandinf.marvelapp.networking.api

import com.blandinf.marvelapp.networking.remote.APIResponse
import com.blandinf.marvelapp.networking.remote.models.ComicRemote
import retrofit2.http.GET

interface ComicApi {
    companion object {
        const val URL_GET_COMICS = "comics"
    }

    @GET(URL_GET_COMICS)
    suspend fun getComics(): APIResponse<ComicRemote>
}
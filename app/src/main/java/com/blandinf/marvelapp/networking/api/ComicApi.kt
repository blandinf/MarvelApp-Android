package com.blandinf.marvelapp.networking.api

import com.blandinf.marvelapp.networking.remote.APIResponse
import com.blandinf.marvelapp.networking.remote.models.ComicRemote
import retrofit2.http.GET
import retrofit2.http.Query

interface ComicApi {
    companion object {
        const val URL_GET_COMICS = "comics"
        const val QUERY_PARAMETER_KEY_OFFSET = "offset"
        const val QUERY_PARAMETER_KEY_TITLE_STARTS_WITH = "titleStartsWith"
    }

    @GET(URL_GET_COMICS)
    suspend fun getComics(
        @Query(QUERY_PARAMETER_KEY_OFFSET) offset: Long = 0,
        @Query(QUERY_PARAMETER_KEY_TITLE_STARTS_WITH) titleStartsWith: String? = null
    ): APIResponse<ComicRemote>
}
package com.blandinf.marvelapp.networking.api

import com.blandinf.marvelapp.networking.remote.APIResponse
import com.blandinf.marvelapp.networking.remote.ComicRemote
import retrofit2.Call
import retrofit2.http.GET

interface ComicApi {
    @GET("comics")
    fun getComics(): Call<APIResponse<ComicRemote>>
}
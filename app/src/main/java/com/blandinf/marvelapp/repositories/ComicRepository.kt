package com.blandinf.marvelapp.repositories

import com.blandinf.marvelapp.networking.NetworkingModules
import com.blandinf.marvelapp.networking.api.ComicApi
import com.blandinf.marvelapp.networking.remote.ComicRemote
import java.util.Collections.emptyList

class ComicRepository {
    private val service: ComicApi = NetworkingModules.retrofit.create(ComicApi::class.java)

    fun getComics(): List<ComicRemote> {
        val response = service.getComics().execute()

        return response.body()?.data?.results ?: emptyList()
    }
}
package com.blandinf.marvelapp.repositories

import android.util.Log
import com.blandinf.marvelapp.networking.api.ComicApi
import com.blandinf.marvelapp.networking.remote.models.ComicRemote
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

private class CatalogRepositoryImpl(private val api: ComicApi) : CatalogRepository {

    companion object {
        private const val TAG: String = "CatalogRepositoryImpl"
    }

    override fun getComics(): Flow<List<ComicRemote>> = flow {
        try {
            val response = api.getComics()
            val comics = response.body()?.data?.results
                ?: throw IllegalStateException("response code is: ${response.code()}")
            emit(comics)
        } catch (e: Exception) {
            Log.e(TAG, "getComics: ", e)
        }
    }.flowOn(Dispatchers.IO)
}

interface CatalogRepository {

    companion object {
        private var instance: CatalogRepository? = null

        fun getInstance(api: ComicApi): CatalogRepository {
            return instance ?: synchronized(this) {
                instance ?: CatalogRepositoryImpl(api).also {
                    instance = it
                }
            }
        }
    }

    fun getComics(): Flow<List<ComicRemote>>
}
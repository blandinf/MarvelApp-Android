package com.blandinf.marvelapp.repositories

import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.blandinf.marvelapp.datasource.ComicDataSource
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

    override fun getComics(filtered: String?): Flow<PagingData<ComicRemote>> {
        return Pager(PagingConfig(
            pageSize = 20,
            enablePlaceholders = false
        )) {
            ComicDataSource(api, filtered)
        }.flow.flowOn(Dispatchers.IO)
    }
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

    fun getComics(filtered: String? = null): Flow<PagingData<ComicRemote>>
}
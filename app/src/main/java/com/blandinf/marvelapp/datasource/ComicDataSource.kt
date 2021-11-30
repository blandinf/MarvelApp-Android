package com.blandinf.marvelapp.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.blandinf.marvelapp.networking.api.ComicApi
import com.blandinf.marvelapp.networking.remote.models.ComicRemote
import java.lang.IllegalStateException

class ComicDataSource(
    private val api: ComicApi,
) : PagingSource<Long, ComicRemote>() {
    override fun getRefreshKey(state: PagingState<Long, ComicRemote>): Long? {
        return state.pages.last().nextKey ?: 0
    }

    override suspend fun load(params: LoadParams<Long>): LoadResult<Long, ComicRemote> {
        return try {
            val nextPageNumber = params.key ?: 0
            val response = api.getComics(offset = nextPageNumber)
            val data = response.body()?.data ?: throw Exception("Error get Comics Paginated")

            LoadResult.Page(
                data = data.results,
                prevKey = null, // Only paging forward.
                nextKey = data.offset.plus(20)
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        } catch (e: IllegalStateException) {
            LoadResult.Error(e)
        }
    }
}
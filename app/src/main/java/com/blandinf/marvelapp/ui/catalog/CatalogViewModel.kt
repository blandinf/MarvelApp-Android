package com.blandinf.marvelapp.ui.catalog

import androidx.lifecycle.*
import com.blandinf.marvelapp.networking.NetworkingModules
import com.blandinf.marvelapp.networking.remote.models.ComicRemote
import com.blandinf.marvelapp.repositories.CatalogRepository

class CatalogViewModel(
    private val catalogRepository: CatalogRepository
) : ViewModel() {

    companion object : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return CatalogViewModel(
                catalogRepository = CatalogRepository.getInstance(
                    NetworkingModules.create()
                )
            ) as T
        }

        private const val TAG: String = "CatalogViewModel"
    }

    fun getComics(): LiveData<List<ComicRemote>> {
        return catalogRepository
            .getComics()
            .asLiveData(viewModelScope.coroutineContext)
    }
}
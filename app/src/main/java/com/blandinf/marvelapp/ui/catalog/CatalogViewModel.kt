package com.blandinf.marvelapp.ui.catalog

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.blandinf.marvelapp.mappers.toComicUiModel
import com.blandinf.marvelapp.networking.NetworkingModules
import com.blandinf.marvelapp.repositories.CatalogRepository
import com.blandinf.marvelapp.ui.models.ComicUiModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

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

    private val _comicsUIState: MutableStateFlow<ComicsUiState> =
        MutableStateFlow(ComicsUiState.Success(PagingData.empty()))

    val comicsUIState: StateFlow<ComicsUiState> = _comicsUIState

    fun getComics() {
        viewModelScope.launch {
            catalogRepository.getComics()
                .cachedIn(viewModelScope)
                .catch { exception ->
                    _comicsUIState.value = ComicsUiState.Error(exception)
                }
                .collect { comics ->
                    val uiComics = comics.map { comic -> toComicUiModel(comic) }
                    _comicsUIState.value = ComicsUiState.Success(uiComics)
                }
        }
    }
}

// Represents different states for the Comics screen
sealed class ComicsUiState {
    data class Success(val comics: PagingData<ComicUiModel.Comic>) : ComicsUiState()
    data class Error(val exception: Throwable) : ComicsUiState()
}
package com.blandinf.marvelapp.ui.catalog

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.blandinf.marvelapp.databinding.FragmentCatalogBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class CatalogFragment : Fragment() {

    companion object {
        private const val TAG: String = "CatalogFragment"
    }

    private lateinit var binding: FragmentCatalogBinding
    private val viewModel: CatalogViewModel by viewModels { CatalogViewModel.Companion }
    private lateinit var adapter: CatalogAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCatalogBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.catalogRecyclerView.apply {
            adapter = CatalogAdapter().also {
                this@CatalogFragment.adapter = it
            }
        }
        lifecycleScope.launch {
            viewModel.getComics()
            viewModel.comicsUIState.collect { comicsUIState ->
                when (comicsUIState) {
                    is ComicsUiState.Error -> Toast.makeText(context, comicsUIState.exception.message, Toast.LENGTH_SHORT).show()
                    is ComicsUiState.Success -> {
                        adapter.submitData(viewLifecycleOwner.lifecycle, comicsUIState.comics)
                    }
                }
            }
        }
    }
}
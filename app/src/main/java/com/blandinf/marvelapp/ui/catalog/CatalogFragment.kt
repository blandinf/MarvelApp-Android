package com.blandinf.marvelapp.ui.catalog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.blandinf.marvelapp.databinding.FragmentCatalogBinding
import com.blandinf.marvelapp.networking.remote.models.ComicRemote

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
        viewModel.getComics().observe(viewLifecycleOwner, {
            adapter.setItems(it)
//            populateRecyclerView()
        })

//        binding.swipeRefreshLayout.setOnRefreshListener {
//            viewModel.getComics()
//        }
    }

    private fun populateRecyclerView(comics: List<ComicRemote>) {
        if (comics.isNotEmpty()) adapter.setItems(ArrayList(comics))
    }

    private fun displayLoading(isLoading: Boolean) {
        //binding.swipeRefreshLayout.isRefreshing = isLoading
    }

    private fun displayError(message: String?) {
        if (message.isNullOrEmpty()) {
            Toast.makeText(context, message, Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(context, "Unknown error", Toast.LENGTH_LONG).show()
        }
    }
}
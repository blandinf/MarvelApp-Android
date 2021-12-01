package com.blandinf.marvelapp.ui.catalog

import android.os.Bundle
import android.view.*
import android.view.inputmethod.EditorInfo
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.blandinf.marvelapp.R
import com.blandinf.marvelapp.databinding.FragmentCatalogBinding
import com.blandinf.marvelapp.extensions.change
import com.blandinf.marvelapp.ui.comic.ComicFragment
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import android.R.menu
import android.util.Log

import android.view.MenuInflater
import android.widget.ImageView
import com.blandinf.marvelapp.ui.main.MainActivity


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

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.search_menu, menu)
        val searchView = SearchView((context as MainActivity).supportActionBar?.themedContext ?: context)
        menu.findItem(R.id.action_search).apply {
            setShowAsAction(MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW or MenuItem.SHOW_AS_ACTION_IF_ROOM)
            actionView = searchView
        }

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                getFilteredComics(query)
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                // getFilteredComics(newText)
                return false
            }
        })

        val closeButtonId: Int = searchView.context.resources.getIdentifier("android:id/search_close_btn", null, null)
        val closeButton = searchView.findViewById(closeButtonId) as ImageView

        closeButton.setOnClickListener {
            Log.d(TAG, "onClose: ok2")
            searchView.onActionViewCollapsed()
            getFilteredComics()
            true
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setHasOptionsMenu(true)

        binding.catalogRecyclerView.apply {
            adapter = CatalogAdapter { comic ->
                val fragment = ComicFragment()
                val args = Bundle()
                args.putString("title", comic.title)
                fragment.arguments = args
                (activity)?.change(fragment)
            }
            .also {
                this@CatalogFragment.adapter = it
            }
        }

        this.getFilteredComics()
    }

    private fun getFilteredComics(filtered: String? = null) {
        Log.d(TAG, "getFilteredComics: ")
        lifecycleScope.launch {
            viewModel.getComics(filtered)
            viewModel.comicsUIState.collect { comicsUIState ->
                when (comicsUIState) {
                    is ComicsUiState.Error -> Toast.makeText(
                        context,
                        comicsUIState.exception.message,
                        Toast.LENGTH_SHORT
                    ).show()
                    is ComicsUiState.Success -> {
                        adapter.submitData(viewLifecycleOwner.lifecycle, comicsUIState.comics)
                    }
                }
            }
        }
    }
}
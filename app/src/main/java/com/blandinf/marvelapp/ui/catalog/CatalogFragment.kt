package com.blandinf.marvelapp.ui.catalog

import android.content.Intent
import android.net.Uri
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.blandinf.marvelapp.R
import com.blandinf.marvelapp.databinding.FragmentCatalogBinding
import com.blandinf.marvelapp.networking.NetworkingModules
import com.blandinf.marvelapp.networking.api.ComicApi
import com.blandinf.marvelapp.networking.remote.APIResponse
import com.blandinf.marvelapp.networking.remote.ComicRemote
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.create

class CatalogFragment : Fragment() {

    companion object {
        private const val TAG: String = "CatalogFragment"
    }

    private lateinit var binding: FragmentCatalogBinding
    private lateinit var viewModel: CatalogViewModel
    private lateinit var recyclerView: RecyclerView
    private val api: ComicApi = NetworkingModules.retrofit.create()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentCatalogBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[CatalogViewModel::class.java]

        recyclerView = view.findViewById(R.id.catalog_list)
        lifecycleScope.launch {
            getData()
        }
    }

    private suspend fun getData() {
        withContext(Dispatchers.IO) {
            bindData(api.getComics())
        }
    }

    private suspend fun bindData(result: APIResponse<ComicRemote>) {
        withContext(Dispatchers.Main) {
            val comics: List<ComicRemote> = result.body()?.data?.results ?: return@withContext

            val adapterRecycler = CatalogAdapter(comics) {
                Log.d("((click", "click")
            }
            recyclerView.layoutManager = GridLayoutManager(context, 2)
            recyclerView.adapter = adapterRecycler
        }
    }
}
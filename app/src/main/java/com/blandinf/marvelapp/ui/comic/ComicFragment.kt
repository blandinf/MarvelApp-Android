package com.blandinf.marvelapp.ui.comic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.blandinf.marvelapp.databinding.FragmentComicBinding

class ComicFragment : Fragment() {

    companion object {
        fun newInstance() = ComicFragment()
    }

    private lateinit var binding: FragmentComicBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentComicBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.comicTitle.text = arguments?.getString("title")
    }
}
package com.blandinf.marvelapp.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.blandinf.marvelapp.R
import com.blandinf.marvelapp.extensions.change
import com.blandinf.marvelapp.ui.catalog.CatalogFragment


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        change(CatalogFragment())
    }
}
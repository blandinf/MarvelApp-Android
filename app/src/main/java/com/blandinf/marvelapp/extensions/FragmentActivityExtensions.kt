package com.blandinf.marvelapp.extensions

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.blandinf.marvelapp.R

fun FragmentActivity.change(fragment: Fragment) {
    supportFragmentManager.beginTransaction().apply {
        replace(R.id.container, fragment)
        addToBackStack(null)
        commit()
    }
}
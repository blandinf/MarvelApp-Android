package com.blandinf.marvelapp.networking.remote

data class APIContainer<T>(
    val offset: Long,
    val limit: Long,
    val total: Long,
    val count: Long,
    val results: List<T>
)
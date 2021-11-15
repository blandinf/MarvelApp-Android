package com.blandinf.marvelapp.remote

data class APIResponse<T> (
    val code: Long,
    val status: String,
    val copyright: String,
    val attributionText: String,
    val attributionHTML: String,
    val etag: String,
    val data: PaginatedResponse<T>
)
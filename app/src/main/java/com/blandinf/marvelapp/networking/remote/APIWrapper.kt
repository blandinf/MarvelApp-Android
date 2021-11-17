package com.blandinf.marvelapp.networking.remote

import retrofit2.Response

typealias APIResponse<T> = Response<APIWrapper<T>>

data class APIWrapper<T> (
    val code: Long,
    val status: String,
    val copyright: String,
    val attributionText: String,
    val attributionHTML: String,
    val etag: String,
    val data: APIContainer<T>
)
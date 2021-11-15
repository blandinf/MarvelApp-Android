package com.blandinf.datas.models

data class PaginatedResponse<T> (
    val offset: Long,
    val limit: Long,
    val total: Long,
    val count: Long,
    val results: List<T>
)
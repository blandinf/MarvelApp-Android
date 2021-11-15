package com.blandinf.marvelapp.remote

import com.google.gson.annotations.SerializedName

/** The attributes of the Comic object */
@Suppress("unused")
data class PaginatedResponse<T> (
    @SerializedName("Offset") val offset: Long,
    @SerializedName("Limit") val limit: Long,
    @SerializedName("Total") val total: Long,
    @SerializedName("Count") val count: Long,
    @SerializedName("Results") val results: List<T>
)
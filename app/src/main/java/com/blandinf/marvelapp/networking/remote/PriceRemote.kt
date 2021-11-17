package com.blandinf.marvelapp.networking.remote

import com.google.gson.annotations.SerializedName

/** The attributes of the Price object */
@Suppress("unused")
data class PriceRemote (
    @SerializedName("type") val type: PriceType,
    @SerializedName("price") val price: Double
)

enum class PriceType {
    @SerializedName("printPrice")
    PrintPrice
}
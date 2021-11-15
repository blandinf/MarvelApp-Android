package com.blandinf.marvelapp.networking.remote

import com.google.gson.annotations.SerializedName

/** The attributes of the Price object */
@Suppress("unused")
data class PriceRemote (
    @SerializedName("Type") val type: PriceType,
    @SerializedName("Price") val price: Double
)

enum class PriceType {
    PrintPrice
}
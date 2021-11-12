package com.blandinf.marvelapp.models

data class Price (
    val type: PriceType,
    val price: Double
)

enum class PriceType {
    PrintPrice
}
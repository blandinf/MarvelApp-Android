package com.blandinf.datas.models

data class Price (
    val type: PriceType,
    val price: Double
)

enum class PriceType {
    PrintPrice
}
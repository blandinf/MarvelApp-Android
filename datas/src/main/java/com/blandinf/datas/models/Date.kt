package com.blandinf.datas.models

data class Date (
    val type: DateType,
    val date: String
)

enum class DateType {
    FocDate,
    OnsaleDate
}
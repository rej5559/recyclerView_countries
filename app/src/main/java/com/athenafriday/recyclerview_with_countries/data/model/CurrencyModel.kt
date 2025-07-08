package com.athenafriday.recyclerview_with_countries.data.model



import com.google.gson.annotations.SerializedName

data class CurrencyModel(
    @SerializedName("code")
    val code: String? = "",
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("symbol")
    val symbol: String? = ""
)
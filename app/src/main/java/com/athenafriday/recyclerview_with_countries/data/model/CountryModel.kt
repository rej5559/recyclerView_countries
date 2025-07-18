package com.athenafriday.recyclerview_with_countries.data.model


import com.google.gson.annotations.SerializedName

data class CountryModel(
    @SerializedName("capital")
    val capital: String? = "",
    @SerializedName("code")
    val code: String? = "",
    @SerializedName("currency")
    val currency: CurrencyModel? = CurrencyModel(),
    @SerializedName("demonym")
    val demonym: String? = "",
    @SerializedName("flag")
    val flag: String? = "",
    @SerializedName("language")
    val language: LanguageModel? = LanguageModel(),
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("region")
    val region: String? = ""
)
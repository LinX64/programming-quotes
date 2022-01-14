package com.client.myapplication.data.models

import androidx.annotation.Keep

import com.google.gson.annotations.SerializedName


class Quotes : ArrayList<QuotesItem>()

@Keep
data class QuotesItem(
    @SerializedName("author")
    val author: String,
    @SerializedName("en")
    val en: String,
    @SerializedName("id")
    val id: String
)
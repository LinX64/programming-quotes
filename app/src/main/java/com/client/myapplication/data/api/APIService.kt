package com.client.myapplication.data.api

import com.client.myapplication.data.models.Quotes
import retrofit2.http.GET

interface APIService {

    @GET("Quotes")
    suspend fun getQuotes(): Quotes

}
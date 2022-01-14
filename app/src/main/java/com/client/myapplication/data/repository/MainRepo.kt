package com.client.myapplication.data.repository

import com.client.myapplication.data.api.APIService
import javax.inject.Inject

class MainRepo @Inject constructor(private val apiService: APIService) {

    suspend fun getList() = apiService.getQuotes()

}
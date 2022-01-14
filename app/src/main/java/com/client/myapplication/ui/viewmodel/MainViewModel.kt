package com.client.myapplication.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.client.myapplication.data.repository.MainRepo
import com.client.myapplication.utils.Resource
import com.client.myapplication.utils.Status
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val mainRepo: MainRepo) : ViewModel() {

    fun getList() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))

        try {

            emit(Resource.success(data = mainRepo.getList()))

        } catch (e: Exception) {
            emit(Resource.error(data = null, message = e.message ?: "Error Occurred!"))
        }

    }
}
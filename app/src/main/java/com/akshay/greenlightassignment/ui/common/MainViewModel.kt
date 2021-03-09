package com.akshay.greenlightassignment.ui.common

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akshay.greenlightassignment.data.model.EmpDataResponse
import com.akshay.greenlightassignment.data.repository.UserRepository
import com.akshay.greenlightassignment.utils.Resource
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(private val userRepository: UserRepository) :
    ViewModel() {
    val userList: MutableLiveData<Resource<EmpDataResponse>> = MutableLiveData()
    val selectedType: MutableLiveData<Any> = MutableLiveData()


    init {
        viewModelScope.launch {
            getUserList()
        }
    }

    //getList
    suspend fun getUserList() {
        try {
            var response = userRepository.getUserList()
            if (response.ResponseData != null) {
                userList.postValue(Resource.success(response.ResponseData))
                Log.i("onlineAppointmentList", response.toString())
            }
        } catch (e: Exception) {
            userList.postValue(Resource.error())
            Log.d("onlineAppointmentList", e.toString())
        }

    }


}

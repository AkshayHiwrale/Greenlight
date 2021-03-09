package com.akshay.greenlightassignment.data.repository

import com.akshay.greenlightassignment.data.ApiService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(val apiService: ApiService) {

    suspend fun getUserList() = apiService.getList()
}
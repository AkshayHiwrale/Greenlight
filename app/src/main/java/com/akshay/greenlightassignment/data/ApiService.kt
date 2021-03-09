package com.akshay.greenlightassignment.data

import com.akshay.greenlightassignment.data.model.CustomResponse
import com.akshay.greenlightassignment.data.model.EmpDataResponse
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("assignment")
      suspend fun getList(): CustomResponse<EmpDataResponse>
}
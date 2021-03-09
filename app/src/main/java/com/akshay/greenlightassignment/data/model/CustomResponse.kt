package com.akshay.greenlightassignment.data.model

import com.google.gson.annotations.SerializedName
data class CustomResponse<out T>(
        @SerializedName("ResponseStatus")
        val ResponseStatus: Int,
        @SerializedName("ResponseData")
        val ResponseData: T?,
        @SerializedName("Success")
        val Success: Boolean
)
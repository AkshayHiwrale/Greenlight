package com.akshay.greenlightassignment.data.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Employee(
    @SerializedName("area")
    var area: String?,
    @SerializedName("name")
    var name: String?,
    @SerializedName("territory")
    var territory: String?
):Parcelable
package com.akshay.greenlightassignment.data.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class EmpDataResponse(
    @SerializedName("area")
    var area: List<Area>?,
    @SerializedName("country")
    var country: List<Country>?,
    @SerializedName("employee")
    var employee: List<Employee>?,
    @SerializedName("region")
    var region: List<Region>?,
    @SerializedName("zone")
    var zone: List<Zone>?
):Parcelable

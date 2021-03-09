package com.akshay.greenlightassignment.data.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Area(
    @SerializedName("area")
    var area: String?,
    @SerializedName("territory")
    var territory: String?
):Parcelable
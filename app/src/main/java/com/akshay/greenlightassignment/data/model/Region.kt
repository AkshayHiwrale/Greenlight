package com.akshay.greenlightassignment.data.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Region(
    @SerializedName("region")
    var region: String?,
    @SerializedName("territory")
    var territory: String?
):Parcelable
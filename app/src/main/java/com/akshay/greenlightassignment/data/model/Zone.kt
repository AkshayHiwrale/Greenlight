package com.akshay.greenlightassignment.data.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Zone(
    @SerializedName("territory")
    var territory: String?,
    @SerializedName("zone")
    var zone: String?
):Parcelable
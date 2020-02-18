package com.amier.testmagangandroid.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MainData(
    var caption:String,
    var thumbnail:String,
    var image:String):Parcelable
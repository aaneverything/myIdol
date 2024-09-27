package com.example.myidol

import android.os.Parcelable
import kotlinx.parcelize.Parcelize



@Parcelize
data class Idol(
    val name: String,
    val description: String,
    val photo: Int,
    val fullname: String,
    val biodata: String
) : Parcelable

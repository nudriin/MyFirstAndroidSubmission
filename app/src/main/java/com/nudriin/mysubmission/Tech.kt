package com.nudriin.mysubmission

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Tech(
    val title: String,
    val description: String,
    val icon: String
): Parcelable

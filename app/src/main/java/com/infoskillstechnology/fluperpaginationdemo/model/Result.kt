package com.infoskillstechnology.fluperpaginationdemo.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Result(
    val description: String,
    val favorite_count: Int,
    val id: Int,
    val iso_639_1: String,
    val item_count: Int,
    val list_type: String,
    val name: String,
    val poster_path: String? =null
):Parcelable
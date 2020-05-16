package com.infoskillstechnology.fluperpaginationdemo.model

import android.os.Parcel
import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NotificationBeanModel(
    val id: Int,
    val page: Int,
    val results: ArrayList<Result>? = null,
    val total_pages: Int,
    val total_results: Int
) : Parcelable


val CALLBACK = object : DiffUtil.ItemCallback<Result>(){
    override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
       return oldItem.name.equals(newItem.name)
    }

}
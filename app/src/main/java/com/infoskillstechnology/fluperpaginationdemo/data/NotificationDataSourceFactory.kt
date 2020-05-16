package com.infoskillstechnology.fluperpaginationdemo.data

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.infoskillstechnology.fluperpaginationdemo.connection.ApiInterface
import com.infoskillstechnology.fluperpaginationdemo.model.Result


class NotificationDataSourceFactory(
    val app: Application,
    val apiService: ApiInterface
) : DataSource.Factory<Long, Result>() {

    val notificationMutableLiveData = MutableLiveData<NotificationDataSource>()

    override fun create(): DataSource<Long, Result> {
        val notificationDataSource = NotificationDataSource(app, apiService)
        notificationMutableLiveData.postValue(notificationDataSource)
        return notificationDataSource
    }

    fun getNotificationLiveData(): MutableLiveData<NotificationDataSource> {
        return notificationMutableLiveData
    }
}
package com.infoskillstechnology.fluperpaginationdemo.ui.second

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.infoskillstechnology.fluperpaginationdemo.connection.ApiInterface
import com.infoskillstechnology.fluperpaginationdemo.connection.ApiClient
import com.infoskillstechnology.fluperpaginationdemo.data.NotificationDataSourceFactory
import com.infoskillstechnology.fluperpaginationdemo.model.Result
import java.util.concurrent.Executors

class SecondViewModel() : ViewModel() {

    lateinit var notificationPagePageList : LiveData<PagedList<Result>>

    init {

    }


    fun initialization(app:Application){
        val apiService = ApiClient.client.create(ApiInterface::class.java)
        val notificationDataSourceFactory =  NotificationDataSourceFactory(app, apiService)
        val notificationLiveData =  notificationDataSourceFactory.getNotificationLiveData()

        val pageConfig = PagedList.Config.Builder()
            .setEnablePlaceholders(true)
            .setInitialLoadSizeHint(10)
            .setPageSize(20)
            .setPrefetchDistance(5)
            .build()

        val executable = Executors.newFixedThreadPool(5)

        notificationPagePageList = LivePagedListBuilder<Long,Result>(notificationDataSourceFactory, pageConfig)
            .setFetchExecutor(executable)
            .build()
    }

    fun getPageList():LiveData<PagedList<Result>> {
        return notificationPagePageList
    }

}

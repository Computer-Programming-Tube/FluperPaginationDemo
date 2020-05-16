package com.infoskillstechnology.fluperpaginationdemo.data

import android.app.Application
import android.util.Log
import androidx.paging.PageKeyedDataSource
import com.infoskillstechnology.fluperpaginationdemo.connection.ApiInterface
import com.infoskillstechnology.fluperpaginationdemo.model.Result
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class NotificationDataSource(val app:Application, val serviceApi: ApiInterface) : PageKeyedDataSource<Long,Result>() {

    override fun loadInitial(
        params: LoadInitialParams<Long>,
        callback: LoadInitialCallback<Long, Result>
    ) {
        serviceApi.getNotificationList(1,"014a0c24c4f63cb18d7fd5a87876a891", "en-Us")
            .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                callback.onResult(it.results!!,null,2)
            },{
                Log.e("Error", "thor ", it)
            })
    }



    override fun loadAfter(
        params: LoadParams<Long>,
        callback: LoadCallback<Long, Result>
    ) {

        serviceApi.getNotificationList(params.key+1,"014a0c24c4f63cb18d7fd5a87876a891", "en-Us")
            .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                callback.onResult(it.results!!,params.key + 1)
            },{
                Log.e("Error", "thor ", it)
            })
    }

    override fun loadBefore(
        params: LoadParams<Long>,
        callback: LoadCallback<Long, Result>
    ) {
    }
}
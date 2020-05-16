package com.infoskillstechnology.fluperpaginationdemo.connection


import com.infoskillstechnology.fluperpaginationdemo.model.NotificationBeanModel
import io.reactivex.Observable
import retrofit2.http.*

interface ApiInterface {

    @GET("movie/550/lists")
    fun getNotificationList(@Query("page")  pageNumber:Long,@Query("api_key")  api_key:String, @Query("language")  language:String) : Observable<NotificationBeanModel>
}




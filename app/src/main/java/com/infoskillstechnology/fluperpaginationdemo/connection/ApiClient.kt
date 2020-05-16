package com.infoskillstechnology.fluperpaginationdemo.connection

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {

//    val BASE_URL = "http://3.130.38.251:3000/user/"
    val BASE_URL = "http://api.themoviedb.org/3/"

    //    val BASE_URL = "http://3.130.38.251:3000/user/"
//    val BASE_URL = "https://dyndish.net/user/"
    val client: Retrofit by lazy {
        val httpClient = OkHttpClient.Builder()

        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        httpClient.addInterceptor(logging)

        httpClient.connectTimeout(20, TimeUnit.SECONDS)
        httpClient.readTimeout(20, TimeUnit.SECONDS)
        httpClient.writeTimeout(20, TimeUnit.SECONDS)
//
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build()
    }

}
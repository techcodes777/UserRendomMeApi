package com.eclatsol.userrendomme.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitClient {

    private const val baseUrl = "https://randomuser.me/"
    private const val baseUrlOther = "https://virtserver.swaggerhub.com/"
    private const val baseUrlJsonPlaceHolder = "https://jsonplaceholder.typicode.com/"

    val retrofit : Retrofit by lazy {
        Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build()
    }
    val retrofit2 : Retrofit by lazy {
        Retrofit.Builder().baseUrl(baseUrlOther).addConverterFactory(GsonConverterFactory.create()).build()
    }

    val retrofit3 : Retrofit by lazy {
        Retrofit.Builder().baseUrl(baseUrlJsonPlaceHolder).addConverterFactory(GsonConverterFactory.create()).build()
    }
}

object ApiServiceData{
    val apiService : ApiService by lazy {
        RetrofitClient.retrofit.create(ApiService::class.java)
    }
    val apiService2 : ApiService by lazy {
        RetrofitClient.retrofit2.create(ApiService::class.java)
    }

    val apiService3 : ApiService by lazy {
        RetrofitClient.retrofit3.create(ApiService::class.java)
    }


}
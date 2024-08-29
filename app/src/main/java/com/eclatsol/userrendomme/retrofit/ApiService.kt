package com.eclatsol.userrendomme.retrofit

import com.eclatsol.userrendomme.model.PostResponse
import com.eclatsol.userrendomme.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {

    @POST("posts")
    fun postApi() : Call<PostResponse>

    @GET("api/1.4")
    fun loginApi() : Call<UserResponse>

    @POST("/temperature/{zoneId}/heater/{state}")
    fun temperatureApi(@Path("zoneId") zoneId : String,@Path("state") state : String) : Call<PostResponse>
}
package com.androidstudio.intro.network

import com.androidstudio.intro.model.ResponseLogin
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiClient {

    @FormUrlEncoded
    @POST("api/login")
    fun login(
        @Field("email") username : String,
        @Field("password") password : String
    ): Call<ResponseLogin>
}
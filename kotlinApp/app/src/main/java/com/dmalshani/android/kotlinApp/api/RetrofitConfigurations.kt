package com.dmalshani.android.kotlinApp.api

import com.dmalshani.android.kotlinApp.model.User
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface UserAPIService{
    @GET("users")
    fun getUsers(): Call<List<User>>

    @GET("users/{userId}")
    fun getUser(@Path("userId") id: String):Call<User>
    companion object {
        val API_URL = "https://jsonplaceholder.typicode.com"
        fun create(): UserAPIService {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(API_URL)
                .build()
            return retrofit.create(UserAPIService::class.java)
        }

}

}
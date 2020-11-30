package com.keove.coroutine_retrofit.service

import com.keove.coroutine_retrofit.model.Users
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun getUsers(): Response<List<Users>>
}
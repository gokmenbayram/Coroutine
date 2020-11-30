package com.keove.coroutine_retrofit.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val API_URL = "https://jsonplaceholder.typicode.com/"

object ApiClient {

    private var retrofit: Retrofit? = null

    fun api(): Retrofit {
        if (retrofit == null)
            retrofit =
                Retrofit.Builder()
                    .baseUrl(API_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

        return retrofit as Retrofit
    }
}
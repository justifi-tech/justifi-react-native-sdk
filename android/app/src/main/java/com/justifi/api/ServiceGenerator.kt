package com.justifi.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceGenerator {

    private const val URL = "https://api.justifi-staging.com"

    private val client = OkHttpClient.Builder().build();

    private val retrofit = Retrofit.Builder()
      .baseUrl(URL)
      .addConverterFactory(GsonConverterFactory.create())
      .client(client)
      .build();

    fun <T> buildService(service: Class<T>): T {
      return retrofit.create(service)
    }
}

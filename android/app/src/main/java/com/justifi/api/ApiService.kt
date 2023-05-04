package com.justifi.api

import retrofit2.Call
import retrofit2.http.*

/**
 * The ApiService is an interface to define abstract methods.
 * Where each method is going to represent a specific path of our API.
 * */
interface ApiService {

    @Headers("Content-Type: application/json")
    @POST("/oauth/token")
    fun oauth(@Body data: TokenModel): Call<ClientModel>

}

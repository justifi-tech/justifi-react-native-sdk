package com.justifi.api

import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @Headers("Content-Type: application/json")
    @POST("/oauth/token")
    fun oauth(@Body data: TokenModel): Call<ClientModel>

}

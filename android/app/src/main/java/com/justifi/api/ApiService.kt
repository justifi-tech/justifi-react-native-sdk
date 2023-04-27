package com.justifi.api

import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @Headers("Content-Type: application/json")
    @POST("/oauth/token")
    fun oauth(@Body data: TokenModel): Call<ClientModel>

    @GET("/v1/payments")
    fun listPayments(): Call<MutableList<PaymentModel>>

    //@Headers( "Authorization: Bearer {access_token}" )
    @POST("/v1/payments")
    open fun createPayment(
        @Header("Authorization") content_type: String?,
        @Body req: NewPaymentModel
    ): Call<MutableList<PaymentModel>>

}

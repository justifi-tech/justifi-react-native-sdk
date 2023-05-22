package com.justifireactnativesdk.api

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

  @POST("/v1/js/payment_methods")
  open fun createPaymentMethod(
    @Header("Content-Type") content_type: String?,
    @Header("Idempotency-Key") idempotency_key: String?,
    @Header("Authorization") authorization: String?,
    @Header("Sub-Account") sub_account: String?,
    @Body req: NewPaymentModel
  ): Call<PaymentModel>

}

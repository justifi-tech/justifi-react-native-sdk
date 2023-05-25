package com.justifireactnativesdk.api

import com.google.gson.annotations.SerializedName

data class NewPaymentModel (
  @SerializedName("payment_method") val paymentMethod: PaymentMethodModel,

  )

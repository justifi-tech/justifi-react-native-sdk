package com.justifireactnativesdk.api

import com.google.gson.annotations.SerializedName

data class DataModel (
  @SerializedName("signature") val signature: String?,
  @SerializedName("customer_id") val customerId: String?,
  @SerializedName("account_id") val accountId: String?,
  @SerializedName("card") val card: CardDataModel?,
)

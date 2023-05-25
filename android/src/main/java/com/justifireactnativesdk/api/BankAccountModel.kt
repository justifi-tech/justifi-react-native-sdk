package com.justifireactnativesdk.api

import com.google.gson.annotations.SerializedName

data class BankAccountModel (
  @SerializedName("account_owner_name") val accountOwnerName: String,
  @SerializedName("routing_number") val routingNumber: Long,
  @SerializedName("account_number") val accountNumber: String,
  @SerializedName("account_type") val accountType: String,
  @SerializedName("account_owner_type") val accountOwnerType: String,
  @SerializedName("country") val country: String,
  @SerializedName("currency") val currency: String,
)

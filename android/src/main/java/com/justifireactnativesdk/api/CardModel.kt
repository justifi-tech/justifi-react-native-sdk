package com.justifireactnativesdk.api

import com.google.gson.annotations.SerializedName
import org.json.JSONObject

data class CardModel(
  @SerializedName("name") val name: String,
  @SerializedName("number") val number: Long,
  @SerializedName("verification") val verification: Int?,
  @SerializedName("month") val month: Int,
  @SerializedName("year") val year: Int,
  @SerializedName("address_postal_code") val address_postal_code: Int,

  )

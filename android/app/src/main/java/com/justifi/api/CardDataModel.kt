package com.justifi.api

import com.google.gson.annotations.SerializedName
import org.json.JSONObject

data class CardDataModel(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String?,
    @SerializedName("acct_last_four") val acctLastFour: String?,
    @SerializedName("brand") val brand: String?,
    @SerializedName("token") val token: String,
    @SerializedName("month") val month: String,
    @SerializedName("year") val year: String,

)

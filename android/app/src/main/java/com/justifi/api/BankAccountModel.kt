package com.justifi.api

import com.google.gson.annotations.SerializedName
import org.json.JSONObject

data class BankAccountModel (
    @SerializedName("account_owner_name") val accountOwnerName: String,
    @SerializedName("routing_number") val routingNumber: String,
    @SerializedName("account_number") val accountNumber: String,
    @SerializedName("account_type") val accountType: String,
    @SerializedName("account_owner_type") val accountOwnerType: String,
    @SerializedName("country") val country: String,
    @SerializedName("currency") val currency: String,
    @SerializedName("metadata") val metadata: JSONObject?,
)

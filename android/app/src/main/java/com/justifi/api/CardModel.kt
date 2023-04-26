package com.justifi.api

import com.google.gson.annotations.SerializedName
import org.json.JSONObject

data class CardModel (
    @SerializedName("name") val name: String,
    @SerializedName("number") val number: String,
    @SerializedName("verification") val verification: String?,
    @SerializedName("month") val month: String,
    @SerializedName("year") val year: String,

    @SerializedName("address_line1") val address_line1: String?,
    @SerializedName("address_line2") val address_line2: String?,
    @SerializedName("address_city") val address_city: String?,
    @SerializedName("address_state") val address_state: String?,
    @SerializedName("address_postal_code") val address_postal_code: String,
    @SerializedName("address_country") val address_country: String?,
    @SerializedName("brand") val brand: String?,
    @SerializedName("metadata") val metadata: JSONObject?,
)

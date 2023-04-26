package com.justifi.api

import com.google.gson.annotations.SerializedName

data class TokenModel (
    @SerializedName("client_id") val clientId: String?,
    @SerializedName("client_secret") val clientSecret: String?
)

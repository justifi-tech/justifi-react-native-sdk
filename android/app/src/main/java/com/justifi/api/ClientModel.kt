package com.justifi.api

import com.google.gson.annotations.SerializedName

data class ClientModel (
    @SerializedName("access_token") val accessToken: String?
)

package com.justifi.api

import com.google.gson.annotations.SerializedName
import org.json.JSONObject

data class NewPaymentModel (
    @SerializedName("amount") val amount: Int,
    @SerializedName("currency") val currency: String,
    @SerializedName("capture_strategy") val captureStrategy: String,
    @SerializedName("email") val email: String?,
    @SerializedName("payment_method") val paymentMethod: PaymentMethodModel,
    @SerializedName("application_fee_amount") val applicationFeeAmount: Int?,
    @SerializedName("description") val description: String?,
    @SerializedName("metadata") val metadata: JSONObject?,

)

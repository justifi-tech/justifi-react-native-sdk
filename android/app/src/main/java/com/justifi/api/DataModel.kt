package com.justifi.api

import com.google.gson.annotations.SerializedName
import org.json.JSONObject

data class DataModel (
    @SerializedName("id") val id: String?,
    @SerializedName("account_id") val accountId: String?,
    @SerializedName("amount") val amount: Int?,
    @SerializedName("amount_disputed") val amountDisputed: Int?,
    @SerializedName("amount_refunded") val amountRefunded: Int?,
    @SerializedName("amount_refundable") val amountRefundable: Int?,
    @SerializedName("balance") val balance: Int?,
    @SerializedName("fee_amount") val feeAmount: Int?,
    @SerializedName("financial_transaction_id") val financialTransactionId: String?,

    @SerializedName("captured") val captured: Boolean?,
    @SerializedName("capture_strategy") val captureStrategy: String?,
    @SerializedName("currency") val currency: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("disputed") val disputed: Boolean?,
    @SerializedName("error_code") val errorCode: String?,
    @SerializedName("error_description") val errorDescription: String?,
    @SerializedName("is_test") val isTest: Boolean?,
    @SerializedName("metadata") val metadata: JSONObject?,
    @SerializedName("payment_intent_id") val paymentIntentId: String?,

    @SerializedName("payment_method") val paymentMethod: PaymentModel?,
    @SerializedName("application_fee") val applicationFee: JSONObject?,
    @SerializedName("refunded") val refunded: Boolean?,
    @SerializedName("status") val status: String?,
    @SerializedName("created_at") val createdAt: String?,
    @SerializedName("updated_at") val updatedAt: String?,
    )

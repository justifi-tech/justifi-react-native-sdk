package com.justifi.api

import com.google.gson.annotations.SerializedName

data class PaymentMethodModel (
    @SerializedName("card") val card: CardModel?,
    // @SerializedName("bank_account") val bankAccount: BankAccountModel?,
    @SerializedName("token") val token: String?,
)

package com.justifireactnativesdk.api

import com.google.gson.annotations.SerializedName

data class PaymentMethodModel (
  @SerializedName("card") val card: CardModel?,
  @SerializedName("bank_account") val bankAccount: BankAccountModel?,
)

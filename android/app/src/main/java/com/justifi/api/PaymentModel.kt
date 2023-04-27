package com.justifi.api

data class PaymentModel (
    val id: String? = null,
    val type: String? = null,
    val data: DataModel? = null,
    val page_info: PageInfoModel? = null,
)

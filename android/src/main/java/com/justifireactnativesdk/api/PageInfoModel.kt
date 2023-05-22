package com.justifireactnativesdk.api

import com.google.gson.annotations.SerializedName

data class PageInfoModel (
  @SerializedName("end_cursor") val endCursor: String?,
  @SerializedName("has_next") val hasNext: Boolean?,
  @SerializedName("has_previous") val hasPrevious: Boolean?,
  @SerializedName("start_cursor") val startCursor: String?,
)

package com.justifi.ui

import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.justifi.R
import com.justifi.api.*
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.module.annotations.ReactModule
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import android.util.Base64

@ReactModule(name = "UtilsModule")
class UtilsModule (reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {

  private var clientId: String? = null
  private var account: String? = null
  private lateinit var contextReact: ReactApplicationContext

  override fun getName() = "UtilsModule"

  override fun initialize() {
    super.initialize()
    contextReact = reactApplicationContext
  }

  private fun getPreferences(): SharedPreferences {
    return contextReact.getSharedPreferences(
      contextReact.getString(R.string.preference_file_key),
      Context.MODE_PRIVATE
    )
  }

}

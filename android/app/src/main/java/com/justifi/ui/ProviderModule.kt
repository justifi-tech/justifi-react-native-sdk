package com.justifi.ui

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.justifi.R
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.module.annotations.ReactModule

@ReactModule(name = "ProviderModule")
class ProviderModule (reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext){

  private lateinit var contextReact: ReactApplicationContext

  override fun getName() = "ProviderModule"

  override fun initialize() {
    super.initialize()
    contextReact = reactApplicationContext
  }

  private fun getPreferences(): SharedPreferences {
    return contextReact.getSharedPreferences(contextReact.getString(R.string.preference_file_key), Context.MODE_PRIVATE)
  }

  /***
   * The initialise function saves the clientId and the account data, calls the callback
   * when finished.
   * @param clientId String value of the client id
   * @param account String value of the account
   * @param callback Callback with the result
   */
  @ReactMethod
  fun initialise(clientId: String, account: String, callback: com.facebook.react.bridge.Callback) {
    getPreferences().edit().putString("clientId", clientId).commit()
    getPreferences().edit().putString("account", account).commit()

    callback.invoke()
  }
}

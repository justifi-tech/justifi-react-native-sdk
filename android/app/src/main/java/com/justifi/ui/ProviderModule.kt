package com.justifi.ui

import android.util.Log
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.module.annotations.ReactModule

@ReactModule(name = "ProviderModule")
class ProviderModule (reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext){

    private var clientId: String? = null
    private var account: String? = null

    override fun getName() = "ProviderModule"

    @ReactMethod
    fun initialise(clientId: String, account: String, callback: com.facebook.react.bridge.Callback) {
        Log.d("CardViewModule clientId", clientId)
        Log.d("CardViewModule account", account)
        this.clientId = clientId
        this.account = account
        callback.invoke()
    }
}

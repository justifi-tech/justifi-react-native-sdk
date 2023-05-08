package com.justifi.ui

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.justifi.R
import com.justifi.api.ApiService
import com.justifi.api.ClientModel
import com.justifi.api.ServiceGenerator
import com.justifi.api.TokenModel
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.module.annotations.ReactModule
import com.google.gson.Gson
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

  /***
   * The tokenize function receives the clientId, the paymentMethodMetadata, the account, and the callback
   * and returns the payment method token on the callback.
   * @param paymentMethodMetadata String value of the paymentMethod metadata
   * @param callback Callback with the result
   */
  @ReactMethod
  fun tokenize(paymentMethodMetadata: String, callback: com.facebook.react.bridge.Callback) {
    // load data from provider
    clientId = getPreferences()?.getString("clientId", "").toString()
    account = getPreferences()?.getString("account", "").toString()

    Log.d("prefClientId", clientId!!)
    Log.d("prefAccountId", account!!)

    val serviceGenerator = ServiceGenerator.buildService(ApiService::class.java)

    // oauth
    val data = TokenModel(
      clientId = clientId,
      clientSecret = account)
    val call = serviceGenerator.oauth(data)

    call.enqueue(object : Callback<ClientModel> {

      override fun onResponse(call: Call<ClientModel>, response: Response<ClientModel>) {
        if (response.isSuccessful) {
          val jsonObject = JSONObject(Gson().toJson(response.body()))
          val token = jsonObject.getString("access_token")
          Log.e("tokenize success", token.toString())
          callback.invoke(token)
        }
      }

      override fun onFailure(call: Call<ClientModel>, t: Throwable) {
        Log.e("error", t.message.toString())
        callback.invoke(null)
      }
    })
  }

  /***
   * The validate function verifies that the data is correct and returns the result in the isValid parameter.
   * @param callback Callback with the result
   */
  @ReactMethod
  fun validate(callback: com.facebook.react.bridge.Callback) {
    Log.d("validate", "")
    // TODO: validate
    callback.invoke(true)
  }
}

package com.justifi.ui

import android.util.Log
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.annotations.ReactProp
import com.google.gson.Gson
import com.justifi.api.ApiService
import com.justifi.api.ClientModel
import com.justifi.api.ServiceGenerator
import com.justifi.api.TokenModel
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CardViewManager : SimpleViewManager<CardView>() {

  private lateinit var contextReact: ThemedReactContext

  override fun getName() = "CardFormView"

  override fun createViewInstance(context: ThemedReactContext): CardView {
    contextReact = context
    return CardView(context)
  }

  /***
   * The styleOverrides prop is a custom prop that can be used to provide custom styles for
   * CardFormView component. This prop takes a stringified instance of Theme. The type and all optional
   * members for Theme can be found here:
   * https://github.com/justifi-tech/web-component-library/tree/main/stencil-library/src/components/payment-method-form/theme.ts
   */
  @ReactProp(name = "styleOverrides")
  fun setStyleOverrides(view: CardView, styleOverrides: String?) {
    view.setStyleOverrides(styleOverrides.toString())
  }

  /***
   * The validationStrategy prop defines when the validation of the CardFormView component is performed,
   * its values can be as follows: "all" | "onBlur" | "onChange" | "onSubmit" | "onTouched"
   */
  @ReactProp(name = "validationStrategy")
  fun setValidationStrategy(view: CardView, validationStrategy: String?) {
    view.setValidationStrategy(validationStrategy.toString())
  }

  /***
   * The tokenize function receives the clientId, the paymentMethodMetadata and the account,
   * and returns the payment method token.
   */
  @ReactMethod
  fun tokenize(clientId: String, paymentMethodMetadata: String, account: String) {
    Log.d("tokenize clientId", clientId.toString())
    Log.d("tokenize account", account.toString())
    val serviceGenerator = ServiceGenerator.buildService(ApiService::class.java)

    // oauth
    val data = TokenModel(
      clientId = clientId,
      clientSecret = account)
    val call = serviceGenerator.oauth(data)

    return call.enqueue(object : Callback<ClientModel> {

      override fun onResponse(call: Call<ClientModel>, response: Response<ClientModel>) {
        if (response.isSuccessful) {
          val jsonObject = JSONObject(Gson().toJson(response.body()))
          val token = jsonObject.getString("access_token")
          Log.e("tokenize success", token.toString())
        }
      }

      override fun onFailure(call: Call<ClientModel>, t: Throwable) {
        Log.e("error", t.message.toString())
      }
    })
  }

  /***
   * The validate function verifies that the data is correct and returns the result in the isValid parameter.
   */
  @ReactMethod
  fun validate(): Boolean {
    Log.d("validate", "")
    // TODO: validate
    return false
  }

  /***
   * The onLoad function initializes the data to start the payment operation.
   */
  @ReactMethod
  fun onLoad() {
    Log.d("onLoad", "")
    // TODO: init data
  }

}


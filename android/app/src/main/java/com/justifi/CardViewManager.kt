package com.justifi

import android.util.Log
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.annotations.ReactProp

class CardViewManager : SimpleViewManager<CardView>() {

  override fun getName() = "CardFormView"

  override fun createViewInstance(context: ThemedReactContext): CardView {
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
  fun tokenize(clientId: String, paymentMethodMetadata: String, account: String): String {
    Log.d("tokenize", clientId.toString())
    // TODO: API call
    return ""
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

package com.justifi

import android.util.Log
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.annotations.ReactProp

class CardViewManager (
  private val callerContext: ReactApplicationContext
) : SimpleViewManager<CardView>() {

  override fun getName() = "CardFormView"

  override fun createViewInstance(context: ThemedReactContext): CardView {
    return CardView(context)
  }

  @ReactProp(name = "styleOverrides")
  fun setStyleOverrides(view: CardView, styleOverrides: String?) {
    view.setStyleOverrides(styleOverrides.toString())
  }

  @ReactProp(name = "validationStrategy")
  fun setValidationStrategy(view: CardView, validationStrategy: String?) {
    view.setValidationStrategy(validationStrategy.toString())
  }

  @ReactMethod
  fun tokenize(clientId: String, paymentMethodMetadata: String, account: String): String {
    Log.d("tokenize", clientId.toString())
    // TODO: API call
    return ""
  }

  @ReactMethod
  fun validate(): Boolean {
    Log.d("validate", "")
    // TODO: validate data
    return true
  }

  @ReactMethod
  fun onLoad() {
    Log.d("onLoad", "")
    // TODO: init data
  }

}

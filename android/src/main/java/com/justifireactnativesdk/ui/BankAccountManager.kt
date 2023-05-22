package com.justifireactnativesdk.ui

import android.util.Log
import com.justifireactnativesdk.Utils
import com.facebook.react.bridge.ReadableMap
import com.facebook.react.common.MapBuilder
import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.annotations.ReactProp

/**
 * BankAccountManager handles the instance of the BankAccount view and updates its properties.
 * All sensitive data and methods of the BankAccountFormView component are encapsulated internally,
 * thus preventing unauthorized access or modification through refs.
 */
class BankAccountManager : SimpleViewManager<BankAccount>() {

  private lateinit var contextReact: ThemedReactContext

  override fun getName() = "BankAccountFormView"

  override fun createViewInstance(context: ThemedReactContext): BankAccount {
    contextReact = context
    return BankAccount(context)
  }

  /***
   * The styleOverrides prop is a custom prop that can be used to provide custom styles for
   * BankAccountFormView component. This prop takes a string instance of Theme. The type and all optional
   * members for Theme can be found here:
   * https://github.com/justifi-tech/web-component-library/tree/main/stencil-library/src/components/payment-method-form/theme.ts
   * @param view view to which the style is applied
   * @param styleOverrides a JSON with the styles
   */
  @ReactProp(name = "styleOverrides")
  fun setStyleOverrides(view: BankAccount, styleOverrides: ReadableMap?) {
    Log.d("setStyleOverrides", "setStyleOverrides")
    try {
      Utils.convertMapToJson(styleOverrides)?.let {
        view.setStyleOverrides(it)
      }
    } catch (e: Exception) {
      Log.d("setStyleOverrides", e.toString())
    }
  }

  /***
   * The getExportedCustomDirectEventTypeConstants function returns a map with the custom events
   */
  override fun getExportedCustomDirectEventTypeConstants(): MutableMap<String, Any>? {
    return MapBuilder.of(
      "onSubmit",
      MapBuilder.of("registrationName", "onSubmit")
    )
  }

}


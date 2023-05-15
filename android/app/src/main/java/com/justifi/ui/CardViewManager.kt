package com.justifi.ui

import android.util.Log
import com.justifi.Utils
import com.facebook.react.bridge.ReadableMap
import com.facebook.react.common.MapBuilder
import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.annotations.ReactProp


/**
 * CardViewManager handles the instance of the CardView view and updates its properties.
 * All sensitive data and methods of the CardFormView component are encapsulated internally,
 * thus preventing unauthorized access or modification through refs.
 */
class CardViewManager : SimpleViewManager<CardView>() {

  private var contextReact: ThemedReactContext? = null

  override fun getName() = "CardFormView"

  override fun createViewInstance(context: ThemedReactContext): CardView {
    contextReact = context
    return CardView(context)
  }

  /***
   * The styleOverrides prop is a custom prop that can be used to provide custom styles for
   * CardFormView component. This prop takes a string instance of Theme. The type and all optional
   * members for Theme can be found here:
   * https://github.com/justifi-tech/web-component-library/tree/main/stencil-library/src/components/payment-method-form/theme.ts
   * @param view view to which the style is applied
   * @param styleOverrides a JSON with the styles
   */
  @ReactProp(name = "styleOverrides")
  fun setStyleOverrides(view: CardView, styleOverrides: ReadableMap?) {
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
      "onSubmitCard",
      MapBuilder.of("registrationName", "onSubmitCard")
    )
  }

}



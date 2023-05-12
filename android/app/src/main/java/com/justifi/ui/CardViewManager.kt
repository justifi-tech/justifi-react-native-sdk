package com.justifi.ui

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.common.MapBuilder
import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.annotations.ReactProp


/**
 * CardViewManager handles the instance of the CardView view and updates its properties.
 * All sensitive data and methods of the CardFormView component are encapsulated internally,
 * thus preventing unauthorized access or modification through refs.
 */
class CardViewManager(private val reactContext: ReactApplicationContext) : SimpleViewManager<CardView>() {

  private var contextReact: ThemedReactContext? = null
  private var cardView: CardView? = null

  override fun getName() = "CardFormView"

  override fun createViewInstance(context: ThemedReactContext): CardView {
    contextReact = context
    cardView = CardView(context)
    return cardView!!
  }

  /***
   * The styleOverrides prop is a custom prop that can be used to provide custom styles for
   * CardFormView component. This prop takes a string instance of Theme. The type and all optional
   * members for Theme can be found here:
   * https://github.com/justifi-tech/web-component-library/tree/main/stencil-library/src/components/payment-method-form/theme.ts
   * @param view view to which the style is applied
   * @param styleOverrides a JSON string with the styles
   */
  @ReactProp(name = "styleOverrides")
  fun setStyleOverrides(view: CardView, styleOverrides: String?) {
    view.setStyleOverrides(styleOverrides.toString())
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



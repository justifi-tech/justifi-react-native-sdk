package com.justifi.ui

import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.annotations.ReactProp

/**
 * CardViewManager handles the instance of the CardView view and updates its properties.
 * All sensitive data and methods of the CardFormView component are encapsulated internally,
 * thus preventing unauthorized access or modification through refs.
 */
class CardViewManager : SimpleViewManager<CardView>() {

  private lateinit var contextReact: ThemedReactContext

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
   * @param styleOverrides a JSON string with the styles
   */
  @ReactProp(name = "styleOverrides")
  fun setStyleOverrides(view: CardView, styleOverrides: String?) {
    view.setStyleOverrides(styleOverrides.toString())
  }

  /***
   * The validationStrategy prop defines when the validation of the CardFormView component is performed,
   * its values can be as follows: "all" | "onBlur" | "onChange" | "onSubmit" | "onTouched"
   * @param view view to which the prop is applied
   * @param validationStrategy its values can be as follows: "all" | "onBlur" | "onChange" | "onSubmit" | "onTouched"
   */
  @ReactProp(name = "validationStrategy")
  fun setValidationStrategy(view: CardView, validationStrategy: String?) {
    view.setValidationStrategy(validationStrategy.toString())
  }

}



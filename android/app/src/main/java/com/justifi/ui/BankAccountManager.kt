package com.justifi.ui

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.annotations.ReactProp

class BankAccountManager(
  private val callerContext: ReactApplicationContext
) : SimpleViewManager<BankAccount>() {

  override fun getName() = "BankAccountFormView"

  override fun createViewInstance(context: ThemedReactContext): BankAccount {
    return BankAccount(context)
  }

  @ReactProp(name = "styleOverrides")
  fun setStyleOverrides(view: BankAccount, styleOverrides: String?) {
    view.setStyleOverrides(styleOverrides.toString())
  }

  @ReactProp(name = "validationStrategy")
  fun setValidationStrategy(view: BankAccount, validationStrategy: String?) {
    view.setValidationStrategy(validationStrategy.toString())
  }
}


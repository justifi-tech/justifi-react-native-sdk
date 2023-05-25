package com.justifi

import com.justifi.ui.BankAccountManager
import com.justifi.ui.CardViewManager
import com.justifi.ui.ProviderModule
import com.facebook.react.ReactPackage
import com.facebook.react.bridge.NativeModule
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.uimanager.ViewManager

class FormPackage : ReactPackage {

  override fun createNativeModules(reactContext: ReactApplicationContext): List<NativeModule> {
    return listOf(CardViewManager(),
      ProviderModule(reactContext),
      BankAccountManager())
  }

  override fun createViewManagers(reactContext: ReactApplicationContext): List<ViewManager<*, *>> {
    return listOf<ViewManager<*, *>>(
      BankAccountManager(),
      CardViewManager()
    )
  }

}

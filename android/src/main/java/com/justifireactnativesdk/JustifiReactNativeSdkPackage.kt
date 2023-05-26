package com.justifireactnativesdk

import com.facebook.react.ReactPackage
import com.facebook.react.bridge.NativeModule
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.uimanager.ViewManager
import com.justifireactnativesdk.ui.BankAccountManager
import com.justifireactnativesdk.ui.CardViewManager
import com.justifireactnativesdk.ui.ProviderModule


class JustifiReactNativeSdkPackage : ReactPackage {
  override fun createNativeModules(reactContext: ReactApplicationContext): List<NativeModule> {
    return listOf(
      CardViewManager(),
      ProviderModule(reactContext),
      BankAccountManager()
    )
  }

  override fun createViewManagers(reactContext: ReactApplicationContext): List<ViewManager<*, *>> {
    return listOf<ViewManager<*, *>>(
      BankAccountManager(),
      CardViewManager()
    )
  }
}

package com.justifireactnativesdk

import com.justifi.ui.BankAccountManager
import com.justifi.ui.CardViewManager
import com.justifi.ui.ProviderModule
import com.facebook.react.ReactPackage
import com.facebook.react.bridge.NativeModule
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.uimanager.ViewManager
import com.justifireactnativesdk.ui.BankAccountManager
import com.justifireactnativesdk.ui.CardViewManager
import com.justifireactnativesdk.ui.ProviderModule


class JustifiReactNativeSdkPackage : ReactPackage {
  override fun createNativeModules(reactContext: ReactApplicationContext): List<NativeModule> {
<<<<<<< HEAD:android/src/main/java/com/justifireactnativesdk/JustifiReactNativeSdkPackage.kt
    return listOf(
      CardViewManager(),
      ProviderModule(reactContext),
      BankAccountManager()
    )
=======
    return listOf(CardViewManager(),
      ProviderModule(reactContext),
      BankAccountManager())
>>>>>>> 78ef2d7be542039118b1b97b00156fe4ee2b8c3d:android/app/src/main/java/com/justifi/FormPackage.kt
  }

  override fun createViewManagers(reactContext: ReactApplicationContext): List<ViewManager<*, *>> {
    return listOf<ViewManager<*, *>>(
      BankAccountManager(),
      CardViewManager()
    )
  }
}

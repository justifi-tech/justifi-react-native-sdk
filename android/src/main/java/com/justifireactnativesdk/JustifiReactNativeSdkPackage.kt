package com.justifireactnativesdk

<<<<<<< HEAD
import com.justifi.ui.BankAccountManager
import com.justifi.ui.CardViewManager
import com.justifi.ui.ProviderModule
=======
>>>>>>> main
import com.facebook.react.ReactPackage
import com.facebook.react.bridge.NativeModule
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.uimanager.ViewManager
import com.justifireactnativesdk.ui.BankAccountManager
import com.justifireactnativesdk.ui.CardViewManager
import com.justifireactnativesdk.ui.ProviderModule


class JustifiReactNativeSdkPackage : ReactPackage {
  override fun createNativeModules(reactContext: ReactApplicationContext): List<NativeModule> {
<<<<<<< HEAD
<<<<<<< HEAD:android/src/main/java/com/justifireactnativesdk/JustifiReactNativeSdkPackage.kt
=======
>>>>>>> main
    return listOf(
      CardViewManager(),
      ProviderModule(reactContext),
      BankAccountManager()
    )
<<<<<<< HEAD
=======
    return listOf(CardViewManager(),
      ProviderModule(reactContext),
      BankAccountManager())
>>>>>>> 78ef2d7be542039118b1b97b00156fe4ee2b8c3d:android/app/src/main/java/com/justifi/FormPackage.kt
=======
>>>>>>> main
  }

  override fun createViewManagers(reactContext: ReactApplicationContext): List<ViewManager<*, *>> {
    return listOf<ViewManager<*, *>>(
      BankAccountManager(),
      CardViewManager()
    )
  }
}

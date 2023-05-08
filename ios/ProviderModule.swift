import Foundation
import React

@objc(ProviderModule)
class ProviderModule: NSObject, RCTBridgeModule {
  static func moduleName() -> String {
    return "ProviderModule"
  }
  
  @objc static func requiresMainQueueSetup() -> Bool {
      return true
    }

  @objc func initialise(_ clientId: String, account: String, callback: @escaping RCTResponseSenderBlock) {
    let preferences = UserDefaults.standard
    preferences.set(clientId, forKey: "clientId")
    preferences.set(account, forKey: "account")
    preferences.synchronize()

    print("ClientId: \(clientId)")
    print("Account: \(account)")

    callback([])
  }
}

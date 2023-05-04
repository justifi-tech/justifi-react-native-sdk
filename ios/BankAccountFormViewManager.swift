import UIKit
import React

@objc(BankAccountFormViewManager)
class BankAccountFormViewManager: RCTViewManager {
  override func view() -> UIView! {
    print("BankAccountFormViewManager initialized", #file, #function, #line)

    return BankAccountFormView()
  }
  override class func requiresMainQueueSetup() -> Bool {
      return false
  }
  
  @objc func validateCardData(_ node: NSNumber, resolver: @escaping RCTPromiseResolveBlock, rejecter: @escaping RCTPromiseRejectBlock) {
      // Implement validation functionality without exposing sensitive data
  }

  @objc func submitCardData(_ node: NSNumber, resolver: @escaping RCTPromiseResolveBlock, rejecter: @escaping RCTPromiseRejectBlock) {
      // Implement submission functionality without exposing sensitive data
  }

}


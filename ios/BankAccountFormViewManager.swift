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
  

}


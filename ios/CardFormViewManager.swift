import UIKit

@objc(CardFormViewManager)
class CardFormViewManager: RCTViewManager {
  override func view() -> UIView! {
    print("BankAccountFormViewManager initialized", #file, #function, #line)

    return CardFormView()
  }
  override class func requiresMainQueueSetup() -> Bool {
      return false
  }
  

}


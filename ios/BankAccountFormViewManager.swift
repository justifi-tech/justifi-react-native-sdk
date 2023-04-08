@objc(BankAccountFormViewManager)
class BankAccountFormViewManager: RCTViewManager {
  override func view() -> UIView! {
    return BankAccountFormView()
  }
  override static func requiresMainQueueSetup() -> Bool {
     return true
   }
}

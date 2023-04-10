@objc(BankAccountFormViewManager)
class BankAccountFormViewManager: RCTViewManager {
  override func view() -> UIView! {
    return BankAccountFormView()
  }

//  struct BankAccountFormStyle {
//    let labelStyle: [String: Any]?
//    let inputContainerStyle: [String: Any]?
//    let inputStyle: [String: Any]?
//    let errorStyle: [String: Any]?
//  }
//
//
//  @objc func setStyles(_ node: NSNumber, styles: NSDictionary) {
//    let labelStyle = styles["formLabel"] as? [String: Any]
//    let inputContainerStyle = styles["formControl"] as? [String: Any]
//    let inputStyle = styles["formInput"] as? [String: Any]
//    let errorStyle = styles["errorMessage"] as? [String: Any]
//
//    let bankAccountFormStyle = BankAccountFormStyle(
//      labelStyle: labelStyle,
//      inputContainerStyle: inputContainerStyle,
//      inputStyle: inputStyle,
//      errorStyle: errorStyle
//    )
//  }

  override static func requiresMainQueueSetup() -> Bool {
    return true
  }
}

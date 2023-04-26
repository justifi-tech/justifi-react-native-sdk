@objc(BankAccountFormFunctions)
class BankAccountFormFunctions: NSObject {
  private var formView: BankAccountFormView?

  override init() {
      super.init()

  }

  @objc func validate(_ callback: @escaping RCTResponseSenderBlock) {
      guard let formView = self.formView else {
          print("enters to not form view")

          callback([false])
          return
      }
  }



  @objc func tokenize(_ callback: @escaping RCTResponseSenderBlock) {
      guard let formView = formView else {
          callback([[:]])
          return
      }
  }

}

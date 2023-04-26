@objc(BankAccountFormFunctions)
class BankAccountFormFunctions: NSObject {
  private var formView: BankAccountFormView?

  override init() {
      super.init()

  }

  @objc func validate(_ callback: @escaping RCTResponseSenderBlock) {
//      guard let formView = self.formView else {
//          print("enters to not form view")
//
//          callback([false])
//          return
//      }
    

  }
  


  @objc func tokenize(_ callback: @escaping RCTResponseSenderBlock) {
      APIManager.createAuthToken(
          clientId: "test_Sbxw9RJ8PplOrC5ezUHcU5X9vJ3Q4Fmx",
          clientSecret: "test_ZIRvzP5R4aWfeTq0vQjNgXmg1RL3r3fk-kM5jALXm8kRY_7XieYuWbbiN4grB-oX"
      ) { result in
          switch result {
          case .success(let accessToken):
            print("Tokenized data on success: \(accessToken)")

              callback([accessToken])
          case .failure(let error):
              print("API error: \(error.localizedDescription)")
              callback([false])
          }
      }
  }




}

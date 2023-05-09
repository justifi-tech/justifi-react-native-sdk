@objc(BankAccountFormFunctions)
class BankAccountFormFunctions: NSObject {
    private var formView: BankAccountFormView?
  
  override init() {
      super.init()

  }

    @objc func validate(_ callback: @escaping RCTResponseSenderBlock) {
        // Your implementation for the validate function
    }

    @objc func tokenize(_ callback: @escaping RCTResponseSenderBlock) {
        guard let clientId = UserDefaults.standard.string(forKey: "clientId"), let account = UserDefaults.standard.string(forKey: "account") else {
            callback([false])
            return
        }
      
        print("ClientId in form functions: \(clientId)")


        APIManager.createAuthToken(
            clientId: clientId,
            clientSecret: account
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

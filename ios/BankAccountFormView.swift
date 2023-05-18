import UIKit

@objc(BankAccountFormView)
class BankAccountFormView: UIView {
  fileprivate let routingNumberField = FieldView()
  fileprivate let accountNumberField = FieldView()
  fileprivate let stackView = UIStackView()
  fileprivate let submitButton = UIButton(type: .system)
  fileprivate var routingNumber = ""
  fileprivate var accountNumber = ""
  
  @objc var onSubmit: RCTBubblingEventBlock?
  
    // Matches a regular expression pattern in the given text.
    // - Parameters:
    //   - pattern: The regular expression pattern to match.
    //   - text: The text to search for matches.
    // - Returns: `true` if a match is found, `false` otherwise.
  func matches(_ pattern: String, in text: String) -> Bool {
      guard let regex = try? NSRegularExpression(pattern: pattern, options: []) else { return false }
      let range = NSRange(location: 0, length: text.utf16.count)
      return regex.firstMatch(in: text, options: [], range: range) != nil
  }

    // Sends an event with the specified status code, data, and error message to the `onSubmit` event handler.
    // - Parameters:
    //   - statusCode: The status code to include in the event.
    //   - data: The data to include in the event.
    //   - errorMessage: The error message to include in the event.
  @objc private func sendEvent(statusCode: Int, data: [String: Any]?, errorMessage: String?) {
      onSubmit?([
          "statusCode": statusCode,
          "data": data ?? NSNull(),
          "error": errorMessage ?? NSNull(),
      ])
  }
    
    // Handles the tap event of the submit button.
  @objc private func submitButtonTapped() {

      print("triggers submit button tapped")
    
    let routingNumberPattern = "^[0-9]{9}$"
    
    let accountNumberPattern = "^[0-9]+$"


    // Validate fields
    var hasError = false
    if routingNumber.isEmpty || !matches(routingNumberPattern, in: routingNumber) {
        routingNumberField.setError(message: "Please enter a valid number")
        hasError = true
    } else {
        routingNumberField.setError(message: nil)
    }

    if accountNumber.isEmpty || !matches(accountNumberPattern, in: accountNumber) {
        accountNumberField.setError(message: "Please enter a valid number")
        hasError = true
    } else {
        accountNumberField.setError(message: nil)
    }

    if hasError {
        return
    }
    
    
    //Add the Body
    
      let bankAccount: [String: Any] = [
          "account_owner_name": "John Doe",
          "routing_number": routingNumber,
          "account_number": accountNumber,
          "account_type": "checking",
          "account_owner_type": "individual",
          "country": "US",
          "currency": "usd"
      ]

      let body: [String: Any] = [
          "payment_method": [
              "bank_account": bankAccount,
          ]
      ]
    
    APIManager.createPaymentMethod(body: body) { result in
        switch result {
        case .success(let data):
            print("Payment method created successfully: \(data)")
            self.sendEvent(statusCode: 201, data: data, errorMessage: nil)
        case .failure(let error):
          if let error = error as NSError? {
              let statusCode = error.code
              let responseJSON = error.userInfo["JSON"] as? String ?? ""
              print("API error with status code: \(statusCode) - \(error.localizedDescription) - Response JSON: \(responseJSON)")
              
              if let responseData = responseJSON.data(using: .utf8),
                 let parsedError = try? JSONSerialization.jsonObject(with: responseData, options: []) as? [String: Any],
                 let errorMessage = parsedError["error"] as? [String: Any],
                 let message = errorMessage["message"] as? String {
                  self.sendEvent(statusCode: statusCode, data: nil, errorMessage: message)
              } else {
                  self.sendEvent(statusCode: statusCode, data: nil, errorMessage: error.localizedDescription)
              }
          } else {
              print("API error: \(error.localizedDescription)")
              self.sendEvent(statusCode: 0, data: nil, errorMessage: error.localizedDescription)
          }

        }
    }

  }



    @objc var formLabel: NSDictionary = [:] {
        didSet {
            routingNumberField.formLabel = formLabel
            accountNumberField.formLabel = formLabel
        }
    }

    @objc var formControl: NSDictionary = [:] {
        didSet {
            routingNumberField.formControl = formControl
            accountNumberField.formControl = formControl
        }
    }

    @objc var errorMessage: NSDictionary = [:] {
        didSet {
            routingNumberField.errorMessage = errorMessage
            accountNumberField.errorMessage = errorMessage
        }
    }
    @objc var layout: NSDictionary = [:] {
        didSet {
            updateLayout()
        }
    }


    override init(frame: CGRect) {
        super.init(frame: frame)
        setupForm()
    }

    required init?(coder: NSCoder) {
        super.init(coder: coder)
        setupForm()
    }

    // Sets up the form view with the necessary components and constraints.
  private func setupForm() {
    
      routingNumberField.textField.addTarget(self, action: #selector(routingNumberFieldChanged), for: .editingChanged)
      accountNumberField.textField.addTarget(self, action: #selector(accountNumberFieldChanged), for: .editingChanged)
    
      routingNumberField.labelText = "Routing Number"
      accountNumberField.labelText = "Account Number"

      routingNumberField.placeholderText = "Enter routing number"
      accountNumberField.placeholderText = "Enter account number"

      stackView.axis = .vertical
      stackView.spacing = 16
      stackView.addArrangedSubview(routingNumberField)
      stackView.addArrangedSubview(accountNumberField)
      stackView.addArrangedSubview(submitButton)
      stackView.distribution = .fillProportionally

      addSubview(stackView)
      stackView.translatesAutoresizingMaskIntoConstraints = false
      
      let heightConstraint = stackView.heightAnchor.constraint(greaterThanOrEqualToConstant: 200)
      heightConstraint.priority = .defaultHigh
      heightConstraint.isActive = true
      
      NSLayoutConstraint.activate([
          stackView.leadingAnchor.constraint(equalTo: leadingAnchor),
          stackView.trailingAnchor.constraint(equalTo: trailingAnchor),
          stackView.topAnchor.constraint(equalTo: topAnchor),
          stackView.bottomAnchor.constraint(equalTo: bottomAnchor)
      ])
    
      submitButton.setTitle("Submit", for: .normal)
      submitButton.addTarget(self, action: #selector(submitButtonTapped), for: .touchUpInside)

  }

    // Handles the change event of the routing number field.
  @objc private func routingNumberFieldChanged(_ textField: UITextField) {
      routingNumber = textField.text ?? ""
  }
    // Handles the change event of the account number field.
  @objc private func accountNumberFieldChanged(_ textField: UITextField) {
      accountNumber = textField.text ?? ""
  }

    // Updates the layout of the form view based on the specified layout properties.
  private func updateLayout() {
    if let padding = layout["padding"] as? CGFloat {
      stackView.layoutMargins = UIEdgeInsets(top: padding, left: padding, bottom: padding, right: padding)
      stackView.isLayoutMarginsRelativeArrangement = true
    }

    if let formControlSpacingVertical = layout["formControlSpacingVertical"] as? CGFloat {
      stackView.spacing = formControlSpacingVertical
    }
  }

}

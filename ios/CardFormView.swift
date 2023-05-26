import UIKit

@objc(CardFormView)
class CardFormView: UIView {
    fileprivate let cardNumberField = FieldView()
    fileprivate let verificationField = FieldView()
    fileprivate let monthField = FieldView()
    fileprivate let yearField = FieldView()
    fileprivate let stackView = UIStackView()
    fileprivate let submitButton = UIButton(type: .system)
    fileprivate var cardNumber = ""
    fileprivate var verification = ""
    fileprivate var month = ""
    fileprivate var year = ""

    @objc var onSubmit: RCTBubblingEventBlock?

    let cardNumberPattern = "^[0-9]{13,16}$"
    let monthPattern = "^(0[1-9]|1[0-2])$"
    let yearPattern = "^\\d{2}$"
    let verificationPattern = "^[0-9]{3,4}$"

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
      print("Triggers submit button tapped")

      // Validate fields
      var hasError = false
 

      if cardNumber.isEmpty || !matches(cardNumberPattern, in: cardNumber) {
          cardNumberField.setError(message: "Please enter a valid card number")
          hasError = true
      } else {
          cardNumberField.setError(message: nil)
      }

      if verification.isEmpty || !matches(verificationPattern, in: verification) {
          verificationField.setError(message: "Please enter a valid verification number")
          hasError = true
      } else {
          verificationField.setError(message: nil)
      }

      if month.isEmpty || !matches(monthPattern, in: month) {
          monthField.setError(message: "Please enter a valid month")
          hasError = true
      } else {
          monthField.setError(message: nil)
      }

      if year.isEmpty || !matches(yearPattern, in: year) {
          yearField.setError(message: "Please enter a valid year")
          hasError = true
      } else {
          yearField.setError(message: nil)
      }

      if hasError {
          return
      }

      // Add the Body
      let card: [String: Any] = [
          "name": "Swift Test",
          "number": cardNumber,
          "verification": verification,
          "month": month,
          "year": year,
          "address_postal_code": 55555
      ]

      let body: [String: Any] = [
          "payment_method": [
              "card": card
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
          cardNumberField.formLabel = formLabel
          verificationField.formLabel = formLabel
          monthField.formLabel = formLabel
          yearField.formLabel = formLabel
      }
  }

  @objc var formControl: NSDictionary = [:] {
      didSet {
          cardNumberField.formControl = formControl
          verificationField.formControl = formControl
          monthField.formControl = formControl
          yearField.formControl = formControl
      }
  }

  @objc var errorMessage: NSDictionary = [:] {
      didSet {
          cardNumberField.errorMessage = errorMessage
          verificationField.errorMessage = errorMessage
          monthField.errorMessage = errorMessage
          yearField.errorMessage = errorMessage
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
  
    // Handles the tap event of the submit button.
  private func setupForm() {
      cardNumberField.textField.addTarget(self, action: #selector(cardNumberFieldChanged), for: .editingChanged)
      verificationField.textField.addTarget(self, action: #selector(verificationFieldChanged), for: .editingChanged)
      monthField.textField.addTarget(self, action: #selector(monthFieldChanged), for: .editingChanged)
      yearField.textField.addTarget(self, action: #selector(yearFieldChanged), for: .editingChanged)

      cardNumberField.labelText = "Card Number"
      verificationField.labelText = "CVV"
      yearField.labelText = "Expiration"

      cardNumberField.placeholderText = "1234123412341234"
      verificationField.placeholderText = "CVV"
      monthField.placeholderText = "MM"
      yearField.placeholderText = "YY"

    

      stackView.axis = .vertical
      stackView.spacing = 16
      stackView.addArrangedSubview(cardNumberField)
      stackView.addArrangedSubview(yearField)
      stackView.addArrangedSubview(monthField)
      stackView.addArrangedSubview(verificationField)
      stackView.addArrangedSubview(submitButton)
      stackView.distribution = .fillProportionally

      addSubview(stackView)
      stackView.translatesAutoresizingMaskIntoConstraints = false

      let heightConstraint = stackView.heightAnchor.constraint(greaterThanOrEqualToConstant: 200)
      heightConstraint.priority = .defaultHigh
      heightConstraint.isActive = true

      NSLayoutConstraint.activate([
          stackView.leadingAnchor.constraint(equalTo: self.leadingAnchor),
          stackView.trailingAnchor.constraint(equalTo: self.trailingAnchor)
      ])

      submitButton.setTitle("Submit", for: .normal)
      submitButton.addTarget(self, action: #selector(submitButtonTapped), for: .touchUpInside)
  }

    // Handles the change event of the card number field.
  @objc private func cardNumberFieldChanged(_ textField: UITextField) {
      cardNumber = textField.text ?? ""
  }
    // Handles the change event of the verification field.
  @objc private func verificationFieldChanged(_ textField: UITextField) {
      verification = textField.text ?? ""
  }

    // Handles the change event of the month field.
  @objc private func monthFieldChanged(_ textField: UITextField) {
      month = textField.text ?? ""
  }

    // Handles the change event of the year field.
  @objc private func yearFieldChanged(_ textField: UITextField) {
      year = textField.text ?? ""
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


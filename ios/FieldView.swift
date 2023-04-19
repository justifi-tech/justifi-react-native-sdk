import UIKit

@objc(FieldView)
class FieldView: UIView, UITextFieldDelegate {
    private let fieldLabel = UILabel()
    private let textField = UITextField()
    private let errorLabel = UILabel()

    @objc var formLabel: NSDictionary = [:] {
        didSet {
            updateFormLabel()
        }
    }

    @objc var formControl: NSDictionary = [:] {
        didSet {
            updateFormControl()
        }
    }

    @objc var errorMessage: NSDictionary = [:] {
        didSet {
            updateErrorMessage()
        }
    }

    @objc var labelText: String = "" {
        didSet {
            fieldLabel.text = labelText
        }
    }

    @objc var placeholderText: String = "" {
        didSet {
            textField.placeholder = placeholderText
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
  
  private func updateFormLabel() {
      applyLabelStyle(to: fieldLabel)
  }

  private func updateFormControl() {
      applyTextFieldStyle(to: textField)
  }

  private func updateErrorMessage() {
      if let message = errorMessage["message"] as? String {
          errorLabel.text = message
      }
      if let color = errorMessage["color"] as? String {
          errorLabel.textColor = colorWithHexString(hexString: color)
      }
  }
  
  func colorWithHexString(hexString: String, alpha: CGFloat = 1.0) -> UIColor {
      var cString: String = hexString.trimmingCharacters(in: .whitespacesAndNewlines).uppercased()
      
      if cString.hasPrefix("#") {
          cString.remove(at: cString.startIndex)
      }
      
      if (cString.count) != 6 {
          return UIColor.gray
      }
      
      var rgbValue: UInt64 = 0
      Scanner(string: cString).scanHexInt64(&rgbValue)
      
      return UIColor(
          red: CGFloat((rgbValue & 0xFF0000) >> 16) / 255.0,
          green: CGFloat((rgbValue & 0x00FF00) >> 8) / 255.0,
          blue: CGFloat(rgbValue & 0x0000FF) / 255.0,
          alpha: alpha
      )
  }
  
  private func applyLabelStyle(to label: UILabel) {
    var font: UIFont = label.font
    
    if let fontWeight = formLabel["fontWeight"] as? String {
        font = UIFont.systemFont(ofSize: label.font.pointSize, weight: fontweight(from: fontWeight))
    }

    if let fontFamily = formLabel["fontFamily"] as? String {
        font = UIFont(name: fontFamily, size: label.font.pointSize) ?? font
    }

    label.font = font

  }
  
  private func applyTextFieldStyle(to textField: UITextField) {
      print("formControl:", formControl)
    
    if let fontWeight = formControl["fontWeight"] as? String {
            textField.font = UIFont.systemFont(ofSize: textField.font?.pointSize ?? 16.0, weight: fontweight(from: fontWeight))
        }
    
      textField.textColor = colorWithHexString(hexString: formControl["color"] as? String ?? "#000000")
      textField.backgroundColor = colorWithHexString(hexString: formControl["backgroundColor"] as? String ?? "#FFFFFF")
      textField.layer.borderColor = colorWithHexString(hexString: formControl["borderColor"] as? String ?? "#CCCCCC").cgColor
      textField.layer.borderWidth = formControl["borderWidth"] as? CGFloat ?? 1.0
      textField.layer.cornerRadius = (formControl["borderRadius"] as? NSDictionary)?["topLeft"] as? CGFloat ?? 5.0
      textField.leftView = UIView(frame: CGRect(x: 0, y: 0, width: 8, height: textField.frame.height))
      textField.leftViewMode = .always

      let lineHeight = formControl["lineHeight"] as? CGFloat ?? 2.0
      let fontSize = formControl["fontSize"] as? CGFloat ?? 16.0
      textField.heightAnchor.constraint(equalToConstant: lineHeight * fontSize).isActive = true
  }
  
  func textFieldDidBeginEditing(_ textField: UITextField) {
      if let borderColorFocus = formControl["borderColorFocus"] as? String {
          textField.layer.borderColor = colorWithHexString(hexString: borderColorFocus).cgColor
      }
  }

  func textFieldDidEndEditing(_ textField: UITextField) {
      if let borderColor = formControl["borderColor"] as? String {
          textField.layer.borderColor = colorWithHexString(hexString: borderColor).cgColor
      }
  }
  
  private func fontweight(from string: String) -> UIFont.Weight {
      switch string {
      case "100":
          return .ultraLight
      case "200":
          return .thin
      case "300":
          return .light
      case "400":
          return .regular
      case "500":
          return .medium
      case "600":
          return .semibold
      case "700":
          return .bold
      case "800":
          return .heavy
      case "900":
          return .black
      default:
          return .regular
      }
  }


    private func setupForm() {
        applyLabelStyle(to: fieldLabel)

        textField.placeholder = placeholderText
        applyTextFieldStyle(to: textField)

        textField.delegate = self

        let fieldContainer = UIStackView()
        fieldContainer.axis = .vertical
        fieldContainer.spacing = 0
        fieldContainer.addArrangedSubview(fieldLabel)
        fieldContainer.addArrangedSubview(textField)
        fieldContainer.heightAnchor.constraint(greaterThanOrEqualToConstant: 50).isActive = true

        fieldLabel.bottomAnchor.constraint(equalTo: textField.topAnchor, constant: -10).isActive = true

        errorLabel.text = "Invalid value"
        errorLabel.textColor = .red
        errorLabel.font = UIFont.systemFont(ofSize: 10)

        let errorSpacer = UIView()

        fieldContainer.addArrangedSubview(errorSpacer)
        fieldContainer.addArrangedSubview(errorLabel)

        if let margin = formLabel["margin"] as? NSDictionary, let bottom = margin["bottom"] as? CGFloat {
            errorSpacer.heightAnchor.constraint(equalToConstant: bottom).isActive = true
        }

        addSubview(fieldContainer)
        fieldContainer.translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            fieldContainer.leadingAnchor.constraint(equalTo: leadingAnchor),
            fieldContainer.trailingAnchor.constraint(equalTo: trailingAnchor),
            fieldContainer.topAnchor.constraint(equalTo: topAnchor),
            fieldContainer.bottomAnchor.constraint(equalTo: bottomAnchor)
        ])
    }

}

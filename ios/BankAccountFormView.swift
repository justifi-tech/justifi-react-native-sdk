import UIKit

extension NSLayoutConstraint {
  @discardableResult func with(priority: UILayoutPriority) -> NSLayoutConstraint {
    self.priority = priority
    return self
  }
}

@objc(BankAccountFormView)
class BankAccountFormView: UIView {
  fileprivate let routingNumberField = FieldView()
  fileprivate let accountNumberField = FieldView()
  fileprivate let stackView = UIStackView()
  

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

  private func setupForm() {
    
    
      routingNumberField.labelText = "Routing Number"
      accountNumberField.labelText = "Account Number"

      routingNumberField.placeholderText = "Enter routing number"
      accountNumberField.placeholderText = "Enter account number"

      stackView.axis = .vertical
      stackView.spacing = 16
      stackView.addArrangedSubview(routingNumberField)
      stackView.addArrangedSubview(accountNumberField)
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
  }
  
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

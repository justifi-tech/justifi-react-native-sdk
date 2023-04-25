import UIKit
import Foundation

@objc(BankAccountFormView)
class BankAccountFormView: UIView {
    private let routingNumberTextField = UITextField()
    private let accountNumberTextField = UITextField()
    private let stackView = UIStackView()



    override init(frame: CGRect) {
        super.init(frame: frame)
        setupForm()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        setupForm()
    }

    private func setupForm() {
        routingNumberTextField.placeholder = "Routing Number"
        applyTextFieldStyle(to: routingNumberTextField)

        accountNumberTextField.placeholder = "Account Number"
        applyTextFieldStyle(to: accountNumberTextField)

        stackView.axis = .vertical
        stackView.spacing = 16
        stackView.addArrangedSubview(routingNumberTextField)
        stackView.addArrangedSubview(accountNumberTextField)

        addSubview(stackView)
        stackView.translatesAutoresizingMaskIntoConstraints = false
        NSLayoutConstraint.activate([
            stackView.leadingAnchor.constraint(equalTo: leadingAnchor),
            stackView.trailingAnchor.constraint(equalTo: trailingAnchor),
            stackView.topAnchor.constraint(equalTo: topAnchor),
            stackView.bottomAnchor.constraint(equalTo: bottomAnchor)
        ])
    }

    private func applyTextFieldStyle(to textField: UITextField) {
        textField.backgroundColor = .white
        textField.layer.borderColor = UIColor.gray.cgColor
        textField.layer.borderWidth = 1.0
        textField.layer.cornerRadius = 5.0
        textField.leftView = UIView(frame: CGRect(x: 0, y: 0, width: 8, height: textField.frame.height))
        textField.leftViewMode = .always
    }

    @objc static func requiresMainQueueSetup() -> Bool { return true }

}


import Foundation

@objc(FieldViewManager)
class FieldViewManager: RCTViewManager {
    override func view() -> UIView! {
        return FieldView()
    }
  
    override class func requiresMainQueueSetup() -> Bool {
    return false
    }

    @objc func setFormLabel(_ node: NSNumber, formLabel: NSDictionary) {
        DispatchQueue.main.async { [weak self] in
            if let field = self?.bridge.uiManager.view(forReactTag: node) as? FieldView {
                field.formLabel = formLabel
            }
        }
    }

    @objc func setFormControl(_ node: NSNumber, formControl: NSDictionary) {
        DispatchQueue.main.async { [weak self] in
            if let field = self?.bridge.uiManager.view(forReactTag: node) as? FieldView {
                field.formControl = formControl
            }
        }
    }

    @objc func setErrorMessage(_ node: NSNumber, errorMessage: NSDictionary) {
        DispatchQueue.main.async { [weak self] in
            if let field = self?.bridge.uiManager.view(forReactTag: node) as? FieldView {
                field.errorMessage = errorMessage
            }
        }
    }
}

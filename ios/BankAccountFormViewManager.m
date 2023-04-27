#import "React/RCTBridgeModule.h"
#import "React/RCTViewManager.h"

@interface RCT_EXTERN_MODULE(BankAccountFormViewManager, RCTViewManager)
RCT_EXPORT_VIEW_PROPERTY(formLabel, NSDictionary)
RCT_EXPORT_VIEW_PROPERTY(formControl, NSDictionary)
RCT_EXPORT_VIEW_PROPERTY(errorMessage, NSDictionary)
RCT_EXPORT_VIEW_PROPERTY(layout, NSDictionary)
@end

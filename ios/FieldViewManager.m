#import <Foundation/Foundation.h>
#import <React/RCTViewManager.h>

@interface RCT_EXTERN_MODULE(FieldViewManager, RCTViewManager)

RCT_EXPORT_VIEW_PROPERTY(labelText, NSString)
RCT_EXPORT_VIEW_PROPERTY(placeholderText, NSString)
RCT_EXPORT_VIEW_PROPERTY(formLabel, NSDictionary)
RCT_EXPORT_VIEW_PROPERTY(formControl, NSDictionary)
RCT_EXPORT_VIEW_PROPERTY(errorMessage, NSDictionary)

@end

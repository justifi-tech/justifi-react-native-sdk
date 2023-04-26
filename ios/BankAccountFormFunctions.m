#import "React/RCTBridgeModule.h"

@interface RCT_EXTERN_MODULE(BankAccountFormFunctions, NSObject)

RCT_EXTERN_METHOD(validate:(RCTResponseSenderBlock)callback)
RCT_EXTERN_METHOD(tokenize:(RCTResponseSenderBlock)callback)

@end

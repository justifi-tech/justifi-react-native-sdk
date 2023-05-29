#import <React/RCTBridgeModule.h>

@interface RCT_EXTERN_MODULE(ProviderModule, NSObject)
RCT_EXTERN_METHOD(initialise:(NSString *)clientId account:(NSString *)account callback:(RCTResponseSenderBlock)callback)
@end

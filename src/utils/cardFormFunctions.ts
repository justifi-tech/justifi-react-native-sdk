import { NativeModules } from 'react-native';

const { UtilsModule } = NativeModules;

export async function validate(): Promise<boolean> {
  return new Promise((resolve) => {
    UtilsModule.validate((isValid: boolean) => {
      resolve(isValid);
    });
  });
}

export async function tokenize(paymentMethodMetadata: string): Promise<string> {
  return new Promise((resolve) => {
    UtilsModule.tokenize(paymentMethodMetadata, (token: string) => {
      resolve(token);
    });
  });
}

import { NativeModules } from 'react-native';

const { CardFormView } = NativeModules;

export async function validate(): Promise<boolean> {
  return new Promise((resolve) => {
    CardFormView.validate((isValid: boolean) => {
      resolve(isValid);
    });
  });
}

export async function tokenize(
  clientId: string,
  paymentMethodMetadata: string,
  account: string,
): Promise<string> {
  return new Promise((resolve) => {
    CardFormView.tokenize(
      clientId,
      paymentMethodMetadata,
      account,
      (token: string) => {
        resolve(token);
      },
    );
  });
}

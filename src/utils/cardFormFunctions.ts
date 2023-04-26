import { NativeModules } from 'react-native';

const { CardFormView } = NativeModules;

export function validate(): boolean {
  return CardFormView.validate();
}

export async function tokenize(
  clientId: string,
  paymentMethodMetadata: string,
  account: string,
): Promise<any> {
  return CardFormView.tokenize(clientId, paymentMethodMetadata, account);
}

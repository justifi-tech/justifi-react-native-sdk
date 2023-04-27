import { NativeModules } from 'react-native';
import type { BankAccountFormView } from '../types';

const { BankAccountFormFunctions } = NativeModules;

export async function validate(): Promise<boolean> {
  return new Promise(resolve => {
    BankAccountFormFunctions.validate((isValid: boolean) => {
      resolve(isValid);
    });
  });
}

export async function tokenize(): Promise<BankAccountFormView.Token> {
  return new Promise(resolve => {
    BankAccountFormFunctions.tokenize((token: BankAccountFormView.Token) => {
      resolve(token);
    });
  });
}

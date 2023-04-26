import {NativeModules} from 'react-native';

const {BankAccountFormFunctions} = NativeModules;

export async function validate(): Promise<boolean> {
  return new Promise(resolve => {
    BankAccountFormFunctions.validate((isValid: boolean) => {
      resolve(isValid);
    });
  });
}

export async function tokenize(): Promise<any> {
  return new Promise(resolve => {
    BankAccountFormFunctions.tokenize((token: any) => {
      resolve(token);
    });
  });
}

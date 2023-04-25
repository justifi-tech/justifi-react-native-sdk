export { BankAccountForm } from './components/BankAccountForm';

export { validate, tokenize } from './utils/bankAccountFormFunctions';

export * from './types/index';

export function multiply(a: number, b: number): Promise<number> {
  return Promise.resolve(a * b);
}

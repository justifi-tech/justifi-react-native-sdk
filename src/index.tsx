// dummy function for testing
export function multiply(a: number, b: number): Promise<number> {
  return Promise.resolve(a * b);
}

export { BankAccountForm } from './components/BankAccountForm';
export { CardForm } from './components/CardForm';

export { validate, tokenize } from './utils/bankAccountFormFunctions';
export {
  validate as validateCard,
  tokenize as tokenizeCard,
} from './utils/cardFormFunctions';

export * from './types/index';

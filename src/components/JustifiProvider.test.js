import { InitJutifiParams } from '../types';
import 'jest-extended';

describe('JustifiProvider', () => {
  it('should have "clientId" and "account" fields as string', () => {
    const myObj: InitJutifiParams = {
      clientId: 'clientId value',
      account: 'account value',
    };
    expect(myObj).toHaveProperty('clientId', expect.any(String));
    expect(myObj).toHaveProperty('account', expect.any(String));
  });
});

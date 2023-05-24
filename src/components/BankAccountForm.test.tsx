import React from 'react';
import { render } from '@testing-library/react-native';
import { BankAccountForm } from './BankAccountForm';

describe('BankAccountForm', () => {
  const onCloseMock = jest.fn();
  const onSubmitMock = jest.fn();

  beforeEach(() => {
    onCloseMock.mockClear();
    onSubmitMock.mockClear();
  });

  it('renders correctly when open is true', () => {
    const { getByTestId } = render(
      <BankAccountForm
        open={true}
        onClose={onCloseMock}
        onSubmit={onSubmitMock}
      />
    );

    const bankAccountForm = getByTestId('bank-account-form');
    // Add assertions for the rendered component
    expect(bankAccountForm).toBeDefined();
  });
});

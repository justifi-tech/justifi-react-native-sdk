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
    expect(bankAccountForm).toBeDefined();
  });

  it('renders correctly when open is false', () => {
    const { getByTestId } = render(
      <BankAccountForm
        open={false}
        onClose={onCloseMock}
        onSubmit={onSubmitMock}
      />
    );

    const bankAccountForm = getByTestId('bank-account-form');
    expect(bankAccountForm).toBeDefined();
  });

  it('should render within a specific time limit', () => {
    // Set the desired time limit for rendering
    const timeLimit = 100; // in milliseconds
    // Start the timer
    const startTime = performance.now();
    // Render the component
    render(
      <BankAccountForm
        open={true}
        onClose={onCloseMock}
        onSubmit={onSubmitMock}
      />
    );
    // Calculate the rendering time
    const renderingTime = performance.now() - startTime;
    // Check if the rendering time is within the time limit
    expect(renderingTime).toBeLessThan(timeLimit);
  });

  it('renders correctly on Android', () => {
    jest.mock('react-native', () => {
      const RN = jest.requireActual('react-native');
      RN.Platform.OS = 'android';
      return RN;
    });
  
    const { getByTestId } = render(
      <BankAccountForm
        open={true}
        onClose={onCloseMock}
        onSubmit={onSubmitMock}
      />
    );
  
    const bankAccountForm = getByTestId('bank-account-form');
    expect(bankAccountForm).toBeDefined();
  });

  it('renders correctly on iOS', () => {
    jest.mock('react-native', () => {
      const RN = jest.requireActual('react-native');
      RN.Platform.OS = 'ios';
      return RN;
    });
  
    const { getByTestId } = render(
      <BankAccountForm
        open={true}
        onClose={onCloseMock}
        onSubmit={onSubmitMock}
      />
    );
  
    const bankAccountForm = getByTestId('bank-account-form');
    expect(bankAccountForm).toBeDefined();
  });  
  
});

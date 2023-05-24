import React from 'react';
import { render } from '@testing-library/react-native';
import { CardForm } from './CardForm';

describe('CardForm', () => {
  const onCloseMock = jest.fn();
  const onSubmitMock = jest.fn();

  beforeEach(() => {
    onCloseMock.mockClear();
    onSubmitMock.mockClear();
  });

  it('renders correctly when open is true', () => {
    const { getByTestId } = render(
      <CardForm open={true} onClose={onCloseMock} onSubmit={onSubmitMock} />
    );

    const cardForm = getByTestId('card-form');
    // Add assertions for the rendered component
    expect(cardForm).toBeDefined();
  });
});

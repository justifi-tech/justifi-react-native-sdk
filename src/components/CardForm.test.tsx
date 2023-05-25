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
    expect(cardForm).toBeDefined();
  });

  it('renders correctly when open is false', () => {
    const { queryByTestId } = render(
      <CardForm open={false} onClose={onCloseMock} onSubmit={onSubmitMock} />
    );

    const cardForm = queryByTestId('card-form');
    expect(cardForm).toBeDefined();
  });
});

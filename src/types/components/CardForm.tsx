import { StyleProp, ViewStyle, requireNativeComponent } from 'react-native';
import React from 'react';
import type { CardFormNativeProps } from '../../types/components/CardForm';

const CardFormNative = requireNativeComponent<CardFormNativeProps>('CardFormView');

/**
 * Props for the `CardForm`.
 */
export interface CardFormProps extends CardFormNativeProps {
  /**
   * Additional styles or styles to override default style
   */
  style?: StyleProp<ViewStyle>;
  /**
   * Overrides for the styles of the underlying native components
   */
  styleOverrides?: string;
  /**
   * The validation strategy to use for card input fields
   */
  validationStrategy?: string;
}

/**
 * A component for rendering a card form.
 */
export const CardForm: React.FC<CardFormProps> = (props) => {
  return <CardFormNative {...props} />;
};

import {
  AccessibilityProps,
  requireNativeComponent,
  StyleProp,
  ViewStyle,
} from 'react-native';
import type { BankAccountFormView } from '../../types/components/BankAccountForm';

import React, { forwardRef } from 'react';

const BankAccountFormNative: any = requireNativeComponent(
  'BankAccountFormView',
);

/**
 * Props for the `BankAccountForm`.
 */
export interface BankAccountFormProps extends AccessibilityProps {
  /**
   * Additional styles or styles to override default style
   */
  style?: StyleProp<ViewStyle>;
  /**
   * Overrides for the styles of the underlying native components
   */
  styleOverrides?: Record<string, unknown>;
}

/**
 * State for the `BankAccountForm`.
 */
export interface BankAccountFormState {
  // Define state types here, if any
}

/**
 * A component for rendering a bank account form.
 */
export const BankAccountForm = forwardRef<BankAccountFormView.Styles, BankAccountFormProps>(
  function BankAccountForm(props: BankAccountFormProps, ref: React.Ref<BankAccountFormView.Styles>) {
    const styleOverrides = { ...props.styleOverrides };

    return (
      <BankAccountFormNative
        {...props}
        {...(styleOverrides ? styleOverrides : null)}
        ref={ref}
      />
    );
  },
);

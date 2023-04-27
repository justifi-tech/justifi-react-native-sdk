import {
  AccessibilityProps,
  requireNativeComponent,
  StyleProp,
  ViewStyle,
} from 'react-native';
import type { BankAccountFormView } from '../types';
import React, { forwardRef } from 'react';

const BankAccountFormNative: any = requireNativeComponent(
  'BankAccountFormView',
);

export interface BankAccountFormProps extends AccessibilityProps {
  style?: StyleProp<ViewStyle>;
  styleOverrides?: object;
}

export interface BankAccountFormState {
  // Define state types here, if any
}

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

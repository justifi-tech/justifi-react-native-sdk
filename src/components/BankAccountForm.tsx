import {
  AccessibilityProps,
  requireNativeComponent,
  StyleProp,
  ViewStyle,
} from 'react-native';
// import type { BankAccountFormView } from '../types';
import React, { forwardRef } from 'react';

const BankAccountFormNative: any = requireNativeComponent(
  'BankAccountFormView',
);

export interface Props extends AccessibilityProps {
  style?: StyleProp<ViewStyle>;
  styleOverrides?: object;
}

export const BankAccountForm = forwardRef<any, Props>((props, ref) => {
  const styleOverrides = { ...props.styleOverrides };

  return (
    <BankAccountFormNative
      {...props}
      {...(styleOverrides ? styleOverrides : null)}
      ref={ref}
    />
  );
});

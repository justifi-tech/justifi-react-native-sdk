import {
  AccessibilityProps,
  requireNativeComponent,
  StyleProp,
  ViewStyle,
} from 'react-native';
import type { BankAccountFormView } from '../types';
import React, { forwardRef } from 'react';

const BankAccountFormNative =
  requireNativeComponent<BankAccountFormView.NativeProps>(
    'BankAccountFormView',
  );

/**
 *  Bank Account Form Component Props
 */
export interface Props extends AccessibilityProps {
  style?: StyleProp<ViewStyle>;
}

//TODO: add @example

export const BankAccountForm = forwardRef<Props>(({ props, ref }: any) => {
  return <BankAccountFormNative {...props} ref={ref} />;
});

import {
  AccessibilityProps,
  requireNativeComponent,
  StyleProp,
  ViewStyle,
} from 'react-native';
import type { CardFormView } from '../types';
import React, { forwardRef } from 'react';

const CardFormNative =
  requireNativeComponent<CardFormView.NativeProps>('CardFormView');

/**
 *  Card Form Component Props
 */
export interface Props extends AccessibilityProps {
  style?: StyleProp<ViewStyle>;
}

//TODO: add @example

export const CardForm = forwardRef<Props>(({ props, ref }: any) => {
  return <CardFormNative {...props} ref={ref} />;
});

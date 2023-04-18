import {
  NativeSyntheticEvent,
  StyleProp,
  ViewStyle,
  requireNativeComponent,
} from 'react-native';
import type { CardFormView } from '../types';
import React from 'react';

/**
 *  Card Form Component Props
 */
export interface Props extends CardFormView.NativeProps {
  style?: StyleProp<ViewStyle>;
  styleOverrides?: string;
  validationStrategy?: string;
}

const CardFormNative = requireNativeComponent<Props>('CardFormView');

function handleLoad() {
  // Handle onLoad event
  console.log('handleLoad react');
}

export const CardForm: React.FC<Props> = (props) => {
  return <CardFormNative {...props} />;
};

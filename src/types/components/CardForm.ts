import type { StyleProp, ViewStyle } from 'react-native';

export interface CardFormNativeProps {
  style?: StyleProp<ViewStyle>;
  styleOverrides?: string;
  validationStrategy?: string;
}

export type CardFormProps = CardFormNativeProps;


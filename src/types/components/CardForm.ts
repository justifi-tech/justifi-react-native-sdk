import type { StyleProp, ViewStyle } from 'react-native';

export interface NativeProps {
  style?: StyleProp<ViewStyle>;
  styleOverrides?: string;
  validationStrategy?: string;
}

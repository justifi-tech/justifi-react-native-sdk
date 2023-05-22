import type { StyleProp, ViewStyle } from 'react-native';

export interface CardFormNativeProps {
  style?: StyleProp<ViewStyle>;
  styleOverrides?: object;
  onSubmit?: (event: {
    nativeEvent: { statusCode: number; data: any; error: any };
  }) => void;
}

export type CardFormProps = CardFormNativeProps;


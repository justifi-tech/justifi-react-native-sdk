import type { StyleProp, ViewStyle } from 'react-native';

export interface CardFormNativeProps {
  style?: StyleProp<ViewStyle>;
  styleOverrides?: object;
  onSubmit?: (event: {
    nativeEvent: { statusCode: number; data: any; error: any };
  }) => void;
}

export interface CardFormView {
  // Add any additional props used in CardForm.tsx
  open: boolean;
  onClose: () => void;
}

export type CardFormProps = CardFormNativeProps & CardFormView;
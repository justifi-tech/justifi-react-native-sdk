import type { StyleProp, ViewStyle } from 'react-native/types';

export interface NativeProps {
  style?: StyleProp<ViewStyle>;
  styleOverrides?: object;
  onSubmit?: (event: {
    nativeEvent: { statusCode: number; data: any; error: any };
  }) => void;
}

import type { StyleProp, ViewStyle } from 'react-native';

export interface NativeProps {
  style?: StyleProp<ViewStyle>;
  styleOverrides?: string;
  onSubmitCard?: (event: {
    nativeEvent: { statusCode: number; data: any; error: any };
  }) => void;
}

import type { StyleProp, ViewStyle } from 'react-native';

export interface NativeProps {
  style?: StyleProp<ViewStyle>;
  styleOverrides?: object;
  onSubmitCard?: (event: {
    nativeEvent: { statusCode: number; data: any; error: any };
  }) => void;
}

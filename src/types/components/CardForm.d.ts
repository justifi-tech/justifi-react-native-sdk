import * as React from 'react';
import type { StyleProp, ViewStyle } from 'react-native';

export interface CardFormNativeProps {
  style?: StyleProp<ViewStyle>;
  styleOverrides?: object;
  onSubmit?: (event: {
    nativeEvent: { statusCode: number; data: any; error: any };
  }) => void;
}

export interface Props extends CardFormNativeProps {
  open: boolean;
  onClose: () => void;
}

export class CardFormView extends React.Component<Props> {}

export default CardFormView;

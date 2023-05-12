export interface NativeProps {
  styleOverrides?: object;
  onSubmitCard?: (event: {
    nativeEvent: { statusCode: number; data: any; error: any };
  }) => void;
}

export interface BankAccountFormView extends NativeProps {}

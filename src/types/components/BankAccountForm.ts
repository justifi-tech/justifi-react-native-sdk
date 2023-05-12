export interface BankAccountFormViewProps {
  styleOverrides?: object;
  onSubmitCard?: (event: {
    nativeEvent: { statusCode: number; data: any; error: any };
  }) => void;
}

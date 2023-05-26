import {StyleProp, ViewStyle } from 'react-native';

/**
 * Defines the styles for the BankAccountFormView component.
 */
export interface BankAccountFormView {
  Styles: {
    /**
     * Overrides for the default component styles.
     */
    styleOverrides?: object;
  };

  /**
   * A boolean value indicating whether the component is currently loading data.
   */
  loading: boolean;
  /**
   * An error message to display, if any.
   */
  error: string | null;
  /**
   * A boolean value indicating whether the form was successfully submitted.
   */
  success: boolean;
}

/**
 * Defines the props for the BankAccountForm component.
 */
export interface BankAccountFormProps extends BankAccountFormView {
  /**
   * Styles for the BankAccountForm component.
   */
  style?: StyleProp<ViewStyle>;
  /**
   * Overrides for the default component styles.
   */
  styleOverrides?: object;
}

/**
 * Defines the state for the BankAccountForm component.
 */
export interface BankAccountFormState {
  // Define state types here, if any
}

export interface BankAccountFormView {
  // Define state types here, if any
}

/**
 * Defines the types for the BankAccountForm component and its props.
 * TypeScript users can import these types to ensure type safety in their projects.
 *
 * @example
 * import type { BankAccountFormProps } from './path/to/BankAccountForm.d.ts';
 *
 * const MyComponent = () => {
 *   const myProps: BankAccountFormProps = { ... };
 *   return <BankAccountForm {...myProps} />;
 * }
 */

// eslint-disable-next-line @typescript-eslint/no-empty-interface
interface MyInterface {}

import React from 'react';
import { AccessibilityProps, StyleProp, ViewStyle } from 'react-native';

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
}

/**
 * Defines the props for the BankAccountForm component.
 */
export interface BankAccountFormProps extends AccessibilityProps {
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

/**
 * The BankAccountForm component renders a form for entering bank account information.
 * 
 * @example
 * <BankAccountForm {...props} />
 */
export class BankAccountForm extends React.Component<BankAccountFormProps, BankAccountFormState> {}

/**
 * Defines the view for the BankAccountForm component.
 */
export interface BankAccountFormView {
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

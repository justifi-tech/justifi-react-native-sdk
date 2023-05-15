/**
 * Defines the types for the CardFormView component and its props.
 * TypeScript users can import these types to ensure type safety in their projects.
 *
 * @example
 * import type { CardFormViewProps } from './path/to/CardForm.d.ts';
 *
 * const MyComponent = () => {
 *   const myProps: CardFormViewProps = { ... };
 *   return <CardFormView {...myProps} />;
 * }
 */
import type { StyleProp, ViewStyle } from 'react-native';

declare module 'react-native' {
  export interface NativeSyntheticEvent<T> {
    target: number;
    currentTarget: number;
  }
}

export interface NativeProps {
  style?: StyleProp<ViewStyle>;
  styleOverrides?: string;
  validationStrategy?: string;
}

export interface CardFormViewProps extends NativeProps {
  /**
   * Event handler for when the form is submitted.
   */
  onCardFormSubmit?: (event: NativeSyntheticEvent<any>) => void;
  /**
   * Event handler for when a form field value is changed.
   */
  onFormFieldChange?: (event: NativeSyntheticEvent<any>) => void;
}

export class CardFormView extends React.Component<CardFormViewProps> {}

export default CardFormView;

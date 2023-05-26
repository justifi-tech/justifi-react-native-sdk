### Justifi-react-Native SDK allows you to easily integrate payment functionality into your mobile application. The SDK provides the following features:

### Prebuilt Payment Component - UI System
This SDK provides a prebuilt UI system that allows you to easily show a bottom sheet modal with all the necessary data to collect credit/debit card and bank account information from your users, a great solution if you want to quickly integrate payment functionality into your app without having to build your own UI.

### Component System to Customize UI
In addition to the prebuilt payment component, this SDK also provides a component system that allows you to customize the payment UI to match your app's look and feel. This means you can create your own payment components and styles to adapt the payment process to your app's branding.

### Payment Methods
It supports multiple payment methods, including credit/debit cards and bank accounts.
Also, the SDK supports tokenization and validation of credit/debit cards and bank accounts, making it easy for you to securely collect payment information from your users as well as bank transfers.

### Create a Payment - API Call
Once you've collected payment information from your users, our SDK provides an easy-to-use API for creating payments. This API allows you to securely submit payment information to our payment endpoints and receive a response indicating whether the payment was successful or not.

We hope you find our Payment Integration SDK helpful in adding payment functionality to your mobile app. If you have any questions or feedback, please don't hesitate to reach out to our support team.

# Table of Contents

- [Getting Started](#getting-started)
- [Installation](#installation)
- [Usage](#usage)
- [Examples](#examples)
- [Documentation](#documentation)
- [Contributing](#contributing)
- [License](#license)

# Getting Started

Follow these steps to get started with the Justifi-react-Native SDK:

### Prerequisites
- Node.js: Make sure you have Node.js installed on your machine. You can download it from the official [Node.js website](https://nodejs.org/en).

```sh
npm install justifi-react-native-sdk
```



# Installation
To install the Justifi-react-Native SDK in your project, you can use npm or yarn. Make sure you have Node.js installed.

#### npm
```bash
npm install justifi-react-native-sdk@0.1.0
```

#### yarn
``` yarn
yarn add justifi-react-native-sdk@0.1.0
```

### Dependencies
- React Native: 0.71.4
- React: 18.2.0
- TypeScript: 4.5.2

These dependencies are required for the Justifi-react-Native SDK to function properly. If you already have these dependencies installed, you can proceed with installing the SDK.



# Usage

To use the Justifi-react-Native SDK in your React Native application, follow these steps:

1. Import the SDK module into your JavaScript file:
```js
  import {
    BankAccountFormView,
    CardFormView,
    JustifiProvider,
  } from 'justifi-react-native-sdk';
```

2. Perform actions using and customizing the SDK:
``` Typescript
  <JustifiProvider
    clientId="_clientId"
    account="_account"
    >
     
    <BankAccountFormView
                style={styles.view}
                styleOverrides={styleOverrides}
                open={openBank}
                onClose={() => {
                  setOpenBank(false);
                }}
                onSubmit={({ nativeEvent }) => {
                  const { statusCode, data, error } = nativeEvent;

                  if (statusCode === 201) {
                    console.log('Payment method created successfully:', data);
                  } else {
                    console.log(`Error with status code ${statusCode}: ${error ?? ''}`
                    );
                  }
                }}
              />
   </JustifiProvider>
```

3. Explore the available methods and functionalities provided by the SDK by referring to the [Documentation](#documentation).



# Examples

To help you get started with the Justifi React Native SDK, we provide the following usage examples. Each example demonstrates a specific use case and showcases the library's features. Follow the step-by-step instructions to integrate and utilize the SDK in your React Native projects.

### Example 1: Collecting Bank Account and Card Payment Information
  This example demonstrates how to collect bank account and card payment information from users using the Justifi React Native SDK. It showcases the integration with our secure payment processing system and highlights the key steps involved in handling payment submissions. By following this example, you will be able to enable seamless payment processing within your app.

**Step-by-step guide:**
1. Install the Justifi React Native SDK using the provided installation instructions in the [Installation](#installation) section.
2. Import the necessary components and modules from the SDK into your React Native project.
3. Initialize the SDK with your API credentials and configure any required settings.
4. Display a payment form in your app's UI, using the SDK's components and UI customization options.
5. Implement the necessary event handlers and submission logic to handle user payment submissions securely.
6. Test the payment flow within your app and verify the successful collection of bank account and card payment information.
By following this example, you will be able to leverage the power of the Justifi React Native SDK to streamline payment collection processes in your app, providing a seamless user experience.

### Example 2: Customizing the UI
  In this example, you will learn how to customize the user interface of the Justifi React Native SDK to match your app's branding and visual style. By utilizing the provided UI customization options, you can create a cohesive and consistent user experience within your app.

**Step-by-step guide:**
1. Follow the [Installation](#installation) instructions provided in the Installation section to set up the Justifi React Native SDK in your project.
2. Import the necessary components and modules from the SDK into your React Native project.
3. Use the provided UI customization options to modify the appearance of the payment form and related UI elements.
4. Apply your app's color scheme, typography, and branding guidelines to the SDK's UI components.
5. Preview the customized UI within your app and ensure that it aligns with your desired visual style.
By following this example, you will be able to seamlessly integrate the Justifi React Native SDK into your app's existing design language, creating a cohesive and branded payment experience for your users.

Please note that these examples provide a starting point, and you can further explore the SDK's configuration options and customization hooks to adapt it to your specific requirements. 
For more detailed information on customization and advanced usage, refer to the [Documentation](#documentation) section.

### BankAccountForm Example
  The following example demonstrates the usage of the `BankAccountForm` component to collect bank account information:

```javascript
  import React from 'react';
  import { BankAccountForm } from 'justifi-react-native-sdk';

  const MyBankAccountForm = () => {
    const handleBankAccountSubmit = (event) => {
      // Handle the submitted bank account data
      const { statusCode, data, error } = event.nativeEvent;
      console.log('Bank Account Submission:', { statusCode, data, error });
      // Perform further actions or validations
      // ...
    };

    return (
      <div>
        <h3>Bank Account Information</h3>
        <BankAccountForm open={true} onClose={() => {}} onSubmit={handleBankAccountSubmit} />
      </div>
    );
  };

  export default MyBankAccountForm;
```
In this example, we create a **`MyBankAccountForm`** component that includes the **`BankAccountForm`** component. We pass the necessary props such as **`open`**, **`onClose`**, and **`onSubmit`**.
The **`onSubmit`** function receives an event object with the submitted bank account data, allowing you to handle the submission accordingly.


### CardForm Example
  The following example demonstrates the usage of the **CardForm** component to collect card payment information:

``` Javascript
  import React from 'react';
  import { CardForm } from 'justifi-react-native-sdk';

  const MyCardForm = () => {
    const handleCardSubmit = (event) => {
      // Handle the submitted card data
      const { statusCode, data, error } = event.nativeEvent;
      console.log('Card Submission:', { statusCode, data, error });
      // Perform further actions or validations
      // ...
    };

    return (
      <div>
        <h3>Card Payment</h3>
        <CardForm open={true} onClose={() => {}} onSubmit={handleCardSubmit} />
      </div>
    );
  };

  export default MyCardForm;
```
In this example, we create a **`MyCardForm`** component that includes the **`CardForm`** component. 
Similar to the previous example, we pass the necessary props and handle the **`onSubmit`** event to process the submitted card data.


### JustifiProvider Example
  The following example demonstrates the usage of the **`JustifiProvider`** component as a wrapper around your application:

``` Javascript
  import React from 'react';
  import { JustifiProvider } from 'justifi-react-native-sdk';

  const MyApp = () => {
    const clientId = '_clientId'; // Replace with your actual clientId
    const account = '_account'; // Replace with your actual account

    return (
      <JustifiProvider clientId={clientId} account={account}>
        {/* Your application components */}
      </JustifiProvider>
    );
  };

  export default MyApp;
```
In this example, we create a **`MyApp`** component that wraps your application components with the **`JustifiProvider`**.
The **`JustifiProvider`** initializes the provider with your clientId and **`account`**, enabling the integration of the library's functionality throughout your application.



# Documentation


## BankAccountForm.tsx

This file defines the **BankAccountForm** component, which renders a native view that allows users to input their bank account information.

#### **BankAccountFormProps**
  This interface defines the props for the BankAccountForm component.

``` Typescript
  interface BankAccountFormProps {
    style?: StyleProp<ViewStyle>;
    styleOverrides?: object;
    open: boolean;
    onClose: () => void;
    onSubmit?: (event: {
      nativeEvent: { statusCode: number; data: any; error: any };
    }) => void;
}
```
                        
| Prop Name | Type | Description |
| --- | --- | --- |
| `style` | `object` | Custom styles for the component. |
| `styleOverrides` | `object` | Custom style overrides for specific sub-components. |
| `open` | `boolean` | A boolean value indicating whether the bank account form is open.|
| `onClose` | `function` | A function to be called when the bank account form is closed. |
| `onSubmit` | `function` | A function that will be called when the user submits the bank account form, providing the status code, data, and error in the nativeEvent. |

#### BankAccountForm
  The **BankAccountForm** component is defined as follows:

``` Typescript
  const BankAccountForm: React.FC<BankAccountFormProps> = (props) => {
  const { open, onClose } = props;

  return (
    <View style={styles.flexView} testID="bank-account-form">
      <StatusBar />

      <Modal
        onBackdropPress={onClose}
        onBackButtonPress={onClose}
        isVisible={open}
        swipeDirection="down"
        onSwipeComplete={onClose}
        animationIn="bounceInUp"
        animationOut="bounceOutDown"
        animationInTiming={900}
        animationOutTiming={500}
        backdropTransitionInTiming={1000}
        backdropTransitionOutTiming={500}
        style={styles.modal}
      >
        <View style={styles.modalContent}>
          <View
            style={[styles.center, Platform.OS !== 'ios' ? { flex: 1 } : {}]}
          >
            <View style={styles.barIcon} />

            <BankAccountNative
              {...props}
              {...(Platform.OS === 'ios' ? props.styleOverrides : {})}
            />
          </View>
        </View>
      </Modal>
    </View>
  );
};
```

The **BankAccountForm** component renders a **BankAccountNative** component, which is a native view that allows users to input their bank account information. The component accepts various props such as style, *`styleOverrides`*, **`open`**, *`onClose`*, and *`onSubmit`* to customize its behavior and appearance.


## BankAccountForm.d.ts

Defines the TypeScript types for the BankAccountForm component and its props. TypeScript users can import these types to ensure type safety in their projects.
.

```typescript
  import { StyleProp, ViewStyle } from 'react-native';

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
```
#### **BankAccountFormView**
  Defines the structure and props for the BankAccountFormView component:

| Prop Name | Type | Description |
| --- | --- | --- |
| `Styles.styleOverrides` | `object` | Overrides for the default component styles.|
| `loading` | `boolean` | A boolean value indicating whether the component is currently loading data.|
| `error` | `string - null` | An error message to display, if any.|
| `success` | `boolean` | A boolean value indicating whether the form was successfully submitted.|

#### **BankAccountFormState**
  Defines the state for the BankAccountForm component.

#### **BankAccountFormProps**
  Defines the props for the BankAccountForm component:

| Prop Name | Type | Description |
| --- | --- | --- |
| `style` | `StyleProp<ViewStyle>` | Styles for the BankAccountForm component.|
| `styleOverrides` | `object` | Overrides for the default component styles.|
| `loading` | `boolean` |A boolean value indicating whether the component is currently loading data.|
| `error	` | `string - null` | An error message to display, if any.|
| `success` | `boolean` | A boolean value indicating whether the form was successfully submitted.|

Please make sure to adjust the import paths and file locations as per your project structure.



## CardForm.d.ts

Defines the TypeScript types for the CardForm component and its props. TypeScript users can import these types to ensure type safety in their projects.

```typescript
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
```

### CardFormNativeProps
  Defines the props for the CardForm component:

| Prop Name | Type | Description |
| --- | --- | --- |
| `style` | `StyleProp<ViewStyle>` | Custom styles for the component.|
| `styleOverrides` | `object` | Custom style overrides for specific sub-components of the component.|
| `styleOverrides` | `function` | A function that will be called when the user submits the card form, providing the status code, data, and error in the nativeEvent.|

### Props
  Defines the props for the CardFormView component:

| Prop Name | Type | Description |
| --- | --- | --- |
| `open` | `boolean` | A boolean value indicating whether the card form is open.|
| `onClose` | `function` | A function to be called when the card form is closed.|

### CardFormView
  The CardFormView component renders a form for entering credit/debit card information.

``` Typescript
  export class CardFormView extends React.Component<Props> {}
```

The **CardFormView** component accepts various props such as **`style`**, **`styleOverrides`**, **`open`**, **`onClose`**, and **`onSubmit`** to customize its behavior and appearance.


## CardForm.tsx

This file defines the CardForm component, which renders a native view that allows users to input their credit/debit card information for payment processing.

#### Interfaces
#### **CardFormProps**
  This interface defines the props for the CardForm component.

``` Typescript
    interface Props {
      style?: StyleProp<ViewStyle>;
      styleOverrides?: object;
      open: boolean;
      onClose: () => void;
      onSubmit?: (event: {
        nativeEvent: { statusCode: number; data: any; error: any };
      }) => void;
  }
```

| Prop Name | Type | Description |
| --- | --- | --- |
| `style` | `StyleProp<ViewStyle>` | Custom styles for the component. |
| `styleOverrides` | `object` | Custom style overrides for specific sub-components. |
| `open` | `boolean` | A boolean value indicating whether the card form is open. |
| `onClose` | `function` | A function to be called when the card form is closed. |
| `onSubmit` | `function` | A function that will be called when the user submits the card form. |

#### **CardForm** 
  The **CardForm** component is defined as follows:

``` Typescript
export const CardForm: React.FC<Props> = (props) => {
  const { open, onClose } = props;

  return (
    <View style={styles.flexView} testID="card-form">
      <StatusBar />

      <Modal
        onBackdropPress={onClose}
        onBackButtonPress={onClose}
        isVisible={open}
        swipeDirection="down"
        onSwipeComplete={onClose}
        animationIn="bounceInUp"
        animationOut="bounceOutDown"
        animationInTiming={900}
        animationOutTiming={500}
        backdropTransitionInTiming={1000}
        backdropTransitionOutTiming={500}
        style={styles.modal}
        accessibilityLabel="modal-backdrop"
      >
        <View style={styles.modalContent}>
          <View
            style={[styles.center, Platform.OS !== 'ios' ? { flex: 1 } : {}]}
          >
            <View style={styles.barIcon} />

            <CardFormNative
              {...props}
              {...(Platform.OS === 'ios' ? props.styleOverrides : {})}
            />
          </View>
        </View>
      </Modal>
    </View>
  );
};
```

The CardForm component renders a native view that allows users to input their credit/debit card information. It accepts the following props:

| Prop Name | Type | Description |
| --- | --- | --- |
| `style` | `StyleProp<ViewStyle>` | Custom styles for the component. |
| `styleOverrides` | `object` | Custom style overrides for specific sub-components of the component. |
| `open` | `boolean` | A boolean value indicating whether the card form is open. |
| `onClose` | `function` | A function to be called when the card form is closed. |
| `onSubmit` | `function` | A function that will be called when the user submits the card form, providing the status code, data, and error in the nativeEvent. |

Please make sure to adjust the import paths and file locations as per your project structure.


## JustifiProvider.d.ts

Defines the TypeScript types for the JustifiProvider component and its props. TypeScript users can import these types to ensure type safety in their projects.

``` Typescript
  import type { JustifiProviderProps } from './path/to/JustifiProvider.d.ts';

  const MyComponent = () => {
    const myProps: JustifiProviderProps = { ... };
    return <JustifiProvider {...myProps} />;
  }
```

#### **InitJutifiParams**
  Defines the parameters required to initialize the Justifi provider:

``` Typescript
  interface InitJutifiParams {
  clientId: string;
  account: string;
}
```

#### **JustifiProviderProps**
  Defines the props for the JustifiProvider component:

| Prop Name | Type | Description |
| --- | --- | --- |
| `clientId` | `string` | The client ID for your Justifi account. |
| `account` | `string` | The account name for your Justifi account. |
| `children` | `React.ReactElement - React.ReactElement[]` | The child component(s) to be wrapped by the JustifiProvider. |

#### **JustifiProvider**
  The JustifiProvider component is used to initialize the Justifi provider in your React application.

``` Typescript
  <JustifiProvider {...props}>{children}</JustifiProvider>
```

#### **JustifiProviderView**
  Defines the view for the JustifiProvider component:

``` Typescript
  interface JustifiProviderView {
  // Define view types here, if any
}
```
Make sure to replace path/to/JustifiProvider.d.ts with the actual path to the JustifiProvider.d.ts file in your project.

## JustifiProvider.tsx

The JustifiProvider component is used to initialize the Justifi provider in your React application. It accepts the following props:

#### **Props**

| Prop Name | Type | Description |
| --- | --- | --- |
| `clientId` | `string` | The client ID for your Justifi account. |
| `account` | `string` | The account name for your Justifi account. |
| `children` | `React.ReactElement - React.ReactElement[]` | The child component(s) to be wrapped by the JustifiProvider. |

The JustifiProvider component initializes the Justifi provider using the provided **`clientId`** and **`account`** props. It should be placed at the top level of your component hierarchy to ensure that all child components have access to the Justifi provider.



## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.



## License

This SDK is released under the MIT License. See the [LICENSE](https://github.com/xseedit/justifi-react-native-sdk/blob/main/LICENSE) file for more information.

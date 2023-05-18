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

#### Installation
1.  Refer to our [Installation section](#installation)

2. Install the required dependencies.
This SDK relies on the following dependencies:

- React Native: 0.71.4
- React: 18.2.0
- TypeScript: 4.5.2

Make sure these dependencies are installed in your project. If you haven't already installed them, you can do so by running the following commands:

**npm**
```bash
  npm install react-native@0.71.4 react@18.2.0 typescript@4.5.2
```

**yarn**
```bash
  yarn add react-native@0.71.4 react@18.2.0 typescript@4.5.2
```

#### Configuration

1. Import the SDK module into your JavaScript file:
``` Javascript
  import { JustifiSDK } from 'justifi-react-native-sdk';
```

2. Initialize the SDK in your application:
``` Javascript
  const sdk = new JustifiSDK();
```

Congratulations! You have successfully installed and configured the Justifi-react-Native SDK in your project. Now you can proceed to the [Usage section](#usage) to learn how to use the SDK in your application.

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
``` Typescript
  import { JustifiSDK } from 'justifi-react-native-sdk';
```

2. Initialize the SDK:
``` Typescript
  const sdk = new JustifiSDK();
```

3. Perform actions using the SDK:
``` Typescript
sdk.doSomething();
```

4. Handle callbacks or promises for asynchronous operations:
``` Typescript
  sdk.performAsyncAction()
  .then((result) => {
    // Handle the successful result
    console.log(result);
  })
  .catch((error) => {
    // Handle the error
    console.error(error);
  });
```

5. Customize the SDK's behavior or UI:
``` Typescript
  // Set a custom theme
sdk.setTheme('dark');

// Set a custom button color
sdk.setButtonColor('#ff0000');

```

6. Explore the available methods and functionalities provided by the SDK by referring to the Documentation.


# Examples

Here are some examples that demonstrate how to use the Justifi-react-Native SDK in your React Native application:

## Example 1: Initializing the SDK

``` Typescript
import { JustifiSDK } from 'justifi-react-native-sdk';

// Initialize the SDK
const sdk = new JustifiSDK();

// Use the SDK to perform actions
sdk.doSomething();
```

## Example 2: Processing a Payment

``` Typescript
import { JustifiSDK } from 'justifi-react-native-sdk';

// Initialize the SDK
const sdk = new JustifiSDK();

// Collect payment information from the user
const paymentInfo = collectPaymentInfo();

// Process the payment using the SDK
sdk.processPayment(paymentInfo)
  .then((response) => {
    // Handle the payment response
    console.log(response);
  })
  .catch((error) => {
    // Handle the payment error
    console.error(error);
  });
```

## Example 3: Customizing the UI

``` Typescript
import { JustifiSDK } from 'justifi-react-native-sdk';

// Initialize the SDK
const sdk = new JustifiSDK();

// Customize the UI components
sdk.setTheme('dark');
sdk.setButtonColor('#ff0000');
```
These examples demonstrate different aspects of using the Justifi-react-Native SDK, such as initializing the SDK, processing payments, and customizing the UI. You can explore more examples and discover additional features in the Documentation.


# Documentation

## BankAccountForm.d.ts
  Defines the TypeScript types for the BankAccountForm component and its props. TypeScript users can import these types to ensure type safety in their projects.

``` Typescript
    import type { BankAccountFormProps } from './path/to/BankAccountForm.d.ts';

    const MyComponent = () => {
    const myProps: BankAccountFormProps = { ... };
    return <BankAccountForm {...myProps} />;
    }
```
**BankAccountFormProps**
Defines the props for the BankAccountForm component:

| Prop Name | Type | Description |
| --- | --- | --- |
| `style` | `StyleProp<ViewStyle>` | Styles for the BankAccountForm component.|
| `styleOverrides` | `object` | Overrides for the default component styles.|

**BankAccountFormState**
Defines the state for the BankAccountForm component.

**BankAccountForm**
The BankAccountForm component renders a form for entering bank account information.

``` Typescript
    <BankAccountForm {...props} />
```
**BankAccountFormView**
Defines the view for the BankAccountForm component:

    
| Prop Name | Type | Description |
| --- | --- | --- |
| `loading` | `boolean` | A boolean value indicating whether the component is currently loading data.|
| `error` | `string - null` | An error message to display, if any.|
| `success` | `boolean` | A boolean value indicating whether the form was successfully submitted.|

## BankAccountForm.js
  This file exports a **`BankAccountForm`** component that renders a native **`BankAccountFormView`** component using the **`requireNativeComponent`** method from **`react-native`**.

``` typescript
    import { BankAccountForm } from './src/components/BankAccountForm';

// Example 1: Initializing the component
const bankAccountFormRef = React.useRef(null);
<BankAccountForm ref={bankAccountFormRef} styleOverrides={{ height: 300 }} />

// Example 2: Processing payments
const isValid = await bankAccountFormRef.current?.validate();
const token = await bankAccountFormRef.current?.tokenize();

// Example 3: Handling events
function handleFormSubmission() {
  bankAccountFormRef.current?.validate().then((isValid) => {
    if (isValid) {
      bankAccountFormRef.current?.tokenize().then((token) => {
        // Handle successful payment token
      });
    } else {
      // Handle validation error
    }
  });
}
  ```
Please note that the **`BankAccountFormView`** component should be properly configured and initialized before using the BankAccountForm component. 
For more information, refer to the SDK documentation.

## BankAccountForm.tsx
 This file defines the **`BankAccountForm`** component, which renders a native view that allows users to input their bank account information for payment processing.

#### Interfaces
    
 **`BankAccountFormProps`**
    This interface defines the props for the **`BankAccountForm`** component

``` Typescript 
        interface BankAccountFormProps extends AccessibilityProps {
                style?: StyleProp<ViewStyle>;
                styleOverrides?: object;
            }
```
                        
| Prop Name | Type | Description |
| --- | --- | --- |
| `style` | `StyleProp<ViewStyle>` | Custom styles for the component |
| `styleOverrides` | `object` | Custom style overrides for specific sub-components of the component |

#### **`BankAccountForm`** Component
    The **`BankAccountForm`** component is defined as follows:

 ``` typescript
            const BankAccountForm = forwardRef<BankAccountFormView.Styles, BankAccountFormProps>(
            function BankAccountForm(props: BankAccountFormProps, ref: React.Ref<BankAccountFormView.Styles>) {
            const styleOverrides = { ...props.styleOverrides };

        return (
        <     BankAccountFormNative
                {...props}
                {...(styleOverrides ? styleOverrides : null)}
                ref={ref}
        />)
        ;}
    ,);
```
| Prop Name | Type | Description |
| --- | --- | --- |
| `props` | `BankAccountFormProps` | Props for the component |
| `ref` | `React.Ref<BankAccountFormView.Styles>`| Ref for the component |

The **`BankAccountForm`** component renders a **`BankAccountFormNative`** component, which is a native view that allows users to input their bank account information. The **`styleOverrides`** prop is used to apply custom style overrides to specific sub-components of the **`BankAccountFormNative`** component.

#### Dependencies
The **`BankAccountForm.tsx`** file has the following dependencies:

   * react-native
   * ../types
   * react

### Bank Account Form Functions
This module exports two functions for interacting with a native bank account form component: **validate()** and **tokenize()**. These functions are async and return promises.

### validate()
The **validate()** function validates the bank account information entered by the user in the form.

``` Typescript
        async function validate(): Promise<boolean> {
         Call the native validate() function and return the result as a boolean.
    return new Promise(resolve => {
            BankAccountFormFunctions.validate((isValid) =>{
                resolve(isValid);
                });
            });
        }
```

### tokenize()
The **tokenize()** function takes the validated bank account information and generates a token that can be used for processing payments.

``` typescript
    async function tokenize(): Promise<string> {
    // Call the native tokenize() function and return the result as a string.
    return new Promise(resolve => {
        BankAccountFormFunctions.tokenize((token) => {
        resolve(token);
        });
    });
    }
```
To use these functions in your project, import them like this:

``` Typescript 
       import { validate, tokenize } from './path/to/bankAccountFormFunctions';
```

Then, call the functions as needed:

``` Typescript 
        const isValid = await validate();
        const token = await tokenize();
```
    
## CardForm.d.ts

Defines the TypeScript types for the CardForm component and its props. TypeScript users can import these types to ensure type safety in their projects.

``` Typescript 
      import type { CardFormProps } from './path/to/CardForm.d.ts';

     const MyComponent = () => {
        const myProps: CardFormProps = { ... };
        return <CardForm {...myProps} />;
       }
```
### CardFormProps
Defines the props for the CardForm component:

| Prop Name | Type | Description |
| --- | --- | --- |
| `onSubmit` | `(cardDetails: CardDetails) => void` | A function that will be called when the user submits the card form.|

### CardDetails
Defines the structure of the object containing the card details:

``` Typescript
  interface CardDetails {
  cardNumber: string;
  expiryDate: string;
  cvc: string;
}
```

### CardForm
The CardForm component renders a form for entering credit/debit card information.

``` Typescript
  <CardForm {...props} />
```

### CardFormView
Defines the view for the CardForm component:

                      
| Prop Name | Type | Description |
| --- | --- | --- |
| `loading` | `boolean` | A boolean value indicating whether the component is currently loading data. |
| `error` | `string - null` |An error message to display, if any. |
| `success` | `boolean` |A boolean value indicating whether the form was successfully submitted. |

## CardForm.js

This file exports a **CardForm** component that renders a native **CardFormView** component using the **requireNativeComponent** method from **react-native**.

``` Typescript
  import { CardForm } from './src/components/CardForm';

// Example 1: Initializing the component
const cardFormRef = React.useRef(null);
<CardForm ref={cardFormRef} styleOverrides={{ height: 300 }} />

// Example 2: Processing payments
const isValid = await cardFormRef.current?.validate();
const token = await cardFormRef.current?.tokenize();

// Example 3: Handling events
function handleFormSubmission() {
  cardFormRef.current?.validate().then((isValid) => {
    if (isValid) {
      cardFormRef.current?.tokenize().then((token) => {
        // Handle successful payment token
      });
    } else {
      // Handle validation error
    }
  });
}
```

Please note that the **CardFormView** component should be properly configured and initialized before using the CardForm component. For more information, refer to the SDK documentation.


## CardForm.tsx

This file defines the **CardForm** component, which renders a native view that allows users to input their credit/debit card information for payment processing.

#### Interfaces
**CardFormProps**
This interface defines the props for the CardForm component.

``` Typescript
  interface CardFormProps extends AccessibilityProps {
  style?: StyleProp<ViewStyle>;
  styleOverrides?: object;
}
```

| Prop Name | Type | Description |
| --- | --- | --- |
| `style` | `StyleProp<ViewStyle>` | Custom styles for the component. |
| `styleOverrides` | `object` | Custom style overrides for specific sub-components of the component. |

#### **CardForm** 
The **CardForm** component is defined as follows:

``` Typescript
const CardForm = forwardRef<CardFormView.Styles, CardFormProps>(
  function CardForm(props: CardFormProps, ref: React.Ref<CardFormView.Styles>) {
    const styleOverrides = { ...props.styleOverrides };

    return (
      <CardFormNative
        {...props}
        {...(styleOverrides ? styleOverrides : null)}
        ref={ref}
      />
    );
  },
);
```

| Prop Name | Type | Description |
| --- | --- | --- |
| `props` | `CardFormProps` | Props for the component. |
| `ref` | `React.Ref<CardFormView.Styles>` | Ref for the component. |

The **CardForm** component renders a **CardFormNative** component, which is a native view that allows users to input their credit/debit card information. The **styleOverrides** prop is used to apply custom style overrides to specific sub-components of the CardFormNative component.

#### Dependencies
Dependencies
The **CardForm.tsx** file has the following dependencies:

- react-native
- ../types
- react

### Card Form Functions
This module exports two functions for interacting with a native card form component: **validate()** and **tokenize().** These functions are async and return promises.

### validate()
The **validate()** function validates the card information entered by the user in the form.

``` Typescript
async function validate(): Promise<boolean> {
  // Call the native validate() function and return the result as a boolean.
  return new Promise((resolve) => {
    CardFormFunctions.validate((isValid) => {
      resolve(isValid);
    });
  });
}
```

### tokenize()
The **tokenize()** function takes the validated card information and generates a token that can be used for processing payments.

``` Typescript
  async function tokenize(): Promise<string> {
  // Call the native tokenize() function and return the result as a string.
  return new Promise((resolve) => {
    CardFormFunctions.tokenize((token) => {
      resolve(token);
    });
  });
}
```

To use these functions in your project, import them like this:
``` Typescript
  import { validate, tokenize } from './path/to/cardFormFunctions'; 
```

Then, call the functions as needed:
``` Typescript
  const isValid = await validate();
  const token = await tokenize();
```

## License

This SDK is released under the MIT License. See the [LICENSE](https://github.com/xseedit/justifi-react-native-sdk/blob/main/LICENSE) file for more information.

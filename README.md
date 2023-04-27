### Justifi-react-Native SDK allows you to easily integrate payment functionality into your mobile application. The SDK provides the following features:

### Prebuilt Payment Component - UI System
Our SDK provides a prebuilt UI system that allows you to easily show a bottom sheet modal with all the necessary data to collect credit/debit card and bank account information from your users. This is a great solution if you want to quickly integrate payment functionality into your app without having to build your own UI.

### Component System to Customize UI
In addition to the prebuilt payment component, our SDK also provides a component system that allows you to customize the payment UI to match your app's look and feel. This means you can create your own payment components and styles to adapt the payment process to your app's branding.

### Payment Methods
It supports multiple payment methods, including credit/debit cards and bank accounts.
Also, SDK supports tokenization and validation of credit/debit cards and bank accounts, making it easy for you to securely collect payment information from your users as well as bank transfers.

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

Explain the prerequisites for using your SDK, including any necessary tools, software, or environment setup steps.

# Installation


Provide step-by-step instructions on how to install your SDK. Include any platform-specific instructions if necessary.

# Usage

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
        | `error` | `string|null` | An error message to display, if any.|
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
    
## Bank Account Form Functions


## Examples


```bash
# Include installation commands here, if applicable
```

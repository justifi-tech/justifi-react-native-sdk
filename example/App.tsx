// import {BankAccountForm, validate, tokenize} from 'justifi-react-native-sdk';
// import {CardForm, validateCard, tokenizeCard, JustifiProvider} from 'justifi-react-native-sdk';
import {useState} from 'react';
import * as React from 'react';

import {StyleSheet, View, Button, Text, Alert} from 'react-native';

export default function App() {
  const [view, setView] = useState('menu');

  // const CLIENT_ID = 'test_Sbxw9RJ8PplOrC5ezUHcU5X9vJ3Q4Fmx';
  // const ACCOUNT = 'acc_3VgkWT3JXKdNPnh2S5NRp3';

  // const [openCard, setOpenCard] = useState(true);

  // const validateCuston = 'onSubmit';
  // const handleValidateCard = async () => {
  //   const isValid = await validateCard();
  //   console.log('isValid', isValid);
  // };

  // const handleTokenizeCard = async () => {
  //   const token = await tokenizeCard('paymentMethodMetadata');
  //   console.log('token', token);
  // };

  // const handleValidate = async () => {
  //   const isValid = await validate();
  //   console.log('Form is valid:', isValid);
  // };

  // const handleTokenize = async () => {
  //   const tokenizedData = await tokenize();
  //   console.log('Tokenized data:', tokenizedData);
  // };

  // const layout = {
  //   padding: 0, //working
  //   //TODO: ask about this ones to confirm with the Justifi team
  //   // formControlSpacingHorizontal: 8,
  //   // formControlSpacingVertical: 16,
  // };

  // const formLabel = {
  //   fontWeight: '700', //working
  //   fontFamily: 'sans-serif', //working
  //   margin: {bottom: 5}, //working
  // };

  // const formControl = {
  //   backgroundColor: '#EEEEF5', //working
  //   borderColor: '#000015', //working
  //   borderColorFocus: '#fccc32', //working
  //   borderColorError: '#C12727', //TODO on api call validations
  //   borderWidth: 1, //working
  //   borderBottomWidth: 1,
  //   borderRadius: {topLeft: 8, topRight: 4, bottomLeft: 0, bottomRight: 0}, //working
  //   borderStyle: 'solid',
  //   boxShadowErrorFocus: 'none', //TODO ask if this are neccesary, boxShadow does not exist on mobile, on IOS something similar could be elevation
  //   boxShadowFocus: 'none', //TODO ask if this are neccesary, boxShadow does not exist on mobile, on IOS something similar could be elevation
  //   color: '#212529', //working
  //   fontSize: 16, //TODO ask if this increments the input height
  //   fontWeight: '400', //working
  //   lineHeight: 90, //TODO is this the input height?
  //   margin: 0,
  //   padding: {top: 8, bottom: 8, left: 14, right: 14},
  // };

  // const errorMessage = {
  //   color: '#C12727', //working
  //   margin: {top: 4, bottom: 0, left: 0, right: 0},
  //   fontSize: 12, //working
  // };

  // const styleOverrides = {
  //   layout: layout,
  //   formLabel: formLabel,
  //   formControl: formControl,
  //   errorMessage: errorMessage,
  // };

  const renderContent = () => {
    switch (view) {
      case 'bankAccount':
        return (
            <View style={styles.box}>
              <Text>Bank Account Form</Text>
              {/* {<BankAccount
                style={styles.view}
                styleOverrides={styleOverrides}
                open={openCard}
                onClose={() => {
                  // console.log('onClose', inputRef);
                  // setOpenCard(false);
                }}
                onSubmit={({nativeEvent}) => {
                  console.log('NATIVE EVENT', nativeEvent);
                  const {statusCode, data, error} = nativeEvent;

                  if (statusCode === 201) {
                    Alert.alert('Payment method created successfully');
                    console.log('Payment method created successfully:', data);
                  } else {
                    console.log('PARSED ERROR', error);
                    Alert.alert('Error ' + statusCode, error ?? '');
                    console.log(`Error with status code ${statusCode}: ${error ?? ''}`);
                  }
                }}
              />} */}
              <View>
                {/* <Button title="Tokenize" onPress={handleTokenize} />
                <Button title="Validate" onPress={handleValidate} /> */}
              </View>

              <Button title="Back to Menu" onPress={() => setView('menu')} />
            </View>
        );
      case 'card':
        return (
          <View style={styles.box}>
            {/* <CardForm
              style={styles.view}
              styleOverrides={styleOverrides}
              open={openCard}
              onClose={() => {
                console.log('close');
              }}
              onSubmitCard={({nativeEvent}) => {
                console.log('NATIVE EVENT', nativeEvent);
                const {statusCode, data, error} = nativeEvent;

                if (statusCode === 201) {
                  Alert.alert('Payment method created successfully');
                  console.log('Payment method created successfully:', data);
                } else {
                  console.log('PARSED ERROR', error);
                  Alert.alert('Error ' + statusCode, error ?? '');
                  console.log(`Error with status code ${statusCode}: ${error ?? ''}`);
                }
              }}
            /> */}
            <Button title="Back to Menu" onPress={() => setView('menu')} />
          </View>
        );
      default:
        return (
          <>
            <Button
              title="Bank Account Form"
              onPress={() => setView('bankAccount')}
            />
            <Button title="Card Form" onPress={() => setView('card')} />
          </>
        );
    }
  };

  return (
    // <JustifiProvider clientId={CLIENT_ID} account={ACCOUNT}>
      <View style={styles.container}>
        {renderContent()}
      </View>
    // </JustifiProvider>
    );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  box: {
    flex: 1,
    width: '100%',
    alignItems: 'center',
    justifyContent: 'space-around',
  },
  view: {
    width: '100%',
    flex: 1,
  },
});

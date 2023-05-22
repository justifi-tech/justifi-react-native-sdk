import * as React from 'react';

import { Alert, Button, StyleSheet, View } from 'react-native';
import {
  BankAccountFormView,
  CardFormView,
  // JustifiProviderView,
} from 'justifi-react-native-sdk';

export default function App() {
  const [view, setView] = React.useState('menu');
  const [openCard, setOpenCard] = React.useState(true);
  const [openBank, setOpenBank] = React.useState(true);
  const CLIENT_ID = 'test_Sbxw9RJ8PplOrC5ezUHcU5X9vJ3Q4Fmx';
  const ACCOUNT = 'acc_3VgkWT3JXKdNPnh2S5NRp3';

  const layout = {
    padding: 0,
  };

  const formLabel = {
    fontWeight: '700',
    fontFamily: 'sans-serif',
    margin: { bottom: 5 },
  };

  const formControl = {
    backgroundColor: '#F4F4F6',
    backgroundColorHover: '#949494',
    borderColor: '#949494',
    borderWidth: 4,
    borderRadius: { topLeft: 4, topRight: 4, bottomLeft: 4, bottomRight: 4 },
    color: '#212529',
    // fontSize: 55, // uniform platform font size
    fontWeight: '400',
    lineHeight: 90,
    margin: 12,
    padding: { top: 8, bottom: 8, left: 8, right: 8 },
  };

  const errorMessage = {
    color: '#C12727',
    margin: { top: 4, bottom: 0, left: 0, right: 0 },
    fontSize: 12,
  };

  const styleOverrides = {
    layout: layout,
    formLabel: formLabel,
    formControl: formControl,
    errorMessage: errorMessage,
  };

  const renderContent = () => {
    switch (view) {
      case 'bankAccount':
        return (
          <View style={styles.box}>
            <BankAccountFormView
              style={styles.view}
              styleOverrides={styleOverrides}
              open={openBank}
              onClose={() => {
                setOpenBank(false);
                setView('menu');
              }}
              onSubmit={({ nativeEvent }) => {
                console.log('NATIVE EVENT', nativeEvent);
                const { statusCode, data, error } = nativeEvent;

                if (statusCode === 201) {
                  Alert.alert('Payment method created successfully');
                  console.log('Payment method created successfully:', data);
                } else {
                  console.log('PARSED ERROR', error);
                  Alert.alert('Error ' + statusCode, error ?? '');
                  console.log(
                    `Error with status code ${statusCode}: ${error ?? ''}`
                  );
                }
              }}
            />
          </View>
        );
      case 'card':
        return (
          <View style={styles.box}>
            {/* <JustifiProviderView clientId={CLIENT_ID} account={ACCOUNT}> */}
            <CardFormView
              style={styles.view}
              styleOverrides={styleOverrides}
              open={openCard}
              onClose={() => {
                setOpenCard(false);
                setView('menu');
              }}
              onSubmit={({ nativeEvent }) => {
                console.log('NATIVE EVENT', nativeEvent);
                const { statusCode, data, error } = nativeEvent;

                if (statusCode === 201) {
                  Alert.alert('Payment method created successfully');
                  console.log('Payment method created successfully:', data);
                } else {
                  console.log('PARSED ERROR', error);
                  Alert.alert('Error ' + statusCode, error ?? '');
                  console.log(
                    `Error with status code ${statusCode}: ${error ?? ''}`
                  );
                }
              }}
            />
            {/* </JustifiProviderView> */}
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
    // <JustifiProviderView clientId={CLIENT_ID} account={ACCOUNT}>
    <View style={styles.container}>{renderContent()}</View>
    // </JustifiProviderView>
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

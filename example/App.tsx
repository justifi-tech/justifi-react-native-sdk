// import {BankAccountForm} from 'justifi-react-native-sdk';
import {CardForm} from 'justifi-react-native-sdk';
import {useState} from 'react';
import * as React from 'react';

import {StyleSheet, View, Button, Text} from 'react-native';

export default function App() {
  const [view, setView] = useState('menu');

  const stylesCustom = {
    layout: {
      padding: 80,
      formControlSpacingHorizontal: 8,
      formControlSpacingVertical: 10,
    },
    formLabel: {
      fontWeight: '700',
      fontFamily: 'sans-serif',
      margin: {bottom: 8, top: 8},
    },
    formControl: {
      backgroundColor: '#F4F4F6',
      backgroundColorHover: '#3960ed',
      borderColor: '#949494',
      borderColorHover: '#ad9b6f',
      borderColorFocus: '#FCCC32',
      borderColorError: '#C12727',
      borderWidth: 5,
      borderBottomWidth: 1,
      borderRadius: {topLeft: 4, topRight: 4, bottomLeft: 4, bottomRight: 4},
      borderStyle: 'solid',
      boxShadowErrorFocus: 'none',
      boxShadowFocus: 'none',
      color: '#212529',
      fontSize: 55,
      fontWeight: '400',
      lineHeight: 90,
      margin: 12,
      padding: {top: 8, bottom: 8, left: 8, right: 8},
    },
    errorMessage: {
      color: '#C12727',
      margin: {top: 40, bottom: 0, left: 0, right: 0},
      fontSize: 14,
    },
  };
  const validateCuston = 'onSubmit';

  const renderContent = () => {
    switch (view) {
      case 'bankAccount':
        return (
          <View style={styles.box}>
            <Text>Bank Account Form</Text>
            {
              // <BankAccountForm
              //   style={{height: 200, width: '100%', backgroundColor: 'red'}}
              //   ref={inputRef}
              // />
            }
            <Button title="Back to Menu" onPress={() => setView('menu')} />
          </View>
        );
      case 'card':
        return (
          <View style={styles.box}>
            <Text>Card Form</Text>
            {
              // <CardForm
              //   style={{height: '100%', width: '100%'}}
              //   styleOverrides={JSON.stringify(stylesCustom)}
              //   validationStrategy={validateCuston}
              // />
            }
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

  return <View style={styles.container}>{renderContent()}</View>;
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
});

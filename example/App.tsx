import {BankAccountForm} from 'justifi-react-native-sdk';
import {CardForm} from 'justifi-react-native-sdk';
import {useRef, useState} from 'react';
import * as React from 'react';

import {StyleSheet, View, Button, Text} from 'react-native';

export default function App() {
  const [view, setView] = useState('menu');
  // const inputRef = useRef(null);

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
              //   style={{height: 200, width: '100%', backgroundColor: 'red'}}
              //   ref={inputRef}
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

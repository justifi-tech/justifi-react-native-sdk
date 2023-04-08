import { useState } from 'react';
import * as React from 'react';

import { StyleSheet, View, Button, Text } from 'react-native';
import { BankAccountForm } from 'justifi-react-native-sdk';
import { CardForm } from 'justifi-react-native-sdk';

export default function App() {
  const [view, setView] = useState('menu');

  const renderContent = () => {
    switch (view) {
      case 'bankAccount':
        return (
          <>
            <Text>Bank Account Form</Text>
            <BankAccountForm />
            <Button title="Back to Menu" onPress={() => setView('menu')} />
          </>
        );
      case 'card':
        return (
          <>
            <Text>Card Form</Text>
            <CardForm />
            <Button title="Back to Menu" onPress={() => setView('menu')} />
          </>
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
    width: 60,
    height: 60,
    marginVertical: 20,
  },
});

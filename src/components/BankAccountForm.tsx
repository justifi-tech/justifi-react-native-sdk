import {
  requireNativeComponent,
  StatusBar,
  View,
  StyleSheet,
  Button,
} from 'react-native';
import type {
  ViewStyle,
  StyleProp,
  AccessibilityProps,
} from 'react-native/types';
import { validate, tokenize } from '../utils/bankAccountFormFunctions';
import type { BankAccountFormView } from '../types';
import Modal from 'react-native-modal';
import React from 'react';

const BankAccountFormNative =
  requireNativeComponent<BankAccountFormView.NativeProps>(
    'BankAccountFormView',
  );

export interface Props extends AccessibilityProps {
  style?: StyleProp<ViewStyle>;
  styleOverrides?: object;
  open: boolean;
  onClose: () => void;
}

export const BankAccountForm = (props: Props) => {
  const { styleOverrides, open, onClose, ...rest } = props;

  const handleValidate = async () => {
    const isValid = await validate();
    console.log('Form is valid:', isValid);
  };

  const handleTokenize = async () => {
    const tokenizedData = await tokenize();
    console.log('Tokenized from RN:', tokenizedData);
  };

  return (
    <View style={styles.flexView}>
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
          <View style={styles.center}>
            <View style={styles.barIcon} />
            <BankAccountFormNative {...rest} {...styleOverrides} ref={null} />
            <View>
              <Button title="Tokenize" onPress={handleTokenize} />
              <Button title="Validate" onPress={handleValidate} />
            </View>
          </View>
        </View>
      </Modal>
    </View>
  );
};

const styles = StyleSheet.create({
  flexView: {
    flex: 1,
    backgroundColor: 'white',
  },
  modal: {
    justifyContent: 'flex-end',
    margin: 0,
  },
  modalContent: {
    backgroundColor: '#FFFFFF',
    paddingTop: 12,
    paddingHorizontal: 12,
    borderTopRightRadius: 20,
    borderTopLeftRadius: 20,
    minHeight: 400,
    paddingBottom: 20,
  },
  center: {
    display: 'flex',
    alignItems: 'center',
    justifyContent: 'center',
  },
  barIcon: {
    width: 60,
    height: 5,
    backgroundColor: '#bbb',
    borderRadius: 3,
    marginBottom: 20,
  },
  btnContainer: {
    display: 'flex',
    alignItems: 'center',
    justifyContent: 'center',
    height: 500,
  },
});

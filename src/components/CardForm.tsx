import {
  Button,
  StatusBar,
  StyleProp,
  StyleSheet,
  Text,
  View,
  ViewStyle,
  requireNativeComponent,
} from 'react-native';
import { validate, tokenize } from '../utils/cardFormFunctions';
import type { CardFormView } from '../types';
import Modal from 'react-native-modal';
import React from 'react';

/**
 *  CardForm Component Props
 */
export interface Props extends CardFormView.NativeProps {
  style?: StyleProp<ViewStyle>;
  styleOverrides?: string;
  validationStrategy?: string;
  open: boolean;
  onClose: () => void;
}

const CardFormNative = requireNativeComponent<Props>('CardFormView');

/**
 *  CardForm Component
 *
 * @example
 *
 *  <CardForm
 *    style={styles.view}
 *    styleOverrides={JSON.stringify(stylesCustom)}
 *    validationStrategy={'onSubmit'}
 *    open={handleOpen}
 *    onClose={handleClose}
 *  >
 *    <App />
 *  </CardForm>
 *
 * @param __namedParameters Props
 * @returns JSX.Element
 * @category ReactComponents
 */
export const CardForm: React.FC<Props> = (props) => {
  const { open, onClose } = props;

  const handleTokenize = async () => {
    const token = await tokenize('paymentMethodMetadata');
    console.log('token', token);
  };

  const handleValidate = async (): Promise<void> => {
    const isValid = await validate();
    console.log('isValid', isValid);
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
          <View style={styles.container}>
            <Text style={styles.title}>Card Form</Text>
            <View style={styles.view}>
              <CardFormNative {...props} />
            </View>
            <View style={styles.button}>
              <Button title="Tokenize" onPress={handleTokenize} />
            </View>
            <View style={styles.button}>
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
    justifyContent: 'center',
    margin: 0,
  },
  modalContent: {
    backgroundColor: '#FFFFFF',
    paddingTop: 12,
    paddingHorizontal: 12,
    borderRadius: 4,
    minHeight: 500,
    paddingBottom: 20,
    margin: 12,
  },
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
  },
  title: {
    fontSize: 20,
    fontWeight: '700',
  },
  view: {
    width: '100%',
    flex: 1,
  },
  button: {
    width: '100%',
    paddingHorizontal: 32,
    paddingVertical: 8,
  },
});

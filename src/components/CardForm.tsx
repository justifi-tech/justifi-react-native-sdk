import {
  StatusBar,
  StyleProp,
  StyleSheet,
  Text,
  View,
  ViewStyle,
  requireNativeComponent,
} from 'react-native';
import type { CardFormView } from '../types';
import Modal from 'react-native-modal';
import React from 'react';

/**
 *  CardForm Component Props
 */
export interface Props extends CardFormView.NativeProps {
  style?: StyleProp<ViewStyle>;
  styleOverrides?: object;
  open: boolean;
  onClose: () => void;
  onSubmitCard?: (event: {
    nativeEvent: { statusCode: number; data: any; error: any };
  }) => void;
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
    minHeight: 480,
    paddingBottom: 20,
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
});

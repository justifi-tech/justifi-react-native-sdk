import {
  requireNativeComponent,
  StyleProp,
  ViewStyle,
  StatusBar,
  View,
  StyleSheet,
  Platform,
} from 'react-native';
import type { BankAccountFormView } from '../types';
import Modal from 'react-native-modal';
import React from 'react';

export interface Props extends BankAccountFormView.NativeProps {
  style?: StyleProp<ViewStyle>;
  styleOverrides?: object;
  open: boolean;
  onClose: () => void;
  onSubmit?: (event: {
    nativeEvent: { statusCode: number; data: any; error: any };
  }) => void;
}

const BankAccountNative = requireNativeComponent<Props>('BankAccountFormView');

/**
 *  BankAccountForm Component
 *
 * @example
 *
 *  <BankAccountForm
 *    style={styles.view}
 *    styleOverrides={stylesCustom}
 *    open={handleOpen}
 *    onClose={handleClose}
 *    onSubmit={handleSubmit}
 *  />
 *
 * @param __namedParameters Props
 * @returns JSX.Element
 * @category ReactComponents
 */

export const BankAccountForm: React.FC<Props> = (props) => {
  const { open, onClose } = props;

  return (
    <View style={styles.flexView} testID="bank-account-form">
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

            <BankAccountNative
              {...props}
              {...(Platform.OS === 'ios' ? props.styleOverrides : {})}
            />
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
    flex: 1,
  },
  barIcon: {
    width: 60,
    height: 5,
    backgroundColor: '#bbb',
    borderRadius: 3,
    marginBottom: 30,
  },
});

import {
  requireNativeComponent,
  StyleProp,
  ViewStyle,
  StatusBar,
  View,
  StyleSheet,
  Platform,
} from 'react-native';
import type { CardFormView } from '../types';
import Modal from 'react-native-modal';
import React from 'react';

export interface Props extends CardFormView.NativeProps {
  style?: StyleProp<ViewStyle>;
  styleOverrides?: object;
  open: boolean;
  onClose: () => void;
  onSubmit?: (event: {
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

export const CardForm: React.FC<Props> = (props) => {
  const { open, onClose } = props;

  return (
    <View style={styles.flexView} testID="card-form">
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
        accessibilityLabel="card-modal"
      >
        <View style={styles.modalContent}>
          <View
            style={[styles.center, Platform.OS !== 'ios' ? { flex: 1 } : {}]}
          >
            <View style={styles.barIcon} />

            <CardFormNative
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
    minHeight: 480,
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
    marginBottom: 30,
  },
});

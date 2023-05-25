import { UIManager, Platform } from 'react-native';
import { BankAccountForm } from './components/BankAccountForm';
import { CardForm } from './components/CardForm';
import { JustifiProvider as JustifiProviderNative } from './components/JustifiProvider';

const LINKING_ERROR =
  `The package 'justifi-react-native-sdk' doesn't seem to be linked. Make sure: \n\n` +
  Platform.select({ ios: "- You have run 'pod install'\n", default: '' }) +
  '- You rebuilt the app after installing the package\n' +
  '- You are not using Expo Go\n';
  

export const BankAccountFormView =
  UIManager.getViewManagerConfig('BankAccountFormView') != null
    ? BankAccountForm
    : () => {
        throw new Error(LINKING_ERROR);
      };

export const CardFormView =
  UIManager.getViewManagerConfig('CardFormView') != null
    ? CardForm
    : () => {
        throw new Error(LINKING_ERROR);
      };

export const JustifiProvider = JustifiProviderNative;

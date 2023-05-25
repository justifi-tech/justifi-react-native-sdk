import { NativeModules } from 'react-native';

const { ProviderModule } = NativeModules;

export async function initialise(
  clientId: string,
  account: string,
): Promise<void> {
  return new Promise((resolve) => {
    ProviderModule.initialise(clientId, account, () => {
      resolve();
    });
  });
}

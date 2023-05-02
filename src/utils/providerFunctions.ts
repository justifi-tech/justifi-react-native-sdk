import { NativeModules } from 'react-native';

const { ProviderModule } = NativeModules;

export async function initialise(
  clientId: string,
  account: string,
): Promise<void> {
  return new Promise(() => {
    ProviderModule.initialise(clientId, account, () => {});
  });
}

import React, { useEffect } from 'react';

import { initialise } from '../utils/providerFunctions';
import type { InitJutifiParams } from '../types';

/**
 *  Justifi Provider Component Props
 */
export type Props = InitJutifiParams & {
  children: React.ReactElement | React.ReactElement[];
};

/**
 *  JustifiProvider Component
 *
 * @example
 *
 *  <JustifiProvider
 *    clientId="_clientId"
 *    account="_account"
 *  >
 *    <App />
 *  </JustifiProvider>
 *
 * @param __namedParameters Props
 * @returns JSX.Element
 * @category ReactComponents
 */
export function JustifiProvider({ children, clientId, account }: Props) {
  useEffect(() => {
    if (!clientId || !account) {
      return;
    }
    initialise(clientId, account);
  }, [clientId, account]);

  return <>{children}</>;
}

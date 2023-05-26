import React from 'react';

export interface InitJutifiParams {
  clientId: string;
  account: string;
}

export interface JustifiProviderProps extends InitJutifiParams {
  children: React.ReactElement | React.ReactElement[];
}

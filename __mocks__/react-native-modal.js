// File: __mocks__/react-native-modal.js

import React from 'react';
import { View } from 'react-native';

const MockModal = ({ open, children }) => {
  if (!open) {
    return null;
  }

  return <View>{children}</View>;
};

export default MockModal;

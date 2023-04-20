// @ts-nocheck

'use strict';
var __createBinding =
  (this && this.__createBinding) ||
  (Object.create
    ? function (o, m, k, k2) {
        if (k2 === undefined) k2 = k;
        var desc = Object.getOwnPropertyDescriptor(m, k);
        if (
          !desc ||
          ('get' in desc ? !m.__esModule : desc.writable || desc.configurable)
        ) {
          desc = {
            enumerable: true,
            get: function () {
              return m[k];
            },
          };
        }
        Object.defineProperty(o, k2, desc);
      }
    : function (o, m, k, k2) {
        if (k2 === undefined) k2 = k;
        o[k2] = m[k];
      });
var __setModuleDefault =
  (this && this.__setModuleDefault) ||
  (Object.create
    ? function (o, v) {
        Object.defineProperty(o, 'default', {enumerable: true, value: v});
      }
    : function (o, v) {
        o['default'] = v;
      });
var __importStar =
  (this && this.__importStar) ||
  function (mod) {
    if (mod && mod.__esModule) return mod;
    var result = {};
    if (mod != null)
      for (var k in mod)
        if (k !== 'default' && Object.prototype.hasOwnProperty.call(mod, k))
          __createBinding(result, mod, k);
    __setModuleDefault(result, mod);
    return result;
  };
Object.defineProperty(exports, '__esModule', {value: true});
const justifi_react_native_sdk_1 = require('justifi-react-native-sdk');
const react_1 = require('react');
const React = __importStar(require('react'));
const react_native_1 = require('react-native');
function App() {
  const [view, setView] = (0, react_1.useState)('menu');
  const handleValidate = async () => {
    const isValid = await (0, justifi_react_native_sdk_1.validate)();
    console.log('Form is valid:', isValid);
  };
  const handleTokenize = async () => {
    const tokenizedData = await (0, justifi_react_native_sdk_1.tokenize)();
    console.log('Tokenized data:', tokenizedData);
  };
  const layout = {
    padding: 0, //working
    //TODO: ask about this ones to confirm with the Justifi team
    // formControlSpacingHorizontal: 8,
    // formControlSpacingVertical: 16,
  };
  const formLabel = {
    fontWeight: '700',
    fontFamily: 'sans-serif',
    margin: {bottom: 5}, //working
  };
  const formControl = {
    backgroundColor: '#EEEEF5',
    borderColor: '#000015',
    borderColorFocus: '#fccc32',
    borderColorError: '#C12727',
    borderWidth: 1,
    borderBottomWidth: 1,
    borderRadius: {topLeft: 8, topRight: 4, bottomLeft: 0, bottomRight: 0},
    borderStyle: 'solid',
    boxShadowErrorFocus: 'none',
    boxShadowFocus: 'none',
    color: '#212529',
    fontSize: 16,
    fontWeight: '400',
    lineHeight: 2,
    margin: 0,
    padding: {top: 8, bottom: 8, left: 14, right: 14},
  };
  const errorMessage = {
    color: '#C12727',
    margin: {top: 4, bottom: 0, left: 0, right: 0},
    fontSize: 12, //working
  };
  const styleOverrides = {
    layout: layout,
    formLabel: formLabel,
    formControl: formControl,
    errorMessage: errorMessage,
  };
  const renderContent = () => {
    switch (view) {
      case 'bankAccount':
        return React.createElement(
          react_native_1.View,
          {style: styles.box},
          React.createElement(react_native_1.Text, null, 'Bank Account Form'),
          React.createElement(justifi_react_native_sdk_1.BankAccountForm, {
            style: {height: 200, width: '80%'},
            styleOverrides: styleOverrides,
          }),
          React.createElement(
            react_native_1.View,
            null,
            React.createElement(react_native_1.Button, {
              title: 'Tokenize',
              onPress: handleTokenize,
            }),
            React.createElement(react_native_1.Button, {
              title: 'Validate',
              onPress: handleValidate,
            }),
          ),
          React.createElement(react_native_1.Button, {
            title: 'Back to Menu',
            onPress: () => setView('menu'),
          }),
        );
      case 'card':
        return React.createElement(
          react_native_1.View,
          {style: styles.box},
          React.createElement(react_native_1.Text, null, 'Card Form'),
          React.createElement(react_native_1.Button, {
            title: 'Back to Menu',
            onPress: () => setView('menu'),
          }),
        );
      default:
        return React.createElement(
          React.Fragment,
          null,
          React.createElement(react_native_1.Button, {
            title: 'Bank Account Form',
            onPress: () => setView('bankAccount'),
          }),
          React.createElement(react_native_1.Button, {
            title: 'Card Form',
            onPress: () => setView('card'),
          }),
        );
    }
  };
  return React.createElement(
    react_native_1.View,
    {style: styles.container},
    renderContent(),
  );
}
exports.default = App;
const styles = react_native_1.StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  box: {
    flex: 1,
    width: '100%',
    alignItems: 'center',
    justifyContent: 'space-around',
  },
});

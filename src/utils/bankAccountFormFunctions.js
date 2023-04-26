"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.tokenize = exports.validate = void 0;
const react_native_1 = require("react-native");
const { BankAccountFormFunctions } = react_native_1.NativeModules;
async function validate() {
    return new Promise(resolve => {
        BankAccountFormFunctions.validate((isValid) => {
            resolve(isValid);
        });
    });
}
exports.validate = validate;
async function tokenize() {
    return new Promise(resolve => {
        BankAccountFormFunctions.tokenize((token) => {
            resolve(token);
        });
    });
}
exports.tokenize = tokenize;

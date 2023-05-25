/** @type {import('ts-jest').JestConfigWithTsJest} */
module.exports = {
  preset: 'ts-jest',
  testEnvironment: 'node',
};

module.exports = async () => {
  return {
    verbose: true,
    preset: 'react-native',

    modulePathIgnorePatterns: [
      '<rootDir>/example/node_modules',
      '<rootDir>/lib/',
    ],
    moduleNameMapper: {
      '^react-native-modal$': '<rootDir>/__mocks__/react-native-modal.js', // Map 'react-native-modal' to the manual mock file
    },
  };
};

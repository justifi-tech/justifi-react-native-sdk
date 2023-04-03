module.exports = async () => {
  return {
    verbose: true,
    preset: 'react-native',

    modulePathIgnorePatterns: [
      '<rootDir>/example/node_modules',
      '<rootDir>/lib/',
    ],
  };
};

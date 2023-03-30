import { multiply } from './index.tsx';

test('multiply function', async () => {
  const expected = 404;
  expect(await multiply(1, 404)).toEqual(expected);
});

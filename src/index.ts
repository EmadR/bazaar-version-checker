import { registerPlugin } from '@capacitor/core';

import type { BazaarVersionCheckerPlugin } from './definitions';

const BazaarVersionChecker = registerPlugin<BazaarVersionCheckerPlugin>('BazaarVersionChecker', {
  web: () => import('./web').then((m) => new m.BazaarVersionCheckerWeb()),
});

export * from './definitions';
export { BazaarVersionChecker };

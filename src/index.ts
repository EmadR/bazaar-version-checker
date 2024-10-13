import { registerPlugin } from '@capacitor/core';

import type { BazaarVersionCheckerPlugin, CheckVersionOptions, CheckVersionResult } from './definitions';

const BazaarVersionChecker = registerPlugin<BazaarVersionCheckerPlugin>('BazaarVersionChecker', {
  web: () => import('./web').then(m => new m.BazaarVersionCheckerWeb())
});

export const checkVersion = async (options: CheckVersionOptions): Promise<CheckVersionResult> => {
  return BazaarVersionChecker.checkVersion(options);
};

export * from './definitions';
export { BazaarVersionChecker };

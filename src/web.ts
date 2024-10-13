import { WebPlugin } from '@capacitor/core';

import type { BazaarVersionCheckerPlugin, CheckVersionOptions, CheckVersionResult } from './definitions';

export class BazaarVersionCheckerWeb extends WebPlugin implements BazaarVersionCheckerPlugin {
  async checkVersion(_options: CheckVersionOptions): Promise<CheckVersionResult> {
    console.log('Bazaar version checking is not implemented for web.');
    return {
      message: 'Web platform not supported',
      updateAvailable: false,
    };
  }
}

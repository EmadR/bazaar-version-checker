import { WebPlugin } from '@capacitor/core';

import type { BazaarVersionCheckerPlugin } from './definitions';

export class BazaarVersionCheckerWeb extends WebPlugin implements BazaarVersionCheckerPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}

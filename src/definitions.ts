export interface BazaarVersionCheckerPlugin {
  checkVersion(options: CheckVersionOptions): Promise<CheckVersionResult>;
}

export interface CheckVersionOptions {
  packageName: string;
}

export interface CheckVersionResult {
  message: string;
  updateAvailable: boolean;
}

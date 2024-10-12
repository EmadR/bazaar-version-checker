export interface BazaarVersionCheckerPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}

# bazaar-version-checker

Check app version from Bazaar

## Install

```bash
npm install bazaar-version-checker
npx cap sync
```

## API

<docgen-index>

* [`checkVersion(...)`](#checkversion)
* [Interfaces](#interfaces)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### checkVersion(...)

```typescript
checkVersion(options: CheckVersionOptions) => Promise<CheckVersionResult>
```

| Param         | Type                                                                |
| ------------- | ------------------------------------------------------------------- |
| **`options`** | <code><a href="#checkversionoptions">CheckVersionOptions</a></code> |

**Returns:** <code>Promise&lt;<a href="#checkversionresult">CheckVersionResult</a>&gt;</code>

--------------------


### Interfaces


#### CheckVersionResult

| Prop                  | Type                 |
| --------------------- | -------------------- |
| **`message`**         | <code>string</code>  |
| **`updateAvailable`** | <code>boolean</code> |


#### CheckVersionOptions

| Prop                     | Type                |
| ------------------------ | ------------------- |
| **`packageName`**        | <code>string</code> |
| **`currentVersionCode`** | <code>string</code> |

</docgen-api>

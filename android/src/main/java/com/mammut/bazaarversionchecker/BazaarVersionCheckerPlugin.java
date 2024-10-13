package com.mammut.bazaarversionchecker;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;

import com.farsitel.bazaar.IUpdateCheckService;

@CapacitorPlugin(name = "BazaarVersionChecker")
public class BazaarVersionCheckerPlugin extends Plugin {

    private BazaarVersionChecker implementation = new BazaarVersionChecker();
    private IUpdateCheckService updateCheckService;

    @PluginMethod
    public void echo(PluginCall call) {
        String value = call.getString("value");

        JSObject ret = new JSObject();
        ret.put("value", implementation.echo(value));
        call.resolve(ret);
    }

    private final ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            updateCheckService = IUpdateCheckService.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            updateCheckService = null;
        }
    };

    @PluginMethod
    public void checkVersion(PluginCall call) {
        String packageName = call.getString("packageName");
        if (packageName == null) {
            call.reject("Package name is required");
            return;
        }

        bindToBazaarUpdateService();

        try {
            String versionCode = updateCheckService.getVersionCode(packageName);
            String currentVersionCode = BuildConfig.VERSION_CODE;

            if (!versionCode.equals(currentVersionCode)) {
                call.resolve(createResponse("Update available", true));
            } else {
                call.resolve(createResponse("Up to date", false));
            }
        } catch (RemoteException e) {
            call.reject("Error checking version", e);
        }
    }

    private void bindToBazaarUpdateService() {
        Intent intent = new Intent("com.farsitel.bazaar.service.UpdateCheckService.BIND");
        intent.setPackage("com.farsitel.bazaar");
        getContext().bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }

    private JSObject createResponse(String message, boolean updateAvailable) {
        JSObject result = new JSObject();
        result.put("message", message);
        result.put("updateAvailable", updateAvailable);
        return result;
    }
}

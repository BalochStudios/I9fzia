package com.maps.i9fzia;

import android.app.Application;

import com.onesignal.OneSignal;

public class App extends Application {
    private static final String ONESIGNAL_APP_ID = "b1de3d1e-55f2-4aad-a5bf-f667c876ff06";
    @Override
    public void onCreate() {
        super.onCreate();
        // Enable verbose OneSignal logging to debug issues if needed.
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);

        // OneSignal Initialization
        OneSignal.initWithContext(this);
        OneSignal.setAppId(ONESIGNAL_APP_ID);
    }
}

package com.coinbase.android.idfa;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableMap;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import e.g.a.e.a.a.a;
import java.io.IOException;

/* loaded from: classes.dex */
public class RNIDFAThread implements Runnable {
    ReactApplicationContext context;
    Promise result;

    public RNIDFAThread(ReactApplicationContext reactApplicationContext, Promise promise) {
        this.context = reactApplicationContext;
        this.result = promise;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            a.C0299a b2 = a.b(this.context);
            WritableMap createMap = Arguments.createMap();
            createMap.putString("advertisingId", b2.a());
            createMap.putBoolean("isLimitAdTrackingEnabled", b2.b());
            this.result.resolve(createMap);
        } catch (GooglePlayServicesNotAvailableException e2) {
            this.result.reject(e2);
        } catch (GooglePlayServicesRepairableException e3) {
            this.result.reject(e3);
        } catch (IOException e4) {
            this.result.reject(e4);
        }
    }
}
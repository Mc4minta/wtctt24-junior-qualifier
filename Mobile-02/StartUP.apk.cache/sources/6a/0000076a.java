package com.bugsnag;

import android.content.Context;
import com.bugsnag.android.BreadcrumbType;
import com.bugsnag.android.j;
import com.bugsnag.android.m0;
import com.bugsnag.android.n0;
import com.bugsnag.android.q;
import com.bugsnag.android.s;
import com.bugsnag.android.t0;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.features.send.models.SendConfirmationArgs;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import e.f.m.p;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import org.apache.http.cookie.ClientCookie;

/* loaded from: classes.dex */
public class BugsnagReactNative extends ReactContextBaseJavaModule {
    public static final Logger logger = Logger.getLogger("bugsnag-react-native");
    private String bugsnagAndroidVersion;
    private String libraryVersion;
    private ReactContext reactContext;

    public BugsnagReactNative(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.reactContext = reactApplicationContext;
        this.libraryVersion = null;
        this.bugsnagAndroidVersion = null;
    }

    private void configureRuntimeOptions(q qVar, ReadableMap readableMap) {
        ReadableArray array;
        String string;
        String string2;
        String string3;
        qVar.J("com.facebook.react.common.JavascriptException");
        s l2 = qVar.l();
        if (readableMap.hasKey("appVersion") && (string3 = readableMap.getString("appVersion")) != null && string3.length() > 0) {
            qVar.F(string3);
        }
        String string4 = readableMap.hasKey("endpoint") ? readableMap.getString("endpoint") : null;
        String string5 = readableMap.hasKey("sessionsEndpoint") ? readableMap.getString("sessionsEndpoint") : null;
        if (string4 != null && string4.length() > 0) {
            l2.O(string4, string5);
        } else if (string5 != null && string5.length() > 0) {
            logger.warning("The session tracking endpoint should not be set without the error reporting endpoint.");
        }
        if (readableMap.hasKey("releaseStage") && (string2 = readableMap.getString("releaseStage")) != null && string2.length() > 0) {
            qVar.M(string2);
        }
        if (readableMap.hasKey("autoNotify")) {
            if (readableMap.getBoolean("autoNotify")) {
                qVar.i();
            } else {
                qVar.h();
            }
        }
        if (readableMap.hasKey("codeBundleId") && (string = readableMap.getString("codeBundleId")) != null && string.length() > 0) {
            qVar.b("app", "codeBundleId", string);
        }
        if (readableMap.hasKey("notifyReleaseStages") && (array = readableMap.getArray("notifyReleaseStages")) != null && array.size() > 0) {
            String[] strArr = new String[array.size()];
            for (int i2 = 0; i2 < array.size(); i2++) {
                strArr[i2] = array.getString(i2);
            }
            qVar.K(strArr);
        }
        if (readableMap.hasKey("automaticallyCollectBreadcrumbs")) {
            l2.G(readableMap.getBoolean("automaticallyCollectBreadcrumbs"));
        }
        if (readableMap.hasKey("autoCaptureSessions")) {
            boolean z = readableMap.getBoolean("autoCaptureSessions");
            l2.F(z);
            if (z) {
                qVar.A();
            }
        }
    }

    private q getClient(String str) {
        try {
            return j.b();
        } catch (IllegalStateException unused) {
            if (str != null) {
                return j.e(this.reactContext, str);
            }
            return j.c(this.reactContext);
        }
    }

    public static p getPackage() {
        return new a();
    }

    private BreadcrumbType parseBreadcrumbType(String str) {
        BreadcrumbType[] values;
        for (BreadcrumbType breadcrumbType : BreadcrumbType.values()) {
            if (breadcrumbType.toString().equals(str)) {
                return breadcrumbType;
            }
        }
        return BreadcrumbType.MANUAL;
    }

    private Map<String, String> readStringMap(ReadableMap readableMap) {
        HashMap hashMap = new HashMap();
        ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            ReadableMap map = readableMap.getMap(nextKey);
            String string = map.getString("type");
            string.hashCode();
            char c2 = 65535;
            switch (string.hashCode()) {
                case -1034364087:
                    if (string.equals("number")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -891985903:
                    if (string.equals("string")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 107868:
                    if (string.equals("map")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 64711720:
                    if (string.equals("boolean")) {
                        c2 = 3;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    hashMap.put(nextKey, String.valueOf(map.getDouble("value")));
                    break;
                case 1:
                    hashMap.put(nextKey, map.getString("value"));
                    break;
                case 2:
                    hashMap.put(nextKey, String.valueOf(readStringMap(map.getMap("value"))));
                    break;
                case 3:
                    hashMap.put(nextKey, String.valueOf(map.getBoolean("value")));
                    break;
            }
        }
        return hashMap;
    }

    public static q start(Context context) {
        q c2 = j.c(context);
        c2.G(false);
        return c2;
    }

    public static q startWithApiKey(Context context, String str) {
        q e2 = j.e(context, str);
        e2.G(false);
        return e2;
    }

    public static q startWithConfiguration(Context context, s sVar) {
        sVar.F(false);
        return j.d(context, sVar);
    }

    @ReactMethod
    public void clearUser() {
        j.a();
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "BugsnagReactNative";
    }

    @ReactMethod
    public void leaveBreadcrumb(ReadableMap readableMap) {
        j.h(readableMap.getString(ApiConstants.NAME), parseBreadcrumbType(readableMap.getString("type")), readStringMap(readableMap.getMap(SendConfirmationArgs.metadataKey)));
    }

    @ReactMethod
    public void notify(ReadableMap readableMap, Promise promise) {
        if (!readableMap.hasKey("errorClass")) {
            logger.warning("Bugsnag could not notify: No error class");
        } else if (!readableMap.hasKey("stacktrace")) {
            logger.warning("Bugsnag could not notify: No stacktrace");
        } else {
            String string = readableMap.getString("errorClass");
            String string2 = readableMap.getString("errorMessage");
            String string3 = readableMap.getString("stacktrace");
            boolean z = false;
            logger.info(String.format("Sending exception: %s - %s %s\n", string, string2, string3));
            n0 n0Var = new n0(string, string2, string3);
            b bVar = new b(this.libraryVersion, this.bugsnagAndroidVersion, readableMap);
            HashMap hashMap = new HashMap();
            String string4 = readableMap.getString("severity");
            String string5 = readableMap.getString("severityReason");
            hashMap.put("severity", string4);
            hashMap.put("severityReason", string5);
            if (readableMap.hasKey("blocking") && readableMap.getBoolean("blocking")) {
                z = true;
            }
            j.g(n0Var, hashMap, z, bVar);
            if (promise != null) {
                promise.resolve(null);
            }
        }
    }

    @ReactMethod
    public void resumeSession() {
        j.j();
    }

    @ReactMethod
    public void setUser(ReadableMap readableMap) {
        j.k(readableMap.hasKey("id") ? readableMap.getString("id") : null, readableMap.hasKey("email") ? readableMap.getString("email") : null, readableMap.hasKey(ApiConstants.NAME) ? readableMap.getString(ApiConstants.NAME) : null);
    }

    @ReactMethod
    public void startSession() {
        j.l();
    }

    @ReactMethod
    public void startWithOptions(ReadableMap readableMap) {
        q client = getClient(readableMap.hasKey("apiKey") ? readableMap.getString("apiKey") : null);
        this.libraryVersion = readableMap.getString(ClientCookie.VERSION_ATTR);
        this.bugsnagAndroidVersion = t0.a().c();
        configureRuntimeOptions(client, readableMap);
        m0.a(client);
        logger.info(String.format("Initialized Bugsnag React Native %s/Android %s", this.libraryVersion, this.bugsnagAndroidVersion));
    }

    @ReactMethod
    public void stopSession() {
        j.m();
    }
}
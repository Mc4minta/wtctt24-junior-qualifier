package com.dieam.reactnativepushnotification.modules;

import android.os.Build;
import android.os.Bundle;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: RNPushNotificationJsDelivery.java */
/* loaded from: classes2.dex */
public class e {
    private ReactContext a;

    public e(ReactContext reactContext) {
        this.a = reactContext;
    }

    private JSONObject b(Bundle bundle) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj instanceof Bundle) {
                jSONObject.put(str, b((Bundle) obj));
            } else if (Build.VERSION.SDK_INT >= 19) {
                jSONObject.put(str, JSONObject.wrap(obj));
            } else {
                jSONObject.put(str, obj);
            }
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(Bundle bundle) {
        try {
            return b(bundle).toString();
        } catch (JSONException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(Bundle bundle) {
        String a = a(bundle);
        WritableMap createMap = Arguments.createMap();
        createMap.putString("dataJSON", a);
        d("remoteNotificationReceived", createMap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(String str, Object obj) {
        if (this.a.hasActiveCatalystInstance()) {
            ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.a.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(str, obj);
        }
    }
}
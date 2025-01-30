package com.bugsnag;

import com.bugsnag.android.Severity;
import com.bugsnag.android.p;
import com.bugsnag.android.s0;
import com.bugsnag.android.v0;
import com.coinbase.wallet.features.send.models.SendConfirmationArgs;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import java.util.HashMap;
import java.util.Map;

/* compiled from: DiagnosticsCallback.java */
/* loaded from: classes.dex */
class b implements p {
    private final Severity a;

    /* renamed from: b  reason: collision with root package name */
    private final String f3744b;

    /* renamed from: c  reason: collision with root package name */
    private final String f3745c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, Object> f3746d;

    /* renamed from: e  reason: collision with root package name */
    private final String f3747e;

    /* renamed from: f  reason: collision with root package name */
    private final String f3748f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(String str, String str2, ReadableMap readableMap) {
        this.f3747e = str;
        this.f3748f = str2;
        this.a = b(readableMap.getString("severity"));
        this.f3746d = c(readableMap.getMap(SendConfirmationArgs.metadataKey));
        if (readableMap.hasKey("context")) {
            this.f3744b = readableMap.getString("context");
        } else {
            this.f3744b = null;
        }
        if (readableMap.hasKey("groupingHash")) {
            this.f3745c = readableMap.getString("groupingHash");
        } else {
            this.f3745c = null;
        }
    }

    @Override // com.bugsnag.android.p
    public void a(v0 v0Var) {
        v0Var.b().d("Bugsnag for React Native");
        v0Var.b().e("https://github.com/bugsnag/bugsnag-react-native");
        v0Var.b().f(String.format("%s (Android %s)", this.f3747e, this.f3748f));
        String str = this.f3745c;
        if (str != null && str.length() > 0) {
            v0Var.a().o(this.f3745c);
        }
        String str2 = this.f3744b;
        if (str2 != null && str2.length() > 0) {
            v0Var.a().l(this.f3744b);
        }
        if (this.f3746d != null) {
            s0 h2 = v0Var.a().h();
            for (String str3 : this.f3746d.keySet()) {
                Object obj = this.f3746d.get(str3);
                if (obj instanceof Map) {
                    Map map = (Map) obj;
                    for (String str4 : map.keySet()) {
                        h2.a(str3, str4, map.get(str4));
                    }
                }
            }
        }
    }

    Severity b(String str) {
        char c2;
        int hashCode = str.hashCode();
        if (hashCode == 3237038) {
            if (str.equals("info")) {
                c2 = 1;
            }
            c2 = 65535;
        } else if (hashCode != 96784904) {
            if (hashCode == 1124446108 && str.equals("warning")) {
                c2 = 2;
            }
            c2 = 65535;
        } else {
            if (str.equals("error")) {
                c2 = 0;
            }
            c2 = 65535;
        }
        if (c2 != 0) {
            if (c2 != 1) {
                return Severity.WARNING;
            }
            return Severity.INFO;
        }
        return Severity.ERROR;
    }

    Map<String, Object> c(ReadableMap readableMap) {
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
                    hashMap.put(nextKey, Double.valueOf(map.getDouble("value")));
                    break;
                case 1:
                    hashMap.put(nextKey, map.getString("value"));
                    break;
                case 2:
                    hashMap.put(nextKey, c(map.getMap("value")));
                    break;
                case 3:
                    hashMap.put(nextKey, Boolean.valueOf(map.getBoolean("value")));
                    break;
            }
        }
        return hashMap;
    }
}
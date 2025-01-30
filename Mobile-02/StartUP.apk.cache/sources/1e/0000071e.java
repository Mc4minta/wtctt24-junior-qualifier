package com.appsflyer.internal;

import com.appsflyer.AFLogger;

/* loaded from: classes.dex */
public final class ag {

    /* renamed from: ı  reason: contains not printable characters */
    private a f169 = new a() { // from class: com.appsflyer.internal.ag.2
        @Override // com.appsflyer.internal.ag.a
        /* renamed from: ǃ  reason: contains not printable characters */
        public final Class<?> mo130(String str) throws ClassNotFoundException {
            return Class.forName(str);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        /* renamed from: ǃ */
        Class<?> mo130(String str) throws ClassNotFoundException;
    }

    /* loaded from: classes.dex */
    enum c {
        UNITY("android_unity", "com.unity3d.player.UnityPlayer"),
        REACT_NATIVE("android_reactNative", "com.facebook.react.ReactApplication"),
        CORDOVA("android_cordova", "org.apache.cordova.CordovaActivity"),
        SEGMENT("android_segment", "com.segment.analytics.integrations.Integration"),
        COCOS2DX("android_cocos2dx", "org.cocos2dx.lib.Cocos2dxActivity"),
        DEFAULT("android_native", "android_native"),
        ADOBE_EX("android_adobe_ex", "com.appsflyer.adobeextension"),
        FLUTTER("android_flutter", "com.appsflyer.appsflyersdk.AppsflyerSdkPlugin");
        

        /* renamed from: і  reason: contains not printable characters */
        private String f179;

        /* renamed from: Ӏ  reason: contains not printable characters */
        private String f180;

        c(String str, String str2) {
            this.f180 = str;
            this.f179 = str2;
        }
    }

    /* renamed from: ι  reason: contains not printable characters */
    private boolean m128(String str) {
        try {
            this.f169.mo130(str);
            StringBuilder sb = new StringBuilder("Class: ");
            sb.append(str);
            sb.append(" is found.");
            AFLogger.afRDLog(sb.toString());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        } catch (Throwable th) {
            AFLogger.afErrorLog(th.getMessage(), th);
            return false;
        }
    }

    /* renamed from: ı  reason: contains not printable characters */
    public final String m129() {
        c[] values;
        for (c cVar : c.values()) {
            if (m128(cVar.f179)) {
                return cVar.f180;
            }
        }
        return c.DEFAULT.f180;
    }
}
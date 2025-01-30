package com.google.firebase.remoteconfig.internal;

import android.util.Log;
import java.nio.charset.Charset;
import java.util.regex.Pattern;
import org.json.JSONException;

/* compiled from: com.google.firebase:firebase-config@@19.0.4 */
/* loaded from: classes2.dex */
public class k {
    public static final Charset a = Charset.forName("UTF-8");

    /* renamed from: b  reason: collision with root package name */
    static final Pattern f9447b = Pattern.compile("^(1|true|t|yes|y|on)$", 2);

    /* renamed from: c  reason: collision with root package name */
    static final Pattern f9448c = Pattern.compile("^(0|false|f|no|n|off|)$", 2);

    /* renamed from: d  reason: collision with root package name */
    private final e f9449d;

    /* renamed from: e  reason: collision with root package name */
    private final e f9450e;

    public k(e eVar, e eVar2) {
        this.f9449d = eVar;
        this.f9450e = eVar2;
    }

    private static f a(e eVar) {
        return eVar.d();
    }

    private static String b(e eVar, String str) {
        f a2 = a(eVar);
        if (a2 == null) {
            return null;
        }
        try {
            return a2.d().getString(str);
        } catch (JSONException unused) {
            return null;
        }
    }

    private static void d(String str, String str2) {
        Log.w("FirebaseRemoteConfig", String.format("No value of type '%s' exists for parameter key '%s'.", str2, str));
    }

    public com.google.firebase.remoteconfig.h c(String str) {
        String b2 = b(this.f9449d, str);
        if (b2 != null) {
            return new o(b2, 2);
        }
        String b3 = b(this.f9450e, str);
        if (b3 != null) {
            return new o(b3, 1);
        }
        d(str, "FirebaseRemoteConfigValue");
        return new o("", 0);
    }
}
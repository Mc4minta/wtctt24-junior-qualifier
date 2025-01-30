package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class c2 implements n1 {
    private static final Map<String, c2> a = new c.e.a();

    /* renamed from: b  reason: collision with root package name */
    private final SharedPreferences f7062b;

    /* renamed from: c  reason: collision with root package name */
    private final SharedPreferences.OnSharedPreferenceChangeListener f7063c;

    /* renamed from: d  reason: collision with root package name */
    private final Object f7064d;

    /* renamed from: e  reason: collision with root package name */
    private volatile Map<String, ?> f7065e;

    /* renamed from: f  reason: collision with root package name */
    private final List<k1> f7066f;

    private c2(SharedPreferences sharedPreferences) {
        SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener(this) { // from class: com.google.android.gms.internal.measurement.f2
            private final c2 a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
            }

            @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
            public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences2, String str) {
                this.a.c(sharedPreferences2, str);
            }
        };
        this.f7063c = onSharedPreferenceChangeListener;
        this.f7064d = new Object();
        this.f7066f = new ArrayList();
        this.f7062b = sharedPreferences;
        sharedPreferences.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c2 a(Context context, String str) {
        c2 c2Var;
        if ((!f1.a() || str.startsWith("direct_boot:")) ? true : f1.b(context)) {
            synchronized (c2.class) {
                Map<String, c2> map = a;
                c2Var = map.get(str);
                if (c2Var == null) {
                    c2Var = new c2(d(context, str));
                    map.put(str, c2Var);
                }
            }
            return c2Var;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void b() {
        synchronized (c2.class) {
            for (c2 c2Var : a.values()) {
                c2Var.f7062b.unregisterOnSharedPreferenceChangeListener(c2Var.f7063c);
            }
            a.clear();
        }
    }

    private static SharedPreferences d(Context context, String str) {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            if (str.startsWith("direct_boot:")) {
                if (f1.a()) {
                    context = context.createDeviceProtectedStorageContext();
                }
                return context.getSharedPreferences(str.substring(12), 0);
            }
            return context.getSharedPreferences(str, 0);
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void c(SharedPreferences sharedPreferences, String str) {
        synchronized (this.f7064d) {
            this.f7065e = null;
            x1.g();
        }
        synchronized (this) {
            for (k1 k1Var : this.f7066f) {
                k1Var.a();
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.n1
    public final Object f(String str) {
        Map<String, ?> map = this.f7065e;
        if (map == null) {
            synchronized (this.f7064d) {
                map = this.f7065e;
                if (map == null) {
                    StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    Map<String, ?> all = this.f7062b.getAll();
                    this.f7065e = all;
                    StrictMode.setThreadPolicy(allowThreadDiskReads);
                    map = all;
                }
            }
        }
        if (map != null) {
            return map.get(str);
        }
        return null;
    }
}
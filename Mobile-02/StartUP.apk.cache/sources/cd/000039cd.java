package com.google.firebase.crashlytics.c.g;

import android.content.SharedPreferences;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
public class q {

    /* renamed from: c  reason: collision with root package name */
    boolean f8781c;

    /* renamed from: d  reason: collision with root package name */
    private final SharedPreferences f8782d;

    /* renamed from: e  reason: collision with root package name */
    private volatile boolean f8783e;

    /* renamed from: f  reason: collision with root package name */
    private volatile boolean f8784f;

    /* renamed from: g  reason: collision with root package name */
    private final com.google.firebase.c f8785g;
    private Object a = new Object();

    /* renamed from: b  reason: collision with root package name */
    com.google.android.gms.tasks.h<Void> f8780b = new com.google.android.gms.tasks.h<>();

    /* renamed from: h  reason: collision with root package name */
    private com.google.android.gms.tasks.h<Void> f8786h = new com.google.android.gms.tasks.h<>();

    /* JADX WARN: Removed duplicated region for block: B:33:0x0073 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public q(com.google.firebase.c r5) {
        /*
            r4 = this;
            r4.<init>()
            java.lang.Object r0 = new java.lang.Object
            r0.<init>()
            r4.a = r0
            com.google.android.gms.tasks.h r0 = new com.google.android.gms.tasks.h
            r0.<init>()
            r4.f8780b = r0
            r0 = 0
            r4.f8781c = r0
            com.google.android.gms.tasks.h r1 = new com.google.android.gms.tasks.h
            r1.<init>()
            r4.f8786h = r1
            r4.f8785g = r5
            android.content.Context r5 = r5.g()
            if (r5 == 0) goto L86
            android.content.SharedPreferences r1 = com.google.firebase.crashlytics.c.g.h.t(r5)
            r4.f8782d = r1
            java.lang.String r2 = "firebase_crashlytics_collection_enabled"
            boolean r2 = r1.contains(r2)
            r3 = 1
            if (r2 == 0) goto L3a
            java.lang.String r5 = "firebase_crashlytics_collection_enabled"
            boolean r5 = r1.getBoolean(r5, r3)
        L38:
            r0 = r3
            goto L6c
        L3a:
            android.content.pm.PackageManager r1 = r5.getPackageManager()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L61
            if (r1 == 0) goto L6b
            java.lang.String r5 = r5.getPackageName()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L61
            r2 = 128(0x80, float:1.8E-43)
            android.content.pm.ApplicationInfo r5 = r1.getApplicationInfo(r5, r2)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L61
            if (r5 == 0) goto L6b
            android.os.Bundle r1 = r5.metaData     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L61
            if (r1 == 0) goto L6b
            java.lang.String r2 = "firebase_crashlytics_collection_enabled"
            boolean r1 = r1.containsKey(r2)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L61
            if (r1 == 0) goto L6b
            android.os.Bundle r5 = r5.metaData     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L61
            java.lang.String r1 = "firebase_crashlytics_collection_enabled"
            boolean r5 = r5.getBoolean(r1)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L61
            goto L38
        L61:
            r5 = move-exception
            com.google.firebase.crashlytics.c.b r1 = com.google.firebase.crashlytics.c.b.f()
            java.lang.String r2 = "Unable to get PackageManager. Falling through"
            r1.c(r2, r5)
        L6b:
            r5 = r3
        L6c:
            r4.f8784f = r5
            r4.f8783e = r0
            java.lang.Object r5 = r4.a
            monitor-enter(r5)
            boolean r0 = r4.b()     // Catch: java.lang.Throwable -> L83
            if (r0 == 0) goto L81
            com.google.android.gms.tasks.h<java.lang.Void> r0 = r4.f8780b     // Catch: java.lang.Throwable -> L83
            r1 = 0
            r0.e(r1)     // Catch: java.lang.Throwable -> L83
            r4.f8781c = r3     // Catch: java.lang.Throwable -> L83
        L81:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L83
            return
        L83:
            r0 = move-exception
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L83
            throw r0
        L86:
            java.lang.RuntimeException r5 = new java.lang.RuntimeException
            java.lang.String r0 = "null context"
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.c.g.q.<init>(com.google.firebase.c):void");
    }

    public void a(boolean z) {
        if (z) {
            this.f8786h.e(null);
            return;
        }
        throw new IllegalStateException("An invalid data collection token was used.");
    }

    public boolean b() {
        if (this.f8783e) {
            return this.f8784f;
        }
        return this.f8785g.p();
    }

    public com.google.android.gms.tasks.g<Void> c() {
        com.google.android.gms.tasks.g<Void> a;
        synchronized (this.a) {
            a = this.f8780b.a();
        }
        return a;
    }

    public com.google.android.gms.tasks.g<Void> d() {
        return h0.g(this.f8786h.a(), c());
    }
}
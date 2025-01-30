package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.database.ContentObserver;
import android.util.Log;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class o1 implements n1 {
    private static o1 a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f7275b;

    /* renamed from: c  reason: collision with root package name */
    private final ContentObserver f7276c;

    private o1(Context context) {
        this.f7275b = context;
        q1 q1Var = new q1(this, null);
        this.f7276c = q1Var;
        context.getContentResolver().registerContentObserver(e1.a, true, q1Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static o1 a(Context context) {
        o1 o1Var;
        synchronized (o1.class) {
            if (a == null) {
                a = androidx.core.content.c.c(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0 ? new o1(context) : new o1();
            }
            o1Var = a;
        }
        return o1Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void b() {
        Context context;
        synchronized (o1.class) {
            o1 o1Var = a;
            if (o1Var != null && (context = o1Var.f7275b) != null && o1Var.f7276c != null) {
                context.getContentResolver().unregisterContentObserver(a.f7276c);
            }
            a = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.measurement.n1
    /* renamed from: d */
    public final String f(String str) {
        if (this.f7275b == null) {
            return null;
        }
        try {
            return (String) m1.a(new p1(this, str) { // from class: com.google.android.gms.internal.measurement.r1
                private final o1 a;

                /* renamed from: b  reason: collision with root package name */
                private final String f7330b;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.a = this;
                    this.f7330b = str;
                }

                @Override // com.google.android.gms.internal.measurement.p1
                public final Object a() {
                    return this.a.c(this.f7330b);
                }
            });
        } catch (IllegalStateException | SecurityException e2) {
            String valueOf = String.valueOf(str);
            Log.e("GservicesLoader", valueOf.length() != 0 ? "Unable to read GServices for: ".concat(valueOf) : new String("Unable to read GServices for: "), e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ String c(String str) {
        return e1.a(this.f7275b.getContentResolver(), str, null);
    }

    private o1() {
        this.f7275b = null;
        this.f7276c = null;
    }
}
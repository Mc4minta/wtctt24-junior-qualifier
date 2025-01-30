package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class q3<V> {
    private static final Object a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final String f7802b;

    /* renamed from: c  reason: collision with root package name */
    private final o3<V> f7803c;

    /* renamed from: d  reason: collision with root package name */
    private final V f7804d;

    /* renamed from: e  reason: collision with root package name */
    private final V f7805e;

    /* renamed from: f  reason: collision with root package name */
    private final Object f7806f;

    /* renamed from: g  reason: collision with root package name */
    private volatile V f7807g;

    /* renamed from: h  reason: collision with root package name */
    private volatile V f7808h;

    private q3(String str, V v, V v2, o3<V> o3Var) {
        this.f7806f = new Object();
        this.f7807g = null;
        this.f7808h = null;
        this.f7802b = str;
        this.f7804d = v;
        this.f7805e = v2;
        this.f7803c = o3Var;
    }

    public final V a(V v) {
        synchronized (this.f7806f) {
        }
        if (v != null) {
            return v;
        }
        if (n3.a == null) {
            return this.f7804d;
        }
        synchronized (a) {
            if (ja.a()) {
                return this.f7808h == null ? this.f7804d : this.f7808h;
            }
            try {
                for (q3 q3Var : r.u0()) {
                    if (!ja.a()) {
                        V v2 = null;
                        try {
                            o3<V> o3Var = q3Var.f7803c;
                            if (o3Var != null) {
                                v2 = o3Var.a();
                            }
                        } catch (IllegalStateException unused) {
                        }
                        synchronized (a) {
                            q3Var.f7808h = v2;
                        }
                    } else {
                        throw new IllegalStateException("Refreshing flag cache must be done on a worker thread.");
                    }
                }
            } catch (SecurityException unused2) {
            }
            o3<V> o3Var2 = this.f7803c;
            if (o3Var2 == null) {
                return this.f7804d;
            }
            try {
                return o3Var2.a();
            } catch (IllegalStateException unused3) {
                return this.f7804d;
            } catch (SecurityException unused4) {
                return this.f7804d;
            }
        }
    }

    public final String b() {
        return this.f7802b;
    }
}
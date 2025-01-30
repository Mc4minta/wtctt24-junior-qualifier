package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
/* loaded from: classes2.dex */
public class c5 {
    private static final z3 a = z3.a();

    /* renamed from: b  reason: collision with root package name */
    private h3 f7073b;

    /* renamed from: c  reason: collision with root package name */
    private volatile u5 f7074c;

    /* renamed from: d  reason: collision with root package name */
    private volatile h3 f7075d;

    private final u5 c(u5 u5Var) {
        if (this.f7074c == null) {
            synchronized (this) {
                if (this.f7074c == null) {
                    try {
                        this.f7074c = u5Var;
                        this.f7075d = h3.a;
                    } catch (zzfm unused) {
                        this.f7074c = u5Var;
                        this.f7075d = h3.a;
                    }
                }
            }
        }
        return this.f7074c;
    }

    public final u5 a(u5 u5Var) {
        u5 u5Var2 = this.f7074c;
        this.f7073b = null;
        this.f7075d = null;
        this.f7074c = u5Var;
        return u5Var2;
    }

    public final int b() {
        if (this.f7075d != null) {
            return this.f7075d.i();
        }
        if (this.f7074c != null) {
            return this.f7074c.i();
        }
        return 0;
    }

    public final h3 d() {
        if (this.f7075d != null) {
            return this.f7075d;
        }
        synchronized (this) {
            if (this.f7075d != null) {
                return this.f7075d;
            }
            if (this.f7074c == null) {
                this.f7075d = h3.a;
            } else {
                this.f7075d = this.f7074c.d();
            }
            return this.f7075d;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c5) {
            c5 c5Var = (c5) obj;
            u5 u5Var = this.f7074c;
            u5 u5Var2 = c5Var.f7074c;
            if (u5Var == null && u5Var2 == null) {
                return d().equals(c5Var.d());
            }
            if (u5Var == null || u5Var2 == null) {
                if (u5Var != null) {
                    return u5Var.equals(c5Var.c(u5Var.b()));
                }
                return c(u5Var2.b()).equals(u5Var2);
            }
            return u5Var.equals(u5Var2);
        }
        return false;
    }

    public int hashCode() {
        return 1;
    }
}
package com.google.android.gms.internal.clearcut;

/* loaded from: classes2.dex */
public class p1 {
    private static final q0 a = q0.b();

    /* renamed from: b  reason: collision with root package name */
    private a0 f6530b;

    /* renamed from: c  reason: collision with root package name */
    private volatile i2 f6531c;

    /* renamed from: d  reason: collision with root package name */
    private volatile a0 f6532d;

    private final i2 b(i2 i2Var) {
        if (this.f6531c == null) {
            synchronized (this) {
                if (this.f6531c == null) {
                    try {
                        this.f6531c = i2Var;
                        this.f6532d = a0.a;
                    } catch (zzco unused) {
                        this.f6531c = i2Var;
                        this.f6532d = a0.a;
                    }
                }
            }
        }
        return this.f6531c;
    }

    public final int a() {
        if (this.f6532d != null) {
            return this.f6532d.size();
        }
        if (this.f6531c != null) {
            return this.f6531c.l();
        }
        return 0;
    }

    public final i2 c(i2 i2Var) {
        i2 i2Var2 = this.f6531c;
        this.f6530b = null;
        this.f6532d = null;
        this.f6531c = i2Var;
        return i2Var2;
    }

    public final a0 d() {
        if (this.f6532d != null) {
            return this.f6532d;
        }
        synchronized (this) {
            if (this.f6532d != null) {
                return this.f6532d;
            }
            this.f6532d = this.f6531c == null ? a0.a : this.f6531c.f();
            return this.f6532d;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof p1) {
            p1 p1Var = (p1) obj;
            i2 i2Var = this.f6531c;
            i2 i2Var2 = p1Var.f6531c;
            return (i2Var == null && i2Var2 == null) ? d().equals(p1Var.d()) : (i2Var == null || i2Var2 == null) ? i2Var != null ? i2Var.equals(p1Var.b(i2Var.b())) : b(i2Var2.b()).equals(i2Var2) : i2Var.equals(i2Var2);
        }
        return false;
    }

    public int hashCode() {
        return 1;
    }
}
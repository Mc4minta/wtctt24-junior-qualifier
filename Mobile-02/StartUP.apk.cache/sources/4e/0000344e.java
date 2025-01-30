package com.google.android.gms.internal.p000firebaseperf;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.z4  reason: invalid package */
/* loaded from: classes2.dex */
public class z4 {
    private static final z3 a = z3.a();

    /* renamed from: b  reason: collision with root package name */
    private i3 f7003b;

    /* renamed from: c  reason: collision with root package name */
    private volatile v5 f7004c;

    /* renamed from: d  reason: collision with root package name */
    private volatile i3 f7005d;

    private final v5 b(v5 v5Var) {
        if (this.f7004c == null) {
            synchronized (this) {
                if (this.f7004c == null) {
                    try {
                        this.f7004c = v5Var;
                        this.f7005d = i3.a;
                    } catch (zzfs unused) {
                        this.f7004c = v5Var;
                        this.f7005d = i3.a;
                    }
                }
            }
        }
        return this.f7004c;
    }

    public final int a() {
        if (this.f7005d != null) {
            return this.f7005d.size();
        }
        if (this.f7004c != null) {
            return this.f7004c.getSerializedSize();
        }
        return 0;
    }

    public final i3 c() {
        if (this.f7005d != null) {
            return this.f7005d;
        }
        synchronized (this) {
            if (this.f7005d != null) {
                return this.f7005d;
            }
            if (this.f7004c == null) {
                this.f7005d = i3.a;
            } else {
                this.f7005d = this.f7004c.c();
            }
            return this.f7005d;
        }
    }

    public final v5 d(v5 v5Var) {
        v5 v5Var2 = this.f7004c;
        this.f7003b = null;
        this.f7005d = null;
        this.f7004c = v5Var;
        return v5Var2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof z4) {
            z4 z4Var = (z4) obj;
            v5 v5Var = this.f7004c;
            v5 v5Var2 = z4Var.f7004c;
            if (v5Var == null && v5Var2 == null) {
                return c().equals(z4Var.c());
            }
            if (v5Var == null || v5Var2 == null) {
                if (v5Var != null) {
                    return v5Var.equals(z4Var.b(v5Var.d()));
                }
                return b(v5Var2.d()).equals(v5Var2);
            }
            return v5Var.equals(v5Var2);
        }
        return false;
    }

    public int hashCode() {
        return 1;
    }
}
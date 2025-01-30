package com.facebook.imagepipeline.common;

/* compiled from: RotationOptions.java */
/* loaded from: classes2.dex */
public class f {
    private static final f a = new f(-1, false);

    /* renamed from: b  reason: collision with root package name */
    private static final f f4532b = new f(-2, false);

    /* renamed from: c  reason: collision with root package name */
    private static final f f4533c = new f(-1, true);

    /* renamed from: d  reason: collision with root package name */
    private final int f4534d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f4535e;

    private f(int i2, boolean z) {
        this.f4534d = i2;
        this.f4535e = z;
    }

    public static f a() {
        return a;
    }

    public static f b() {
        return f4533c;
    }

    public static f d() {
        return f4532b;
    }

    public boolean c() {
        return this.f4535e;
    }

    public int e() {
        if (!g()) {
            return this.f4534d;
        }
        throw new IllegalStateException("Rotation is set to use EXIF");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            return this.f4534d == fVar.f4534d && this.f4535e == fVar.f4535e;
        }
        return false;
    }

    public boolean f() {
        return this.f4534d != -2;
    }

    public boolean g() {
        return this.f4534d == -1;
    }

    public int hashCode() {
        return com.facebook.common.util.a.c(Integer.valueOf(this.f4534d), Boolean.valueOf(this.f4535e));
    }

    public String toString() {
        return String.format(null, "%d defer:%b", Integer.valueOf(this.f4534d), Boolean.valueOf(this.f4535e));
    }
}
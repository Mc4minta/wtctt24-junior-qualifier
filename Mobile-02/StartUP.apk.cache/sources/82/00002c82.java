package com.facebook.imagepipeline.common;

import e.f.d.c.i;

/* compiled from: ResizeOptions.java */
/* loaded from: classes2.dex */
public class e {
    public final int a;

    /* renamed from: b  reason: collision with root package name */
    public final int f4529b;

    /* renamed from: c  reason: collision with root package name */
    public final float f4530c;

    /* renamed from: d  reason: collision with root package name */
    public final float f4531d;

    public e(int i2, int i3) {
        this(i2, i3, 2048.0f);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            return this.a == eVar.a && this.f4529b == eVar.f4529b;
        }
        return false;
    }

    public int hashCode() {
        return com.facebook.common.util.a.a(this.a, this.f4529b);
    }

    public String toString() {
        return String.format(null, "%dx%d", Integer.valueOf(this.a), Integer.valueOf(this.f4529b));
    }

    public e(int i2, int i3, float f2) {
        this(i2, i3, f2, 0.6666667f);
    }

    public e(int i2, int i3, float f2, float f3) {
        i.b(i2 > 0);
        i.b(i3 > 0);
        this.a = i2;
        this.f4529b = i3;
        this.f4530c = f2;
        this.f4531d = f3;
    }
}
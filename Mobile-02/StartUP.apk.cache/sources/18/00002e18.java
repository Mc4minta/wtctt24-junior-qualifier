package com.facebook.react.fabric.mounting.mountitems;

import android.annotation.TargetApi;

/* compiled from: UpdateLayoutMountItem.java */
/* loaded from: classes2.dex */
public class m implements g {
    private final int a;

    /* renamed from: b  reason: collision with root package name */
    private final int f4832b;

    /* renamed from: c  reason: collision with root package name */
    private final int f4833c;

    /* renamed from: d  reason: collision with root package name */
    private final int f4834d;

    /* renamed from: e  reason: collision with root package name */
    private final int f4835e;

    /* renamed from: f  reason: collision with root package name */
    private final int f4836f;

    public m(int i2, int i3, int i4, int i5, int i6, int i7) {
        this.a = i2;
        this.f4832b = i3;
        this.f4833c = i4;
        this.f4834d = i5;
        this.f4835e = i6;
        this.f4836f = b(i7);
    }

    @TargetApi(19)
    private static int b(int i2) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 == 2) {
                    return 1;
                }
                throw new IllegalArgumentException("Unsupported layout direction: " + i2);
            }
            return 0;
        }
        return 2;
    }

    @Override // com.facebook.react.fabric.mounting.mountitems.g
    public void a(com.facebook.react.fabric.e.b bVar) {
        throw null;
    }

    public String toString() {
        return "UpdateLayoutMountItem [" + this.a + "] - x: " + this.f4832b + " - y: " + this.f4833c + " - height: " + this.f4835e + " - width: " + this.f4834d + " - layoutDirection: " + this.f4836f;
    }
}
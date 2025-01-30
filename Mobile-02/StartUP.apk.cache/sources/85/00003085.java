package com.facebook.yoga;

/* compiled from: YogaDirection.java */
/* loaded from: classes2.dex */
public enum h {
    INHERIT(0),
    LTR(1),
    RTL(2);
    

    /* renamed from: e  reason: collision with root package name */
    private final int f5677e;

    h(int i2) {
        this.f5677e = i2;
    }

    public static h h(int i2) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 == 2) {
                    return RTL;
                }
                throw new IllegalArgumentException("Unknown enum value: " + i2);
            }
            return LTR;
        }
        return INHERIT;
    }

    public int n() {
        return this.f5677e;
    }
}
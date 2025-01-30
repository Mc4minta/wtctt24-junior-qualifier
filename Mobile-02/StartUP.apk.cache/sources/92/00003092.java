package com.facebook.yoga;

/* compiled from: YogaUnit.java */
/* loaded from: classes2.dex */
public enum u {
    UNDEFINED(0),
    POINT(1),
    PERCENT(2),
    AUTO(3);
    

    /* renamed from: f  reason: collision with root package name */
    private final int f5718f;

    u(int i2) {
        this.f5718f = i2;
    }

    public static u h(int i2) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        return AUTO;
                    }
                    throw new IllegalArgumentException("Unknown enum value: " + i2);
                }
                return PERCENT;
            }
            return POINT;
        }
        return UNDEFINED;
    }

    public int n() {
        return this.f5718f;
    }
}
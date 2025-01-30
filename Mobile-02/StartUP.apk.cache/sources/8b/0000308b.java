package com.facebook.yoga;

/* compiled from: YogaMeasureMode.java */
/* loaded from: classes2.dex */
public enum n {
    UNDEFINED(0),
    EXACTLY(1),
    AT_MOST(2);
    

    /* renamed from: e  reason: collision with root package name */
    private final int f5706e;

    n(int i2) {
        this.f5706e = i2;
    }

    public static n h(int i2) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 == 2) {
                    return AT_MOST;
                }
                throw new IllegalArgumentException("Unknown enum value: " + i2);
            }
            return EXACTLY;
        }
        return UNDEFINED;
    }
}
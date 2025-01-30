package com.facebook.yoga;

/* compiled from: YogaEdge.java */
/* loaded from: classes2.dex */
public enum j {
    LEFT(0),
    TOP(1),
    RIGHT(2),
    BOTTOM(3),
    START(4),
    END(5),
    HORIZONTAL(6),
    VERTICAL(7),
    ALL(8);
    

    /* renamed from: l  reason: collision with root package name */
    private final int f5690l;

    j(int i2) {
        this.f5690l = i2;
    }

    public static j h(int i2) {
        switch (i2) {
            case 0:
                return LEFT;
            case 1:
                return TOP;
            case 2:
                return RIGHT;
            case 3:
                return BOTTOM;
            case 4:
                return START;
            case 5:
                return END;
            case 6:
                return HORIZONTAL;
            case 7:
                return VERTICAL;
            case 8:
                return ALL;
            default:
                throw new IllegalArgumentException("Unknown enum value: " + i2);
        }
    }

    public int n() {
        return this.f5690l;
    }
}
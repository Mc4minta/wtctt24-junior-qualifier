package com.facebook.react.views.scroll;

/* compiled from: ScrollEventType.java */
/* loaded from: classes2.dex */
public enum i {
    BEGIN_DRAG,
    END_DRAG,
    SCROLL,
    MOMENTUM_BEGIN,
    MOMENTUM_END;

    /* compiled from: ScrollEventType.java */
    /* loaded from: classes2.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[i.values().length];
            a = iArr;
            try {
                iArr[i.BEGIN_DRAG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[i.END_DRAG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[i.SCROLL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[i.MOMENTUM_BEGIN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[i.MOMENTUM_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static String h(i iVar) {
        int i2 = a.a[iVar.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 == 5) {
                            return "topMomentumScrollEnd";
                        }
                        throw new IllegalArgumentException("Unsupported ScrollEventType: " + iVar);
                    }
                    return "topMomentumScrollBegin";
                }
                return "topScroll";
            }
            return "topScrollEndDrag";
        }
        return "topScrollBeginDrag";
    }
}
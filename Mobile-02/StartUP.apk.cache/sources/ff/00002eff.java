package com.facebook.react.uimanager.events;

/* compiled from: TouchEventType.java */
/* loaded from: classes2.dex */
public enum i {
    START,
    END,
    MOVE,
    CANCEL;

    /* compiled from: TouchEventType.java */
    /* loaded from: classes2.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[i.values().length];
            a = iArr;
            try {
                iArr[i.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[i.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[i.MOVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[i.CANCEL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static String h(i iVar) {
        int i2 = a.a[iVar.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 == 4) {
                        return "topTouchCancel";
                    }
                    throw new IllegalArgumentException("Unexpected type " + iVar);
                }
                return "topTouchMove";
            }
            return "topTouchEnd";
        }
        return "topTouchStart";
    }
}
package com.facebook.react.uimanager.f1;

/* compiled from: LayoutAnimationType.java */
/* loaded from: classes2.dex */
enum g {
    CREATE,
    UPDATE,
    DELETE;

    /* compiled from: LayoutAnimationType.java */
    /* loaded from: classes2.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[g.values().length];
            a = iArr;
            try {
                iArr[g.CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[g.UPDATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[g.DELETE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static String h(g gVar) {
        int i2 = a.a[gVar.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    return "delete";
                }
                throw new IllegalArgumentException("Unsupported LayoutAnimationType: " + gVar);
            }
            return "update";
        }
        return "create";
    }
}
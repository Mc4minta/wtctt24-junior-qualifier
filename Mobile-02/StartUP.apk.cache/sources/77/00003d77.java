package com.google.zxing.v.c;

/* compiled from: ErrorCorrectionLevel.java */
/* loaded from: classes2.dex */
public enum f {
    L(1),
    M(0),
    Q(3),
    H(2);
    

    /* renamed from: e  reason: collision with root package name */
    private static final f[] f10130e;

    /* renamed from: g  reason: collision with root package name */
    private final int f10132g;

    static {
        f fVar = L;
        f fVar2 = M;
        f fVar3 = Q;
        f10130e = new f[]{fVar2, fVar, H, fVar3};
    }

    f(int i2) {
        this.f10132g = i2;
    }

    public static f h(int i2) {
        if (i2 >= 0) {
            f[] fVarArr = f10130e;
            if (i2 < fVarArr.length) {
                return fVarArr[i2];
            }
        }
        throw new IllegalArgumentException();
    }

    public int n() {
        return this.f10132g;
    }
}
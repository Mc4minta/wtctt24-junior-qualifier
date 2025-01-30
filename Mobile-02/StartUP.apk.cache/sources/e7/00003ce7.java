package com.google.zxing;

/* compiled from: ResultPoint.java */
/* loaded from: classes2.dex */
public class m {
    private final float a;

    /* renamed from: b  reason: collision with root package name */
    private final float f9856b;

    public m(float f2, float f3) {
        this.a = f2;
        this.f9856b = f3;
    }

    private static float a(m mVar, m mVar2, m mVar3) {
        float f2 = mVar2.a;
        float f3 = mVar2.f9856b;
        return ((mVar3.a - f2) * (mVar.f9856b - f3)) - ((mVar3.f9856b - f3) * (mVar.a - f2));
    }

    public static float b(m mVar, m mVar2) {
        return com.google.zxing.q.m.a.a(mVar.a, mVar.f9856b, mVar2.a, mVar2.f9856b);
    }

    public static void e(m[] mVarArr) {
        m mVar;
        m mVar2;
        m mVar3;
        float b2 = b(mVarArr[0], mVarArr[1]);
        float b3 = b(mVarArr[1], mVarArr[2]);
        float b4 = b(mVarArr[0], mVarArr[2]);
        if (b3 >= b2 && b3 >= b4) {
            mVar = mVarArr[0];
            mVar2 = mVarArr[1];
            mVar3 = mVarArr[2];
        } else if (b4 >= b3 && b4 >= b2) {
            mVar = mVarArr[1];
            mVar2 = mVarArr[0];
            mVar3 = mVarArr[2];
        } else {
            mVar = mVarArr[2];
            mVar2 = mVarArr[0];
            mVar3 = mVarArr[1];
        }
        if (a(mVar2, mVar, mVar3) < 0.0f) {
            m mVar4 = mVar3;
            mVar3 = mVar2;
            mVar2 = mVar4;
        }
        mVarArr[0] = mVar2;
        mVarArr[1] = mVar;
        mVarArr[2] = mVar3;
    }

    public final float c() {
        return this.a;
    }

    public final float d() {
        return this.f9856b;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof m) {
            m mVar = (m) obj;
            if (this.a == mVar.a && this.f9856b == mVar.f9856b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.a) * 31) + Float.floatToIntBits(this.f9856b);
    }

    public final String toString() {
        return "(" + this.a + ',' + this.f9856b + ')';
    }
}
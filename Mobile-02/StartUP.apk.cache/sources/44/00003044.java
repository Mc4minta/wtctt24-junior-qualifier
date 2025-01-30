package com.facebook.shimmer;

import android.content.res.TypedArray;
import android.graphics.RectF;

/* compiled from: Shimmer.java */
/* loaded from: classes2.dex */
public class b {
    final float[] a = new float[4];

    /* renamed from: b  reason: collision with root package name */
    final int[] f5580b = new int[4];

    /* renamed from: c  reason: collision with root package name */
    final RectF f5581c = new RectF();

    /* renamed from: d  reason: collision with root package name */
    int f5582d = 0;

    /* renamed from: e  reason: collision with root package name */
    int f5583e = -1;

    /* renamed from: f  reason: collision with root package name */
    int f5584f = 1291845631;

    /* renamed from: g  reason: collision with root package name */
    int f5585g = 0;

    /* renamed from: h  reason: collision with root package name */
    int f5586h = 0;

    /* renamed from: i  reason: collision with root package name */
    int f5587i = 0;

    /* renamed from: j  reason: collision with root package name */
    float f5588j = 1.0f;

    /* renamed from: k  reason: collision with root package name */
    float f5589k = 1.0f;

    /* renamed from: l  reason: collision with root package name */
    float f5590l = 0.0f;
    float m = 0.5f;
    float n = 20.0f;
    boolean o = true;
    boolean p = true;
    boolean q = true;
    int r = -1;
    int s = 1;
    long t = 1000;
    long u;

    /* compiled from: Shimmer.java */
    /* loaded from: classes2.dex */
    public static class a extends AbstractC0127b<a> {
        public a() {
            this.a.q = true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.shimmer.b.AbstractC0127b
        /* renamed from: v */
        public a d() {
            return this;
        }
    }

    /* compiled from: Shimmer.java */
    /* renamed from: com.facebook.shimmer.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static abstract class AbstractC0127b<T extends AbstractC0127b<T>> {
        final b a = new b();

        private static float b(float f2, float f3, float f4) {
            return Math.min(f3, Math.max(f2, f4));
        }

        public b a() {
            this.a.b();
            this.a.c();
            return this.a;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public T c(TypedArray typedArray) {
            int i2 = com.facebook.shimmer.a.f5572e;
            if (typedArray.hasValue(i2)) {
                g(typedArray.getBoolean(i2, this.a.o));
            }
            int i3 = com.facebook.shimmer.a.f5569b;
            if (typedArray.hasValue(i3)) {
                e(typedArray.getBoolean(i3, this.a.p));
            }
            int i4 = com.facebook.shimmer.a.f5570c;
            if (typedArray.hasValue(i4)) {
                f(typedArray.getFloat(i4, 0.3f));
            }
            int i5 = com.facebook.shimmer.a.m;
            if (typedArray.hasValue(i5)) {
                n(typedArray.getFloat(i5, 1.0f));
            }
            int i6 = com.facebook.shimmer.a.f5576i;
            if (typedArray.hasValue(i6)) {
                j(typedArray.getInt(i6, (int) this.a.t));
            }
            int i7 = com.facebook.shimmer.a.p;
            if (typedArray.hasValue(i7)) {
                p(typedArray.getInt(i7, this.a.r));
            }
            int i8 = com.facebook.shimmer.a.q;
            if (typedArray.hasValue(i8)) {
                q(typedArray.getInt(i8, (int) this.a.u));
            }
            int i9 = com.facebook.shimmer.a.r;
            if (typedArray.hasValue(i9)) {
                r(typedArray.getInt(i9, this.a.s));
            }
            int i10 = com.facebook.shimmer.a.f5574g;
            if (typedArray.hasValue(i10)) {
                int i11 = typedArray.getInt(i10, this.a.f5582d);
                if (i11 == 1) {
                    h(1);
                } else if (i11 == 2) {
                    h(2);
                } else if (i11 != 3) {
                    h(0);
                } else {
                    h(3);
                }
            }
            int i12 = com.facebook.shimmer.a.s;
            if (typedArray.hasValue(i12)) {
                if (typedArray.getInt(i12, this.a.f5585g) != 1) {
                    s(0);
                } else {
                    s(1);
                }
            }
            int i13 = com.facebook.shimmer.a.f5575h;
            if (typedArray.hasValue(i13)) {
                i(typedArray.getFloat(i13, this.a.m));
            }
            int i14 = com.facebook.shimmer.a.f5578k;
            if (typedArray.hasValue(i14)) {
                l(typedArray.getDimensionPixelSize(i14, this.a.f5586h));
            }
            int i15 = com.facebook.shimmer.a.f5577j;
            if (typedArray.hasValue(i15)) {
                k(typedArray.getDimensionPixelSize(i15, this.a.f5587i));
            }
            int i16 = com.facebook.shimmer.a.o;
            if (typedArray.hasValue(i16)) {
                o(typedArray.getFloat(i16, this.a.f5590l));
            }
            int i17 = com.facebook.shimmer.a.u;
            if (typedArray.hasValue(i17)) {
                u(typedArray.getFloat(i17, this.a.f5588j));
            }
            int i18 = com.facebook.shimmer.a.f5579l;
            if (typedArray.hasValue(i18)) {
                m(typedArray.getFloat(i18, this.a.f5589k));
            }
            int i19 = com.facebook.shimmer.a.t;
            if (typedArray.hasValue(i19)) {
                t(typedArray.getFloat(i19, this.a.n));
            }
            return d();
        }

        protected abstract T d();

        public T e(boolean z) {
            this.a.p = z;
            return d();
        }

        public T f(float f2) {
            b bVar = this.a;
            bVar.f5584f = (((int) (b(0.0f, 1.0f, f2) * 255.0f)) << 24) | (bVar.f5584f & 16777215);
            return d();
        }

        public T g(boolean z) {
            this.a.o = z;
            return d();
        }

        public T h(int i2) {
            this.a.f5582d = i2;
            return d();
        }

        public T i(float f2) {
            if (f2 >= 0.0f) {
                this.a.m = f2;
                return d();
            }
            throw new IllegalArgumentException("Given invalid dropoff value: " + f2);
        }

        public T j(long j2) {
            if (j2 >= 0) {
                this.a.t = j2;
                return d();
            }
            throw new IllegalArgumentException("Given a negative duration: " + j2);
        }

        public T k(int i2) {
            if (i2 >= 0) {
                this.a.f5587i = i2;
                return d();
            }
            throw new IllegalArgumentException("Given invalid height: " + i2);
        }

        public T l(int i2) {
            if (i2 >= 0) {
                this.a.f5586h = i2;
                return d();
            }
            throw new IllegalArgumentException("Given invalid width: " + i2);
        }

        public T m(float f2) {
            if (f2 >= 0.0f) {
                this.a.f5589k = f2;
                return d();
            }
            throw new IllegalArgumentException("Given invalid height ratio: " + f2);
        }

        public T n(float f2) {
            b bVar = this.a;
            bVar.f5583e = (((int) (b(0.0f, 1.0f, f2) * 255.0f)) << 24) | (bVar.f5583e & 16777215);
            return d();
        }

        public T o(float f2) {
            if (f2 >= 0.0f) {
                this.a.f5590l = f2;
                return d();
            }
            throw new IllegalArgumentException("Given invalid intensity value: " + f2);
        }

        public T p(int i2) {
            this.a.r = i2;
            return d();
        }

        public T q(long j2) {
            if (j2 >= 0) {
                this.a.u = j2;
                return d();
            }
            throw new IllegalArgumentException("Given a negative repeat delay: " + j2);
        }

        public T r(int i2) {
            this.a.s = i2;
            return d();
        }

        public T s(int i2) {
            this.a.f5585g = i2;
            return d();
        }

        public T t(float f2) {
            this.a.n = f2;
            return d();
        }

        public T u(float f2) {
            if (f2 >= 0.0f) {
                this.a.f5588j = f2;
                return d();
            }
            throw new IllegalArgumentException("Given invalid width ratio: " + f2);
        }
    }

    /* compiled from: Shimmer.java */
    /* loaded from: classes2.dex */
    public static class c extends AbstractC0127b<c> {
        public c() {
            this.a.q = false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.facebook.shimmer.b.AbstractC0127b
        /* renamed from: v */
        public c c(TypedArray typedArray) {
            super.c(typedArray);
            int i2 = com.facebook.shimmer.a.f5571d;
            if (typedArray.hasValue(i2)) {
                x(typedArray.getColor(i2, this.a.f5584f));
            }
            int i3 = com.facebook.shimmer.a.n;
            if (typedArray.hasValue(i3)) {
                y(typedArray.getColor(i3, this.a.f5583e));
            }
            return d();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.shimmer.b.AbstractC0127b
        /* renamed from: w */
        public c d() {
            return this;
        }

        public c x(int i2) {
            b bVar = this.a;
            bVar.f5584f = (i2 & 16777215) | (bVar.f5584f & (-16777216));
            return d();
        }

        public c y(int i2) {
            this.a.f5583e = i2;
            return d();
        }
    }

    b() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(int i2) {
        int i3 = this.f5587i;
        return i3 > 0 ? i3 : Math.round(this.f5589k * i2);
    }

    void b() {
        if (this.f5585g != 1) {
            int[] iArr = this.f5580b;
            int i2 = this.f5584f;
            iArr[0] = i2;
            int i3 = this.f5583e;
            iArr[1] = i3;
            iArr[2] = i3;
            iArr[3] = i2;
            return;
        }
        int[] iArr2 = this.f5580b;
        int i4 = this.f5583e;
        iArr2[0] = i4;
        iArr2[1] = i4;
        int i5 = this.f5584f;
        iArr2[2] = i5;
        iArr2[3] = i5;
    }

    void c() {
        if (this.f5585g != 1) {
            this.a[0] = Math.max(((1.0f - this.f5590l) - this.m) / 2.0f, 0.0f);
            this.a[1] = Math.max(((1.0f - this.f5590l) - 0.001f) / 2.0f, 0.0f);
            this.a[2] = Math.min(((this.f5590l + 1.0f) + 0.001f) / 2.0f, 1.0f);
            this.a[3] = Math.min(((this.f5590l + 1.0f) + this.m) / 2.0f, 1.0f);
            return;
        }
        float[] fArr = this.a;
        fArr[0] = 0.0f;
        fArr[1] = Math.min(this.f5590l, 1.0f);
        this.a[2] = Math.min(this.f5590l + this.m, 1.0f);
        this.a[3] = 1.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d(int i2) {
        int i3 = this.f5586h;
        return i3 > 0 ? i3 : Math.round(this.f5588j * i2);
    }
}
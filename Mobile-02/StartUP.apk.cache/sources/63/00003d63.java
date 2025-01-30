package com.google.zxing.u.d.k;

/* compiled from: ModulusGF.java */
/* loaded from: classes2.dex */
public final class b {
    public static final b a = new b(929, 3);

    /* renamed from: b  reason: collision with root package name */
    private final int[] f10104b;

    /* renamed from: c  reason: collision with root package name */
    private final int[] f10105c;

    /* renamed from: d  reason: collision with root package name */
    private final c f10106d;

    /* renamed from: e  reason: collision with root package name */
    private final c f10107e;

    /* renamed from: f  reason: collision with root package name */
    private final int f10108f;

    private b(int i2, int i3) {
        this.f10108f = i2;
        this.f10104b = new int[i2];
        this.f10105c = new int[i2];
        int i4 = 1;
        for (int i5 = 0; i5 < i2; i5++) {
            this.f10104b[i5] = i4;
            i4 = (i4 * i3) % i2;
        }
        for (int i6 = 0; i6 < i2 - 1; i6++) {
            this.f10105c[this.f10104b[i6]] = i6;
        }
        this.f10106d = new c(this, new int[]{0});
        this.f10107e = new c(this, new int[]{1});
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(int i2, int i3) {
        return (i2 + i3) % this.f10108f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c b(int i2, int i3) {
        if (i2 >= 0) {
            if (i3 == 0) {
                return this.f10106d;
            }
            int[] iArr = new int[i2 + 1];
            iArr[0] = i3;
            return new c(this, iArr);
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c(int i2) {
        return this.f10104b[i2];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c d() {
        return this.f10107e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.f10108f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c f() {
        return this.f10106d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g(int i2) {
        if (i2 != 0) {
            return this.f10104b[(this.f10108f - this.f10105c[i2]) - 1];
        }
        throw new ArithmeticException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h(int i2) {
        if (i2 != 0) {
            return this.f10105c[i2];
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i(int i2, int i3) {
        if (i2 == 0 || i3 == 0) {
            return 0;
        }
        int[] iArr = this.f10104b;
        int[] iArr2 = this.f10105c;
        return iArr[(iArr2[i2] + iArr2[i3]) % (this.f10108f - 1)];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j(int i2, int i3) {
        int i4 = this.f10108f;
        return ((i2 + i4) - i3) % i4;
    }
}
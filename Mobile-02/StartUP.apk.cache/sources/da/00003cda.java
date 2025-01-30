package com.google.zxing.common.reedsolomon;

import org.apache.http.HttpStatus;

/* compiled from: GenericGF.java */
/* loaded from: classes2.dex */
public final class a {
    public static final a a = new a(4201, 4096, 1);

    /* renamed from: b  reason: collision with root package name */
    public static final a f9799b = new a(1033, 1024, 1);

    /* renamed from: c  reason: collision with root package name */
    public static final a f9800c;

    /* renamed from: d  reason: collision with root package name */
    public static final a f9801d;

    /* renamed from: e  reason: collision with root package name */
    public static final a f9802e;

    /* renamed from: f  reason: collision with root package name */
    public static final a f9803f;

    /* renamed from: g  reason: collision with root package name */
    public static final a f9804g;

    /* renamed from: h  reason: collision with root package name */
    public static final a f9805h;

    /* renamed from: i  reason: collision with root package name */
    private final int[] f9806i;

    /* renamed from: j  reason: collision with root package name */
    private final int[] f9807j;

    /* renamed from: k  reason: collision with root package name */
    private final b f9808k;

    /* renamed from: l  reason: collision with root package name */
    private final b f9809l;
    private final int m;
    private final int n;
    private final int o;

    static {
        a aVar = new a(67, 64, 1);
        f9800c = aVar;
        f9801d = new a(19, 16, 1);
        f9802e = new a(285, 256, 0);
        a aVar2 = new a(HttpStatus.SC_MOVED_PERMANENTLY, 256, 1);
        f9803f = aVar2;
        f9804g = aVar2;
        f9805h = aVar;
    }

    public a(int i2, int i3, int i4) {
        this.n = i2;
        this.m = i3;
        this.o = i4;
        this.f9806i = new int[i3];
        this.f9807j = new int[i3];
        int i5 = 1;
        for (int i6 = 0; i6 < i3; i6++) {
            this.f9806i[i6] = i5;
            i5 <<= 1;
            if (i5 >= i3) {
                i5 = (i5 ^ i2) & (i3 - 1);
            }
        }
        for (int i7 = 0; i7 < i3 - 1; i7++) {
            this.f9807j[this.f9806i[i7]] = i7;
        }
        this.f9808k = new b(this, new int[]{0});
        this.f9809l = new b(this, new int[]{1});
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i2, int i3) {
        return i2 ^ i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b b(int i2, int i3) {
        if (i2 >= 0) {
            if (i3 == 0) {
                return this.f9808k;
            }
            int[] iArr = new int[i2 + 1];
            iArr[0] = i3;
            return new b(this, iArr);
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c(int i2) {
        return this.f9806i[i2];
    }

    public int d() {
        return this.o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b e() {
        return this.f9809l;
    }

    public int f() {
        return this.m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b g() {
        return this.f9808k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h(int i2) {
        if (i2 != 0) {
            return this.f9806i[(this.m - this.f9807j[i2]) - 1];
        }
        throw new ArithmeticException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i(int i2) {
        if (i2 != 0) {
            return this.f9807j[i2];
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j(int i2, int i3) {
        if (i2 == 0 || i3 == 0) {
            return 0;
        }
        int[] iArr = this.f9806i;
        int[] iArr2 = this.f9807j;
        return iArr[(iArr2[i2] + iArr2[i3]) % (this.m - 1)];
    }

    public String toString() {
        return "GF(0x" + Integer.toHexString(this.n) + ',' + this.m + ')';
    }
}
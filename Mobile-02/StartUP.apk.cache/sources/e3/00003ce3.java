package com.google.zxing;

/* compiled from: PlanarYUVLuminanceSource.java */
/* loaded from: classes2.dex */
public final class i extends g {

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f9835c;

    /* renamed from: d  reason: collision with root package name */
    private final int f9836d;

    /* renamed from: e  reason: collision with root package name */
    private final int f9837e;

    /* renamed from: f  reason: collision with root package name */
    private final int f9838f;

    /* renamed from: g  reason: collision with root package name */
    private final int f9839g;

    public i(byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, boolean z) {
        super(i6, i7);
        if (i4 + i6 <= i2 && i5 + i7 <= i3) {
            this.f9835c = bArr;
            this.f9836d = i2;
            this.f9837e = i3;
            this.f9838f = i4;
            this.f9839g = i5;
            if (z) {
                h(i6, i7);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
    }

    private void h(int i2, int i3) {
        byte[] bArr = this.f9835c;
        int i4 = (this.f9839g * this.f9836d) + this.f9838f;
        int i5 = 0;
        while (i5 < i3) {
            int i6 = (i2 / 2) + i4;
            int i7 = (i4 + i2) - 1;
            int i8 = i4;
            while (i8 < i6) {
                byte b2 = bArr[i8];
                bArr[i8] = bArr[i7];
                bArr[i7] = b2;
                i8++;
                i7--;
            }
            i5++;
            i4 += this.f9836d;
        }
    }

    @Override // com.google.zxing.g
    public byte[] b() {
        int d2 = d();
        int a = a();
        int i2 = this.f9836d;
        if (d2 == i2 && a == this.f9837e) {
            return this.f9835c;
        }
        int i3 = d2 * a;
        byte[] bArr = new byte[i3];
        int i4 = (this.f9839g * i2) + this.f9838f;
        if (d2 == i2) {
            System.arraycopy(this.f9835c, i4, bArr, 0, i3);
            return bArr;
        }
        for (int i5 = 0; i5 < a; i5++) {
            System.arraycopy(this.f9835c, i4, bArr, i5 * d2, d2);
            i4 += this.f9836d;
        }
        return bArr;
    }

    @Override // com.google.zxing.g
    public byte[] c(int i2, byte[] bArr) {
        if (i2 >= 0 && i2 < a()) {
            int d2 = d();
            if (bArr == null || bArr.length < d2) {
                bArr = new byte[d2];
            }
            System.arraycopy(this.f9835c, ((i2 + this.f9839g) * this.f9836d) + this.f9838f, bArr, 0, d2);
            return bArr;
        }
        throw new IllegalArgumentException("Requested row is outside the image: " + i2);
    }
}
package com.google.zxing;

/* compiled from: InvertedLuminanceSource.java */
/* loaded from: classes2.dex */
public final class f extends g {

    /* renamed from: c  reason: collision with root package name */
    private final g f9832c;

    public f(g gVar) {
        super(gVar.d(), gVar.a());
        this.f9832c = gVar;
    }

    @Override // com.google.zxing.g
    public byte[] b() {
        byte[] b2 = this.f9832c.b();
        int d2 = d() * a();
        byte[] bArr = new byte[d2];
        for (int i2 = 0; i2 < d2; i2++) {
            bArr[i2] = (byte) (255 - (b2[i2] & 255));
        }
        return bArr;
    }

    @Override // com.google.zxing.g
    public byte[] c(int i2, byte[] bArr) {
        byte[] c2 = this.f9832c.c(i2, bArr);
        int d2 = d();
        for (int i3 = 0; i3 < d2; i3++) {
            c2[i3] = (byte) (255 - (c2[i3] & 255));
        }
        return c2;
    }

    @Override // com.google.zxing.g
    public g e() {
        return this.f9832c;
    }

    @Override // com.google.zxing.g
    public boolean f() {
        return this.f9832c.f();
    }

    @Override // com.google.zxing.g
    public g g() {
        return new f(this.f9832c.g());
    }
}
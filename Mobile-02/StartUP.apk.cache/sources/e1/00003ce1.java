package com.google.zxing;

import org.apache.http.message.TokenParser;

/* compiled from: LuminanceSource.java */
/* loaded from: classes2.dex */
public abstract class g {
    private final int a;

    /* renamed from: b  reason: collision with root package name */
    private final int f9833b;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(int i2, int i3) {
        this.a = i2;
        this.f9833b = i3;
    }

    public final int a() {
        return this.f9833b;
    }

    public abstract byte[] b();

    public abstract byte[] c(int i2, byte[] bArr);

    public final int d() {
        return this.a;
    }

    public g e() {
        return new f(this);
    }

    public boolean f() {
        return false;
    }

    public g g() {
        throw new UnsupportedOperationException("This luminance source does not support rotation by 90 degrees.");
    }

    public final String toString() {
        int i2 = this.a;
        byte[] bArr = new byte[i2];
        StringBuilder sb = new StringBuilder(this.f9833b * (i2 + 1));
        for (int i3 = 0; i3 < this.f9833b; i3++) {
            bArr = c(i3, bArr);
            for (int i4 = 0; i4 < this.a; i4++) {
                int i5 = bArr[i4] & 255;
                sb.append(i5 < 64 ? '#' : i5 < 128 ? '+' : i5 < 192 ? '.' : TokenParser.SP);
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
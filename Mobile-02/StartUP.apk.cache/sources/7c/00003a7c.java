package com.google.firebase.crashlytics.c.m;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
final class a {
    public static final a a = new a(new byte[0]);

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f8990b;

    /* renamed from: c  reason: collision with root package name */
    private volatile int f8991c = 0;

    private a(byte[] bArr) {
        this.f8990b = bArr;
    }

    public static a a(byte[] bArr) {
        return b(bArr, 0, bArr.length);
    }

    public static a b(byte[] bArr, int i2, int i3) {
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i2, bArr2, 0, i3);
        return new a(bArr2);
    }

    public static a c(String str) {
        try {
            return new a(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("UTF-8 not supported.", e2);
        }
    }

    public void d(byte[] bArr, int i2, int i3, int i4) {
        System.arraycopy(this.f8990b, i2, bArr, i3, i4);
    }

    public InputStream e() {
        return new ByteArrayInputStream(this.f8990b);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            byte[] bArr = this.f8990b;
            int length = bArr.length;
            byte[] bArr2 = ((a) obj).f8990b;
            if (length != bArr2.length) {
                return false;
            }
            for (int i2 = 0; i2 < length; i2++) {
                if (bArr[i2] != bArr2[i2]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public int f() {
        return this.f8990b.length;
    }

    public int hashCode() {
        int i2 = this.f8991c;
        if (i2 == 0) {
            byte[] bArr = this.f8990b;
            int length = bArr.length;
            for (byte b2 : bArr) {
                length = (length * 31) + b2;
            }
            i2 = length == 0 ? 1 : length;
            this.f8991c = i2;
        }
        return i2;
    }
}
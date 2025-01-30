package org.apache.commons.codec.b;

import java.util.Arrays;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* compiled from: BaseNCodec.java */
/* loaded from: classes3.dex */
public abstract class b {
    @Deprecated
    protected final byte a;

    /* renamed from: b  reason: collision with root package name */
    protected final byte f17563b;

    /* renamed from: c  reason: collision with root package name */
    private final int f17564c;

    /* renamed from: d  reason: collision with root package name */
    private final int f17565d;

    /* renamed from: e  reason: collision with root package name */
    protected final int f17566e;

    /* renamed from: f  reason: collision with root package name */
    private final int f17567f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BaseNCodec.java */
    /* loaded from: classes3.dex */
    public static class a {
        int a;

        /* renamed from: b  reason: collision with root package name */
        long f17568b;

        /* renamed from: c  reason: collision with root package name */
        byte[] f17569c;

        /* renamed from: d  reason: collision with root package name */
        int f17570d;

        /* renamed from: e  reason: collision with root package name */
        int f17571e;

        /* renamed from: f  reason: collision with root package name */
        boolean f17572f;

        /* renamed from: g  reason: collision with root package name */
        int f17573g;

        /* renamed from: h  reason: collision with root package name */
        int f17574h;

        a() {
        }

        public String toString() {
            return String.format("%s[buffer=%s, currentLinePos=%s, eof=%s, ibitWorkArea=%s, lbitWorkArea=%s, modulus=%s, pos=%s, readPos=%s]", a.class.getSimpleName(), Arrays.toString(this.f17569c), Integer.valueOf(this.f17573g), Boolean.valueOf(this.f17572f), Integer.valueOf(this.a), Long.valueOf(this.f17568b), Integer.valueOf(this.f17574h), Integer.valueOf(this.f17570d), Integer.valueOf(this.f17571e));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b(int i2, int i3, int i4, int i5) {
        this(i2, i3, i4, i5, (byte) 61);
    }

    private byte[] m(a aVar) {
        byte[] bArr = aVar.f17569c;
        if (bArr == null) {
            aVar.f17569c = new byte[i()];
            aVar.f17570d = 0;
            aVar.f17571e = 0;
        } else {
            byte[] bArr2 = new byte[bArr.length * 2];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            aVar.f17569c = bArr2;
        }
        return aVar.f17569c;
    }

    int a(a aVar) {
        if (aVar.f17569c != null) {
            return aVar.f17570d - aVar.f17571e;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean b(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        for (byte b2 : bArr) {
            if (this.f17563b == b2 || k(b2)) {
                return true;
            }
        }
        return false;
    }

    abstract void c(byte[] bArr, int i2, int i3, a aVar);

    public byte[] d(String str) {
        return e(c.b(str));
    }

    public byte[] e(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        a aVar = new a();
        c(bArr, 0, bArr.length, aVar);
        c(bArr, 0, -1, aVar);
        int i2 = aVar.f17570d;
        byte[] bArr2 = new byte[i2];
        l(bArr2, 0, i2, aVar);
        return bArr2;
    }

    abstract void f(byte[] bArr, int i2, int i3, a aVar);

    public byte[] g(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        a aVar = new a();
        f(bArr, 0, bArr.length, aVar);
        f(bArr, 0, -1, aVar);
        int i2 = aVar.f17570d - aVar.f17571e;
        byte[] bArr2 = new byte[i2];
        l(bArr2, 0, i2, aVar);
        return bArr2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public byte[] h(int i2, a aVar) {
        byte[] bArr = aVar.f17569c;
        return (bArr == null || bArr.length < aVar.f17570d + i2) ? m(aVar) : bArr;
    }

    protected int i() {
        return PKIFailureInfo.certRevoked;
    }

    public long j(byte[] bArr) {
        int length = bArr.length;
        int i2 = this.f17564c;
        long j2 = (((length + i2) - 1) / i2) * this.f17565d;
        int i3 = this.f17566e;
        return i3 > 0 ? j2 + ((((i3 + j2) - 1) / i3) * this.f17567f) : j2;
    }

    protected abstract boolean k(byte b2);

    int l(byte[] bArr, int i2, int i3, a aVar) {
        if (aVar.f17569c == null) {
            return aVar.f17572f ? -1 : 0;
        }
        int min = Math.min(a(aVar), i3);
        System.arraycopy(aVar.f17569c, aVar.f17571e, bArr, i2, min);
        int i4 = aVar.f17571e + min;
        aVar.f17571e = i4;
        if (i4 >= aVar.f17570d) {
            aVar.f17569c = null;
        }
        return min;
    }

    protected b(int i2, int i3, int i4, int i5, byte b2) {
        this.a = (byte) 61;
        this.f17564c = i2;
        this.f17565d = i3;
        this.f17566e = i4 > 0 && i5 > 0 ? (i4 / i3) * i3 : 0;
        this.f17567f = i5;
        this.f17563b = b2;
    }
}
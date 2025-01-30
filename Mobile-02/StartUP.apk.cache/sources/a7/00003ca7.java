package com.google.protobuf;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: Internal.java */
/* loaded from: classes2.dex */
public final class k {
    static final Charset a = Charset.forName("UTF-8");

    /* renamed from: b  reason: collision with root package name */
    static final Charset f9728b = Charset.forName("ISO-8859-1");

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f9729c;

    /* renamed from: d  reason: collision with root package name */
    public static final ByteBuffer f9730d;

    /* renamed from: e  reason: collision with root package name */
    public static final f f9731e;

    /* compiled from: Internal.java */
    /* loaded from: classes2.dex */
    public interface a<E> extends List<E>, RandomAccess {
        a<E> G(int i2);

        boolean d1();

        void v();
    }

    static {
        byte[] bArr = new byte[0];
        f9729c = bArr;
        f9730d = ByteBuffer.wrap(bArr);
        f9731e = f.d(bArr);
    }

    public static int a(boolean z) {
        return z ? 1231 : 1237;
    }

    public static int b(long j2) {
        return (int) (j2 ^ (j2 >>> 32));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(int i2, byte[] bArr, int i3, int i4) {
        for (int i5 = i3; i5 < i3 + i4; i5++) {
            i2 = (i2 * 31) + bArr[i5];
        }
        return i2;
    }
}
package com.google.android.gms.internal.clearcut;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class g1 {
    static final Charset a = Charset.forName("UTF-8");

    /* renamed from: b  reason: collision with root package name */
    private static final Charset f6448b = Charset.forName("ISO-8859-1");

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f6449c;

    /* renamed from: d  reason: collision with root package name */
    private static final ByteBuffer f6450d;

    /* renamed from: e  reason: collision with root package name */
    private static final j0 f6451e;

    static {
        byte[] bArr = new byte[0];
        f6449c = bArr;
        f6450d = ByteBuffer.wrap(bArr);
        f6451e = j0.b(bArr, 0, bArr.length, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T a(T t) {
        Objects.requireNonNull(t);
        return t;
    }

    public static int b(byte[] bArr) {
        int length = bArr.length;
        int c2 = c(length, bArr, 0, length);
        if (c2 == 0) {
            return 1;
        }
        return c2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(int i2, byte[] bArr, int i3, int i4) {
        for (int i5 = i3; i5 < i3 + i4; i5++) {
            i2 = (i2 * 31) + bArr[i5];
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object d(Object obj, Object obj2) {
        return ((i2) obj).h().k0((i2) obj2).g0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T e(T t, String str) {
        Objects.requireNonNull(t, str);
        return t;
    }

    public static int f(boolean z) {
        return z ? 1231 : 1237;
    }

    public static boolean g(byte[] bArr) {
        return z3.h(bArr);
    }

    public static String h(byte[] bArr) {
        return new String(bArr, a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean i(i2 i2Var) {
        return false;
    }

    public static int j(long j2) {
        return (int) (j2 ^ (j2 >>> 32));
    }
}
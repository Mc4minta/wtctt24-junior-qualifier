package com.google.android.gms.internal.measurement;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
/* loaded from: classes2.dex */
public final class q4 {
    static final Charset a = Charset.forName("UTF-8");

    /* renamed from: b  reason: collision with root package name */
    private static final Charset f7314b = Charset.forName("ISO-8859-1");

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f7315c;

    /* renamed from: d  reason: collision with root package name */
    private static final ByteBuffer f7316d;

    /* renamed from: e  reason: collision with root package name */
    private static final t3 f7317e;

    static {
        byte[] bArr = new byte[0];
        f7315c = bArr;
        f7316d = ByteBuffer.wrap(bArr);
        f7317e = t3.b(bArr, 0, bArr.length, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i2, byte[] bArr, int i3, int i4) {
        for (int i5 = i3; i5 < i3 + i4; i5++) {
            i2 = (i2 * 31) + bArr[i5];
        }
        return i2;
    }

    public static int b(long j2) {
        return (int) (j2 ^ (j2 >>> 32));
    }

    public static int c(boolean z) {
        return z ? 1231 : 1237;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T d(T t) {
        Objects.requireNonNull(t);
        return t;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object e(Object obj, Object obj2) {
        return ((u5) obj).c().o0((u5) obj2).g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T f(T t, String str) {
        Objects.requireNonNull(t, str);
        return t;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean g(u5 u5Var) {
        if (u5Var instanceof z2) {
            z2 z2Var = (z2) u5Var;
            return false;
        }
        return false;
    }

    public static boolean h(byte[] bArr) {
        return l7.f(bArr);
    }

    public static String i(byte[] bArr) {
        return new String(bArr, a);
    }

    public static int j(byte[] bArr) {
        int length = bArr.length;
        int a2 = a(length, bArr, 0, length);
        if (a2 == 0) {
            return 1;
        }
        return a2;
    }
}
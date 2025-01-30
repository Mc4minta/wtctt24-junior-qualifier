package com.google.android.gms.internal.p000firebaseperf;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.n4  reason: invalid package */
/* loaded from: classes2.dex */
public final class n4 {
    static final Charset a = Charset.forName("UTF-8");

    /* renamed from: b  reason: collision with root package name */
    private static final Charset f6851b = Charset.forName("ISO-8859-1");

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f6852c;

    /* renamed from: d  reason: collision with root package name */
    private static final ByteBuffer f6853d;

    /* renamed from: e  reason: collision with root package name */
    private static final u3 f6854e;

    static {
        byte[] bArr = new byte[0];
        f6852c = bArr;
        f6853d = ByteBuffer.wrap(bArr);
        f6854e = u3.a(bArr, 0, bArr.length, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T a(T t) {
        Objects.requireNonNull(t);
        return t;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T b(T t, String str) {
        Objects.requireNonNull(t, str);
        return t;
    }

    public static int c(byte[] bArr) {
        int length = bArr.length;
        int d2 = d(length, bArr, 0, length);
        if (d2 == 0) {
            return 1;
        }
        return d2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(int i2, byte[] bArr, int i3, int i4) {
        for (int i5 = i3; i5 < i3 + i4; i5++) {
            i2 = (i2 * 31) + bArr[i5];
        }
        return i2;
    }

    public static int e(long j2) {
        return (int) (j2 ^ (j2 >>> 32));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object f(Object obj, Object obj2) {
        return ((v5) obj).b().I0((v5) obj2).m();
    }

    public static boolean g(byte[] bArr) {
        return m7.e(bArr);
    }

    public static String h(byte[] bArr) {
        return new String(bArr, a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean i(v5 v5Var) {
        if (v5Var instanceof f3) {
            f3 f3Var = (f3) v5Var;
            return false;
        }
        return false;
    }

    public static int j(boolean z) {
        return z ? 1231 : 1237;
    }
}
package j;

import com.coinbase.wallet.core.extensions.Strings;

/* compiled from: -Util.kt */
/* loaded from: classes3.dex */
public final class c {
    public static final boolean a(byte[] a, int i2, byte[] b2, int i3, int i4) {
        kotlin.jvm.internal.m.g(a, "a");
        kotlin.jvm.internal.m.g(b2, "b");
        for (int i5 = 0; i5 < i4; i5++) {
            if (a[i5 + i2] != b2[i5 + i3]) {
                return false;
            }
        }
        return true;
    }

    public static final void b(long j2, long j3, long j4) {
        if ((j3 | j4) < 0 || j3 > j2 || j2 - j3 < j4) {
            throw new ArrayIndexOutOfBoundsException("size=" + j2 + " offset=" + j3 + " byteCount=" + j4);
        }
    }

    public static final int c(int i2) {
        return ((i2 & 255) << 24) | (((-16777216) & i2) >>> 24) | ((16711680 & i2) >>> 8) | ((65280 & i2) << 8);
    }

    public static final long d(long j2) {
        return ((j2 & 255) << 56) | (((-72057594037927936L) & j2) >>> 56) | ((71776119061217280L & j2) >>> 40) | ((280375465082880L & j2) >>> 24) | ((1095216660480L & j2) >>> 8) | ((4278190080L & j2) << 8) | ((16711680 & j2) << 24) | ((65280 & j2) << 40);
    }

    public static final short e(short s) {
        int i2 = s & 65535;
        return (short) (((i2 & 255) << 8) | ((65280 & i2) >>> 8));
    }

    public static final String f(byte b2) {
        return new String(new char[]{j.h0.b.f()[(b2 >> 4) & 15], j.h0.b.f()[b2 & 15]});
    }

    public static final String g(int i2) {
        if (i2 == 0) {
            return Strings.zero;
        }
        int i3 = 0;
        char[] cArr = {j.h0.b.f()[(i2 >> 28) & 15], j.h0.b.f()[(i2 >> 24) & 15], j.h0.b.f()[(i2 >> 20) & 15], j.h0.b.f()[(i2 >> 16) & 15], j.h0.b.f()[(i2 >> 12) & 15], j.h0.b.f()[(i2 >> 8) & 15], j.h0.b.f()[(i2 >> 4) & 15], j.h0.b.f()[i2 & 15]};
        while (i3 < 8 && cArr[i3] == '0') {
            i3++;
        }
        return new String(cArr, i3, 8 - i3);
    }
}
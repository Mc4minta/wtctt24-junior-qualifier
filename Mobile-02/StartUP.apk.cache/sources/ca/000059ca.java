package kotlin;

/* compiled from: UnsignedUtils.kt */
/* loaded from: classes3.dex */
public final class z {
    public static final int a(int i2, int i3) {
        return kotlin.jvm.internal.m.i(i2 ^ Integer.MIN_VALUE, i3 ^ Integer.MIN_VALUE);
    }

    public static final int b(int i2, int i3) {
        return UInt.s((int) ((i2 & 4294967295L) / (i3 & 4294967295L)));
    }

    public static final int c(long j2, long j3) {
        return ((j2 ^ Long.MIN_VALUE) > (j3 ^ Long.MIN_VALUE) ? 1 : ((j2 ^ Long.MIN_VALUE) == (j3 ^ Long.MIN_VALUE) ? 0 : -1));
    }

    public static final long d(long j2, long j3) {
        if (j3 < 0) {
            return c(j2, j3) < 0 ? v.s(0L) : v.s(1L);
        } else if (j2 >= 0) {
            return v.s(j2 / j3);
        } else {
            long j4 = ((j2 >>> 1) / j3) << 1;
            return v.s(j4 + (c(v.s(j2 - (j4 * j3)), v.s(j3)) < 0 ? 0 : 1));
        }
    }

    public static final String e(long j2) {
        return f(j2, 10);
    }

    public static final String f(long j2, int i2) {
        if (j2 >= 0) {
            String l2 = Long.toString(j2, kotlin.l0.a.a(i2));
            kotlin.jvm.internal.m.f(l2, "java.lang.Long.toString(this, checkRadix(radix))");
            return l2;
        }
        long j3 = i2;
        long j4 = ((j2 >>> 1) / j3) << 1;
        long j5 = j2 - (j4 * j3);
        if (j5 >= j3) {
            j5 -= j3;
            j4++;
        }
        StringBuilder sb = new StringBuilder();
        String l3 = Long.toString(j4, kotlin.l0.a.a(i2));
        kotlin.jvm.internal.m.f(l3, "java.lang.Long.toString(this, checkRadix(radix))");
        sb.append(l3);
        String l4 = Long.toString(j5, kotlin.l0.a.a(i2));
        kotlin.jvm.internal.m.f(l4, "java.lang.Long.toString(this, checkRadix(radix))");
        sb.append(l4);
        return sb.toString();
    }
}
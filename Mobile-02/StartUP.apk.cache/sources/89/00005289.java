package kotlin.l0;

import kotlin.KotlinNothingValueException;
import kotlin.UInt;

/* compiled from: UStrings.kt */
/* loaded from: classes3.dex */
public final class b0 {
    public static final int a(String toUInt) {
        kotlin.jvm.internal.m.g(toUInt, "$this$toUInt");
        UInt b2 = b(toUInt);
        if (b2 != null) {
            return b2.B();
        }
        w.o(toUInt);
        throw new KotlinNothingValueException();
    }

    public static final UInt b(String toUIntOrNull) {
        kotlin.jvm.internal.m.g(toUIntOrNull, "$this$toUIntOrNull");
        return c(toUIntOrNull, 10);
    }

    public static final UInt c(String toUIntOrNull, int i2) {
        kotlin.jvm.internal.m.g(toUIntOrNull, "$this$toUIntOrNull");
        b.a(i2);
        int length = toUIntOrNull.length();
        if (length == 0) {
            return null;
        }
        int i3 = 0;
        char charAt = toUIntOrNull.charAt(0);
        int i4 = 1;
        if (kotlin.jvm.internal.m.i(charAt, 48) >= 0) {
            i4 = 0;
        } else if (length == 1 || charAt != '+') {
            return null;
        }
        int s = UInt.s(i2);
        int i5 = 119304647;
        while (i4 < length) {
            int b2 = b.b(toUIntOrNull.charAt(i4), i2);
            if (b2 < 0) {
                return null;
            }
            if (kotlin.z.a(i3, i5) > 0) {
                if (i5 == 119304647) {
                    i5 = kotlin.z.b(-1, s);
                    if (kotlin.z.a(i3, i5) > 0) {
                    }
                }
                return null;
            }
            int s2 = UInt.s(i3 * s);
            int s3 = UInt.s(UInt.s(b2) + s2);
            if (kotlin.z.a(s3, s2) < 0) {
                return null;
            }
            i4++;
            i3 = s3;
        }
        return UInt.h(i3);
    }

    public static final long d(String toULong) {
        kotlin.jvm.internal.m.g(toULong, "$this$toULong");
        kotlin.v e2 = e(toULong);
        if (e2 != null) {
            return e2.B();
        }
        w.o(toULong);
        throw new KotlinNothingValueException();
    }

    public static final kotlin.v e(String toULongOrNull) {
        kotlin.jvm.internal.m.g(toULongOrNull, "$this$toULongOrNull");
        return f(toULongOrNull, 10);
    }

    public static final kotlin.v f(String toULongOrNull, int i2) {
        int b2;
        kotlin.jvm.internal.m.g(toULongOrNull, "$this$toULongOrNull");
        b.a(i2);
        int length = toULongOrNull.length();
        if (length == 0) {
            return null;
        }
        long j2 = -1;
        int i3 = 0;
        char charAt = toULongOrNull.charAt(0);
        if (kotlin.jvm.internal.m.i(charAt, 48) < 0) {
            if (length == 1 || charAt != '+') {
                return null;
            }
            i3 = 1;
        }
        long s = kotlin.v.s(i2);
        long j3 = 0;
        long j4 = 512409557603043100L;
        while (i3 < length) {
            if (b.b(toULongOrNull.charAt(i3), i2) < 0) {
                return null;
            }
            if (kotlin.z.c(j3, j4) > 0) {
                if (j4 == 512409557603043100L) {
                    j4 = kotlin.z.d(j2, s);
                    if (kotlin.z.c(j3, j4) > 0) {
                    }
                }
                return null;
            }
            long s2 = kotlin.v.s(j3 * s);
            long s3 = kotlin.v.s(kotlin.v.s(UInt.s(b2) & 4294967295L) + s2);
            if (kotlin.z.c(s3, s2) < 0) {
                return null;
            }
            i3++;
            j3 = s3;
            j2 = -1;
        }
        return kotlin.v.h(j3);
    }
}
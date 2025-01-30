package kotlin.l0;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StringNumberConversions.kt */
/* loaded from: classes3.dex */
public class w extends v {
    public static final Void o(String input) {
        kotlin.jvm.internal.m.g(input, "input");
        throw new NumberFormatException("Invalid number format: '" + input + '\'');
    }

    public static Byte p(String toByteOrNull, int i2) {
        Integer r;
        int intValue;
        kotlin.jvm.internal.m.g(toByteOrNull, "$this$toByteOrNull");
        r = r(toByteOrNull, i2);
        if (r == null || (intValue = r.intValue()) < -128 || intValue > 127) {
            return null;
        }
        return Byte.valueOf((byte) intValue);
    }

    public static Integer q(String toIntOrNull) {
        Integer r;
        kotlin.jvm.internal.m.g(toIntOrNull, "$this$toIntOrNull");
        r = r(toIntOrNull, 10);
        return r;
    }

    public static Integer r(String toIntOrNull, int i2) {
        boolean z;
        int i3;
        kotlin.jvm.internal.m.g(toIntOrNull, "$this$toIntOrNull");
        b.a(i2);
        int length = toIntOrNull.length();
        if (length == 0) {
            return null;
        }
        int i4 = 0;
        char charAt = toIntOrNull.charAt(0);
        int i5 = -2147483647;
        int i6 = 1;
        if (kotlin.jvm.internal.m.i(charAt, 48) >= 0) {
            z = false;
            i6 = 0;
        } else if (length == 1) {
            return null;
        } else {
            if (charAt == '-') {
                i5 = Integer.MIN_VALUE;
                z = true;
            } else if (charAt != '+') {
                return null;
            } else {
                z = false;
            }
        }
        int i7 = -59652323;
        while (i6 < length) {
            int b2 = b.b(toIntOrNull.charAt(i6), i2);
            if (b2 < 0) {
                return null;
            }
            if ((i4 < i7 && (i7 != -59652323 || i4 < (i7 = i5 / i2))) || (i3 = i4 * i2) < i5 + b2) {
                return null;
            }
            i4 = i3 - b2;
            i6++;
        }
        return z ? Integer.valueOf(i4) : Integer.valueOf(-i4);
    }

    public static Long s(String toLongOrNull) {
        Long t;
        kotlin.jvm.internal.m.g(toLongOrNull, "$this$toLongOrNull");
        t = t(toLongOrNull, 10);
        return t;
    }

    public static Long t(String toLongOrNull, int i2) {
        kotlin.jvm.internal.m.g(toLongOrNull, "$this$toLongOrNull");
        b.a(i2);
        int length = toLongOrNull.length();
        if (length == 0) {
            return null;
        }
        int i3 = 0;
        char charAt = toLongOrNull.charAt(0);
        long j2 = -9223372036854775807L;
        boolean z = true;
        if (kotlin.jvm.internal.m.i(charAt, 48) >= 0) {
            z = false;
        } else if (length == 1) {
            return null;
        } else {
            if (charAt == '-') {
                j2 = Long.MIN_VALUE;
                i3 = 1;
            } else if (charAt != '+') {
                return null;
            } else {
                z = false;
                i3 = 1;
            }
        }
        long j3 = -256204778801521550L;
        long j4 = 0;
        long j5 = -256204778801521550L;
        while (i3 < length) {
            int b2 = b.b(toLongOrNull.charAt(i3), i2);
            if (b2 < 0) {
                return null;
            }
            if (j4 < j5) {
                if (j5 == j3) {
                    j5 = j2 / i2;
                    if (j4 < j5) {
                    }
                }
                return null;
            }
            long j6 = j4 * i2;
            long j7 = b2;
            if (j6 < j2 + j7) {
                return null;
            }
            j4 = j6 - j7;
            i3++;
            j3 = -256204778801521550L;
        }
        return z ? Long.valueOf(j4) : Long.valueOf(-j4);
    }

    public static Short u(String toShortOrNull, int i2) {
        Integer r;
        int intValue;
        kotlin.jvm.internal.m.g(toShortOrNull, "$this$toShortOrNull");
        r = r(toShortOrNull, i2);
        if (r == null || (intValue = r.intValue()) < -32768 || intValue > 32767) {
            return null;
        }
        return Short.valueOf((short) intValue);
    }
}
package kotlin.i0;

import kotlin.i0.a;
import kotlin.jvm.internal.m;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: _Ranges.kt */
/* loaded from: classes3.dex */
public class f extends e {
    public static int b(int i2, int i3) {
        return i2 < i3 ? i3 : i2;
    }

    public static long c(long j2, long j3) {
        return j2 < j3 ? j3 : j2;
    }

    public static int d(int i2, int i3) {
        return i2 > i3 ? i3 : i2;
    }

    public static long e(long j2, long j3) {
        return j2 > j3 ? j3 : j2;
    }

    public static int f(int i2, int i3, int i4) {
        if (i3 <= i4) {
            return i2 < i3 ? i3 : i2 > i4 ? i4 : i2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i4 + " is less than minimum " + i3 + '.');
    }

    public static long g(long j2, long j3, long j4) {
        if (j3 <= j4) {
            return j2 < j3 ? j3 : j2 > j4 ? j4 : j2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + j4 + " is less than minimum " + j3 + '.');
    }

    public static a h(int i2, int i3) {
        return a.a.a(i2, i3, -1);
    }

    public static a i(a step, int i2) {
        m.g(step, "$this$step");
        e.a(i2 > 0, Integer.valueOf(i2));
        a.C0416a c0416a = a.a;
        int i3 = step.i();
        int k2 = step.k();
        if (step.l() <= 0) {
            i2 = -i2;
        }
        return c0416a.a(i3, k2, i2);
    }

    public static c j(int i2, int i3) {
        if (i3 <= Integer.MIN_VALUE) {
            return c.f17287f.a();
        }
        return new c(i2, i3 - 1);
    }
}
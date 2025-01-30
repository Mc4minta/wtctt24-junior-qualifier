package kotlin.m0;

import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: Duration.kt */
/* loaded from: classes3.dex */
public final class a implements Comparable<a> {

    /* renamed from: b  reason: collision with root package name */
    private static final long f17384b;

    /* renamed from: c  reason: collision with root package name */
    private static final long f17385c;

    /* renamed from: d  reason: collision with root package name */
    public static final C0417a f17386d = new C0417a(null);
    private static final long a = h(0);

    /* compiled from: Duration.kt */
    /* renamed from: kotlin.m0.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0417a {
        private C0417a() {
        }

        public /* synthetic */ C0417a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        long b2;
        long b3;
        b2 = b.b(4611686018427387903L);
        f17384b = b2;
        b3 = b.b(-4611686018427387903L);
        f17385c = b3;
    }

    public static long h(long j2) {
        if (y(j2)) {
            long s = s(j2);
            if (-4611686018426999999L > s || 4611686018426999999L < s) {
                throw new AssertionError(s(j2) + " ns is out of nanoseconds range");
            }
        } else {
            long s2 = s(j2);
            if (-4611686018427387903L <= s2 && 4611686018427387903L >= s2) {
                long s3 = s(j2);
                if (-4611686018426L <= s3 && 4611686018426L >= s3) {
                    throw new AssertionError(s(j2) + " ms is denormalized");
                }
            } else {
                throw new AssertionError(s(j2) + " ms is out of milliseconds range");
            }
        }
        return j2;
    }

    public static final double n(long j2) {
        return z(j2, TimeUnit.MINUTES);
    }

    private static final TimeUnit q(long j2) {
        return y(j2) ? TimeUnit.NANOSECONDS : TimeUnit.MILLISECONDS;
    }

    private static final long s(long j2) {
        return j2 >> 1;
    }

    private static final boolean y(long j2) {
        return (((int) j2) & 1) == 0;
    }

    public static final double z(long j2, TimeUnit unit) {
        m.g(unit, "unit");
        if (j2 == f17384b) {
            return Double.POSITIVE_INFINITY;
        }
        if (j2 == f17385c) {
            return Double.NEGATIVE_INFINITY;
        }
        return c.a(s(j2), q(j2), unit);
    }
}
package kotlin.m0;

import java.util.concurrent.TimeUnit;
import kotlin.i0.f;
import kotlin.jvm.internal.m;

/* compiled from: Duration.kt */
/* loaded from: classes3.dex */
public final class b {
    /* JADX INFO: Access modifiers changed from: private */
    public static final long b(long j2) {
        return a.h((j2 << 1) + 1);
    }

    private static final long c(long j2) {
        return a.h(j2 << 1);
    }

    public static final long d(long j2) {
        return e(j2, TimeUnit.MILLISECONDS);
    }

    public static final long e(long j2, TimeUnit unit) {
        long g2;
        m.g(unit, "unit");
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        long c2 = c.c(4611686018426999999L, timeUnit, unit);
        if ((-c2) <= j2 && c2 >= j2) {
            return c(c.c(j2, unit, timeUnit));
        }
        g2 = f.g(c.b(j2, unit, TimeUnit.MILLISECONDS), -4611686018427387903L, 4611686018427387903L);
        return b(g2);
    }
}
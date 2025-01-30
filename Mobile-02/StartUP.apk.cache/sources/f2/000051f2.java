package kotlin.h0;

import kotlin.jvm.internal.m;

/* compiled from: Random.kt */
/* loaded from: classes3.dex */
public final class d {
    public static final String a(Object from, Object until) {
        m.g(from, "from");
        m.g(until, "until");
        return "Random range is empty: [" + from + ", " + until + ").";
    }

    public static final void b(int i2, int i3) {
        if (!(i3 > i2)) {
            throw new IllegalArgumentException(a(Integer.valueOf(i2), Integer.valueOf(i3)).toString());
        }
    }

    public static final int c(int i2) {
        return 31 - Integer.numberOfLeadingZeros(i2);
    }

    public static final int d(int i2, int i3) {
        return (i2 >>> (32 - i3)) & ((-i3) >> 31);
    }
}
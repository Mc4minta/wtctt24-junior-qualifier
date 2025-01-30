package com.uber.autodispose;

import java.util.concurrent.atomic.AtomicLong;

/* compiled from: AutoDisposeBackpressureHelper.java */
/* loaded from: classes2.dex */
final class e {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static long a(AtomicLong atomicLong, long j2) {
        long j3;
        do {
            j3 = atomicLong.get();
            if (j3 == Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
        } while (!atomicLong.compareAndSet(j3, b(j3, j2)));
        return j3;
    }

    private static long b(long j2, long j3) {
        long j4 = j2 + j3;
        if (j4 < 0) {
            return Long.MAX_VALUE;
        }
        return j4;
    }
}
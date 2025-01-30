package com.google.android.gms.common.util;

import android.os.SystemClock;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
public class h implements e {
    private static final h a = new h();

    private h() {
    }

    public static e c() {
        return a;
    }

    @Override // com.google.android.gms.common.util.e
    public long a() {
        return System.currentTimeMillis();
    }

    @Override // com.google.android.gms.common.util.e
    public long b() {
        return SystemClock.elapsedRealtime();
    }

    @Override // com.google.android.gms.common.util.e
    public long nanoTime() {
        return System.nanoTime();
    }
}
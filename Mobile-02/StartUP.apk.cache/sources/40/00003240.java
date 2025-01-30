package com.google.android.gms.common.util.q;

import android.os.Process;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
final class b implements Runnable {
    private final Runnable a;

    /* renamed from: b  reason: collision with root package name */
    private final int f6340b;

    public b(Runnable runnable, int i2) {
        this.a = runnable;
        this.f6340b = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(this.f6340b);
        this.a.run();
    }
}
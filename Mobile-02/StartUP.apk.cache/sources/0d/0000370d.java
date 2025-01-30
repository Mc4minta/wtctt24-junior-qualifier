package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class x6 implements Runnable {
    private final /* synthetic */ AtomicReference a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ i6 f7940b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x6(i6 i6Var, AtomicReference atomicReference) {
        this.f7940b = i6Var;
        this.a = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.a) {
            this.a.set(Long.valueOf(this.f7940b.o().r(this.f7940b.r().D(), r.N)));
            this.a.notify();
        }
    }
}
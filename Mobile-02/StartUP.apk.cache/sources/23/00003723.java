package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class z6 implements Runnable {
    private final /* synthetic */ AtomicReference a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ i6 f7967b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z6(i6 i6Var, AtomicReference atomicReference) {
        this.f7967b = i6Var;
        this.a = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.a) {
            this.a.set(Double.valueOf(this.f7967b.o().x(this.f7967b.r().D(), r.P)));
            this.a.notify();
        }
    }
}
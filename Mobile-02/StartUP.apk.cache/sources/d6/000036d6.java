package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class s6 implements Runnable {
    private final /* synthetic */ AtomicReference a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ i6 f7851b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s6(i6 i6Var, AtomicReference atomicReference) {
        this.f7851b = i6Var;
        this.a = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.a) {
            this.a.set(this.f7851b.o().L(this.f7851b.r().D()));
            this.a.notify();
        }
    }
}
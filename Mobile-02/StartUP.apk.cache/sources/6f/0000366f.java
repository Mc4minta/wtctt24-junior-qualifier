package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class j6 implements Runnable {
    private final /* synthetic */ AtomicReference a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ i6 f7675b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j6(i6 i6Var, AtomicReference atomicReference) {
        this.f7675b = i6Var;
        this.a = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.a) {
            this.a.set(Boolean.valueOf(this.f7675b.o().J(this.f7675b.r().D())));
            this.a.notify();
        }
    }
}
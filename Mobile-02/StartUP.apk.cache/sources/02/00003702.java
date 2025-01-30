package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class w6 implements Runnable {
    private final /* synthetic */ AtomicReference a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ i6 f7927b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w6(i6 i6Var, AtomicReference atomicReference) {
        this.f7927b = i6Var;
        this.a = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.a) {
            this.a.set(Integer.valueOf(this.f7927b.o().w(this.f7927b.r().D(), r.O)));
            this.a.notify();
        }
    }
}
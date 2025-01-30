package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class n6 implements Runnable {
    private final /* synthetic */ AtomicReference a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ boolean f7767b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ i6 f7768c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n6(i6 i6Var, AtomicReference atomicReference, boolean z) {
        this.f7768c = i6Var;
        this.a = atomicReference;
        this.f7767b = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7768c.s().V(this.a, this.f7767b);
    }
}
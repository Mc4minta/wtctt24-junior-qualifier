package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class t7 implements Runnable {
    private final /* synthetic */ AtomicReference a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ z9 f7868b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ boolean f7869c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ s7 f7870d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t7(s7 s7Var, AtomicReference atomicReference, z9 z9Var, boolean z) {
        this.f7870d = s7Var;
        this.a = atomicReference;
        this.f7868b = z9Var;
        this.f7869c = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        p3 p3Var;
        synchronized (this.a) {
            try {
                p3Var = this.f7870d.f7853d;
            } catch (RemoteException e2) {
                this.f7870d.f().H().b("Failed to get all user properties; remote exception", e2);
                this.a.notify();
            }
            if (p3Var == null) {
                this.f7870d.f().H().a("Failed to get all user properties; not connected to service");
                this.a.notify();
                return;
            }
            this.a.set(p3Var.f0(this.f7868b, this.f7869c));
            this.f7870d.f0();
            this.a.notify();
        }
    }
}
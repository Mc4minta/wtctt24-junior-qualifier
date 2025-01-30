package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class v7 implements Runnable {
    private final /* synthetic */ AtomicReference a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ z9 f7910b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ s7 f7911c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v7(s7 s7Var, AtomicReference atomicReference, z9 z9Var) {
        this.f7911c = s7Var;
        this.a = atomicReference;
        this.f7910b = z9Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        p3 p3Var;
        synchronized (this.a) {
            try {
                p3Var = this.f7911c.f7853d;
            } catch (RemoteException e2) {
                this.f7911c.f().H().b("Failed to get app instance id", e2);
                this.a.notify();
            }
            if (p3Var == null) {
                this.f7911c.f().H().a("Failed to get app instance id");
                this.a.notify();
                return;
            }
            this.a.set(p3Var.M(this.f7910b));
            String str = (String) this.a.get();
            if (str != null) {
                this.f7911c.q().O(str);
                this.f7911c.n().m.b(str);
            }
            this.f7911c.f0();
            this.a.notify();
        }
    }
}
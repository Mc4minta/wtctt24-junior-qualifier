package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class x7 implements Runnable {
    private final /* synthetic */ z9 a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ s7 f7941b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x7(s7 s7Var, z9 z9Var) {
        this.f7941b = s7Var;
        this.a = z9Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        p3 p3Var;
        p3Var = this.f7941b.f7853d;
        if (p3Var == null) {
            this.f7941b.f().H().a("Discarding data. Failed to send app launch");
            return;
        }
        try {
            p3Var.g0(this.a);
            this.f7941b.u().K();
            this.f7941b.M(p3Var, null, this.a);
            this.f7941b.f0();
        } catch (RemoteException e2) {
            this.f7941b.f().H().b("Failed to send app launch to the service", e2);
        }
    }
}
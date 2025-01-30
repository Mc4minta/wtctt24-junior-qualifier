package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class b8 implements Runnable {
    private final /* synthetic */ z9 a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ s7 f7517b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b8(s7 s7Var, z9 z9Var) {
        this.f7517b = s7Var;
        this.a = z9Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        p3 p3Var;
        p3Var = this.f7517b.f7853d;
        if (p3Var == null) {
            this.f7517b.f().H().a("Failed to send measurementEnabled to service");
            return;
        }
        try {
            p3Var.t0(this.a);
            this.f7517b.f0();
        } catch (RemoteException e2) {
            this.f7517b.f().H().b("Failed to send measurementEnabled to the service", e2);
        }
    }
}
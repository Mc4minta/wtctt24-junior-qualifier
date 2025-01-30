package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class w7 implements Runnable {
    private final /* synthetic */ z9 a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ s7 f7928b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w7(s7 s7Var, z9 z9Var) {
        this.f7928b = s7Var;
        this.a = z9Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        p3 p3Var;
        p3Var = this.f7928b.f7853d;
        if (p3Var == null) {
            this.f7928b.f().H().a("Failed to reset data on the service: not connected to service");
            return;
        }
        try {
            p3Var.U(this.a);
        } catch (RemoteException e2) {
            this.f7928b.f().H().b("Failed to reset data on the service: remote exception", e2);
        }
        this.f7928b.f0();
    }
}
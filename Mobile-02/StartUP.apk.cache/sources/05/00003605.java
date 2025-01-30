package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class a8 implements Runnable {
    private final /* synthetic */ o7 a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ s7 f7489b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a8(s7 s7Var, o7 o7Var) {
        this.f7489b = s7Var;
        this.a = o7Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        p3 p3Var;
        p3Var = this.f7489b.f7853d;
        if (p3Var == null) {
            this.f7489b.f().H().a("Failed to send current screen to service");
            return;
        }
        try {
            o7 o7Var = this.a;
            if (o7Var == null) {
                p3Var.R(0L, null, null, this.f7489b.h().getPackageName());
            } else {
                p3Var.R(o7Var.f7788c, o7Var.a, o7Var.f7787b, this.f7489b.h().getPackageName());
            }
            this.f7489b.f0();
        } catch (RemoteException e2) {
            this.f7489b.f().H().b("Failed to send current screen to the service", e2);
        }
    }
}
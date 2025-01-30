package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.rc;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class y7 implements Runnable {
    private final /* synthetic */ z9 a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ rc f7957b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ s7 f7958c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y7(s7 s7Var, z9 z9Var, rc rcVar) {
        this.f7958c = s7Var;
        this.a = z9Var;
        this.f7957b = rcVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        p3 p3Var;
        try {
            p3Var = this.f7958c.f7853d;
            if (p3Var == null) {
                this.f7958c.f().H().a("Failed to get app instance id");
                return;
            }
            String M = p3Var.M(this.a);
            if (M != null) {
                this.f7958c.q().O(M);
                this.f7958c.n().m.b(M);
            }
            this.f7958c.f0();
            this.f7958c.m().R(this.f7957b, M);
        } catch (RemoteException e2) {
            this.f7958c.f().H().b("Failed to get app instance id", e2);
        } finally {
            this.f7958c.m().R(this.f7957b, null);
        }
    }
}
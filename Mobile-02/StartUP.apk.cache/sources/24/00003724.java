package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.rc;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class z7 implements Runnable {
    private final /* synthetic */ p a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f7968b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ rc f7969c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ s7 f7970d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z7(s7 s7Var, p pVar, String str, rc rcVar) {
        this.f7970d = s7Var;
        this.a = pVar;
        this.f7968b = str;
        this.f7969c = rcVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        p3 p3Var;
        try {
            p3Var = this.f7970d.f7853d;
            if (p3Var == null) {
                this.f7970d.f().H().a("Discarding data. Failed to send event to service to bundle");
                return;
            }
            byte[] G0 = p3Var.G0(this.a, this.f7968b);
            this.f7970d.f0();
            this.f7970d.m().U(this.f7969c, G0);
        } catch (RemoteException e2) {
            this.f7970d.f().H().b("Failed to send event to the service to bundle", e2);
        } finally {
            this.f7970d.m().U(this.f7969c, null);
        }
    }
}
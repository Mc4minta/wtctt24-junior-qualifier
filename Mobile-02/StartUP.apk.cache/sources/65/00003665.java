package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.rc;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class i8 implements Runnable {
    private final /* synthetic */ String a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f7647b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ boolean f7648c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ z9 f7649d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ rc f7650e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ s7 f7651f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i8(s7 s7Var, String str, String str2, boolean z, z9 z9Var, rc rcVar) {
        this.f7651f = s7Var;
        this.a = str;
        this.f7647b = str2;
        this.f7648c = z;
        this.f7649d = z9Var;
        this.f7650e = rcVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        p3 p3Var;
        Bundle bundle = new Bundle();
        try {
            p3Var = this.f7651f.f7853d;
            if (p3Var == null) {
                this.f7651f.f().H().c("Failed to get user properties; not connected to service", this.a, this.f7647b);
                return;
            }
            Bundle E = v9.E(p3Var.e0(this.a, this.f7647b, this.f7648c, this.f7649d));
            this.f7651f.f0();
            this.f7651f.m().Q(this.f7650e, E);
        } catch (RemoteException e2) {
            this.f7651f.f().H().c("Failed to get user properties; remote exception", this.a, e2);
        } finally {
            this.f7651f.m().Q(this.f7650e, bundle);
        }
    }
}
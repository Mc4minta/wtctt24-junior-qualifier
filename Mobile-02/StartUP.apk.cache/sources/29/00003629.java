package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class d8 implements Runnable {
    private final /* synthetic */ boolean a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ boolean f7538b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ ia f7539c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ z9 f7540d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ ia f7541e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ s7 f7542f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d8(s7 s7Var, boolean z, boolean z2, ia iaVar, z9 z9Var, ia iaVar2) {
        this.f7542f = s7Var;
        this.a = z;
        this.f7538b = z2;
        this.f7539c = iaVar;
        this.f7540d = z9Var;
        this.f7541e = iaVar2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        p3 p3Var;
        p3Var = this.f7542f.f7853d;
        if (p3Var == null) {
            this.f7542f.f().H().a("Discarding data. Failed to send conditional user property to service");
            return;
        }
        if (this.a) {
            this.f7542f.M(p3Var, this.f7538b ? null : this.f7539c, this.f7540d);
        } else {
            try {
                if (TextUtils.isEmpty(this.f7541e.a)) {
                    p3Var.r(this.f7539c, this.f7540d);
                } else {
                    p3Var.m0(this.f7539c);
                }
            } catch (RemoteException e2) {
                this.f7542f.f().H().b("Failed to send conditional user property to the service", e2);
            }
        }
        this.f7542f.f0();
    }
}
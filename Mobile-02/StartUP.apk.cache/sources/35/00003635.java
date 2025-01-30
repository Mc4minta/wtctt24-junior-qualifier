package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class e8 implements Runnable {
    private final /* synthetic */ boolean a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ boolean f7564b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ p f7565c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ z9 f7566d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ String f7567e;

    /* renamed from: f  reason: collision with root package name */
    private final /* synthetic */ s7 f7568f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e8(s7 s7Var, boolean z, boolean z2, p pVar, z9 z9Var, String str) {
        this.f7568f = s7Var;
        this.a = z;
        this.f7564b = z2;
        this.f7565c = pVar;
        this.f7566d = z9Var;
        this.f7567e = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        p3 p3Var;
        p3Var = this.f7568f.f7853d;
        if (p3Var == null) {
            this.f7568f.f().H().a("Discarding data. Failed to send event to service");
            return;
        }
        if (this.a) {
            this.f7568f.M(p3Var, this.f7564b ? null : this.f7565c, this.f7566d);
        } else {
            try {
                if (TextUtils.isEmpty(this.f7567e)) {
                    p3Var.n0(this.f7565c, this.f7566d);
                } else {
                    p3Var.r0(this.f7565c, this.f7567e, this.f7568f.f().Q());
                }
            } catch (RemoteException e2) {
                this.f7568f.f().H().b("Failed to send event to the service", e2);
            }
        }
        this.f7568f.f0();
    }
}
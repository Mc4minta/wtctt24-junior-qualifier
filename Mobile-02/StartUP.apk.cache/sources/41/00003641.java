package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.rc;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class f8 implements Runnable {
    private final /* synthetic */ String a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f7590b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ z9 f7591c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ rc f7592d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ s7 f7593e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f8(s7 s7Var, String str, String str2, z9 z9Var, rc rcVar) {
        this.f7593e = s7Var;
        this.a = str;
        this.f7590b = str2;
        this.f7591c = z9Var;
        this.f7592d = rcVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        p3 p3Var;
        ArrayList<Bundle> arrayList = new ArrayList<>();
        try {
            p3Var = this.f7593e.f7853d;
            if (p3Var == null) {
                this.f7593e.f().H().c("Failed to get conditional properties; not connected to service", this.a, this.f7590b);
                return;
            }
            ArrayList<Bundle> q0 = v9.q0(p3Var.W(this.a, this.f7590b, this.f7591c));
            this.f7593e.f0();
            this.f7593e.m().S(this.f7592d, q0);
        } catch (RemoteException e2) {
            this.f7593e.f().H().d("Failed to get conditional properties; remote exception", this.a, this.f7590b, e2);
        } finally {
            this.f7593e.m().S(this.f7592d, arrayList);
        }
    }
}
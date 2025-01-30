package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class s4 implements ServiceConnection {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ t4 f7849b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s4(t4 t4Var, String str) {
        this.f7849b = t4Var;
        this.a = str;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (iBinder == null) {
            this.f7849b.a.f().K().a("Install Referrer connection returned with null binder");
            return;
        }
        try {
            com.google.android.gms.internal.measurement.k2 p = com.google.android.gms.internal.measurement.h5.p(iBinder);
            if (p == null) {
                this.f7849b.a.f().K().a("Install Referrer Service implementation was not found");
                return;
            }
            this.f7849b.a.f().P().a("Install Referrer Service connected");
            this.f7849b.a.l().A(new v4(this, p, this));
        } catch (Exception e2) {
            this.f7849b.a.f().K().b("Exception occurred while calling Install Referrer API", e2);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f7849b.a.f().P().a("Install Referrer Service disconnected");
    }
}
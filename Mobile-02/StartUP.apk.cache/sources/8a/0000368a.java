package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.internal.c;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class l8 implements ServiceConnection, c.a, c.b {
    private volatile boolean a;

    /* renamed from: b  reason: collision with root package name */
    private volatile y3 f7747b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ s7 f7748c;

    /* JADX INFO: Access modifiers changed from: protected */
    public l8(s7 s7Var) {
        this.f7748c = s7Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean c(l8 l8Var, boolean z) {
        l8Var.a = false;
        return false;
    }

    public final void a() {
        if (this.f7747b != null && (this.f7747b.j() || this.f7747b.d())) {
            this.f7747b.disconnect();
        }
        this.f7747b = null;
    }

    public final void b(Intent intent) {
        l8 l8Var;
        this.f7748c.d();
        Context h2 = this.f7748c.h();
        com.google.android.gms.common.stats.a b2 = com.google.android.gms.common.stats.a.b();
        synchronized (this) {
            if (this.a) {
                this.f7748c.f().P().a("Connection attempt already in progress");
                return;
            }
            this.f7748c.f().P().a("Using local app measurement service");
            this.a = true;
            l8Var = this.f7748c.f7852c;
            b2.a(h2, intent, l8Var, 129);
        }
    }

    public final void d() {
        this.f7748c.d();
        Context h2 = this.f7748c.h();
        synchronized (this) {
            if (this.a) {
                this.f7748c.f().P().a("Connection attempt already in progress");
            } else if (this.f7747b != null && (this.f7747b.d() || this.f7747b.j())) {
                this.f7748c.f().P().a("Already awaiting connection attempt");
            } else {
                this.f7747b = new y3(h2, Looper.getMainLooper(), this, this);
                this.f7748c.f().P().a("Connecting to remote service");
                this.a = true;
                this.f7747b.r();
            }
        }
    }

    @Override // com.google.android.gms.common.internal.c.a
    public final void n(int i2) {
        com.google.android.gms.common.internal.t.f("MeasurementServiceConnection.onConnectionSuspended");
        this.f7748c.f().O().a("Service connection suspended");
        this.f7748c.l().A(new p8(this));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        l8 l8Var;
        p3 r3Var;
        com.google.android.gms.common.internal.t.f("MeasurementServiceConnection.onServiceConnected");
        synchronized (this) {
            if (iBinder == null) {
                this.a = false;
                this.f7748c.f().H().a("Service connected with null binder");
                return;
            }
            p3 p3Var = null;
            try {
                String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                if ("com.google.android.gms.measurement.internal.IMeasurementService".equals(interfaceDescriptor)) {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    if (queryLocalInterface instanceof p3) {
                        r3Var = (p3) queryLocalInterface;
                    } else {
                        r3Var = new r3(iBinder);
                    }
                    p3Var = r3Var;
                    this.f7748c.f().P().a("Bound to IMeasurementService interface");
                } else {
                    this.f7748c.f().H().b("Got binder with a wrong descriptor", interfaceDescriptor);
                }
            } catch (RemoteException unused) {
                this.f7748c.f().H().a("Service connect failed to get IMeasurementService");
            }
            if (p3Var == null) {
                this.a = false;
                try {
                    com.google.android.gms.common.stats.a b2 = com.google.android.gms.common.stats.a.b();
                    Context h2 = this.f7748c.h();
                    l8Var = this.f7748c.f7852c;
                    b2.c(h2, l8Var);
                } catch (IllegalArgumentException unused2) {
                }
            } else {
                this.f7748c.l().A(new k8(this, p3Var));
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        com.google.android.gms.common.internal.t.f("MeasurementServiceConnection.onServiceDisconnected");
        this.f7748c.f().O().a("Service disconnected");
        this.f7748c.l().A(new n8(this, componentName));
    }

    @Override // com.google.android.gms.common.internal.c.b
    public final void p(com.google.android.gms.common.b bVar) {
        com.google.android.gms.common.internal.t.f("MeasurementServiceConnection.onConnectionFailed");
        x3 C = this.f7748c.a.C();
        if (C != null) {
            C.K().b("Service connection failed", bVar);
        }
        synchronized (this) {
            this.a = false;
            this.f7747b = null;
        }
        this.f7748c.l().A(new o8(this));
    }

    @Override // com.google.android.gms.common.internal.c.a
    public final void q(Bundle bundle) {
        com.google.android.gms.common.internal.t.f("MeasurementServiceConnection.onConnected");
        synchronized (this) {
            try {
                this.f7748c.l().A(new m8(this, this.f7747b.B()));
            } catch (DeadObjectException | IllegalStateException unused) {
                this.f7747b = null;
                this.a = false;
            }
        }
    }
}
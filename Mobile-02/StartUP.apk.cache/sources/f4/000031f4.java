package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.internal.i;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
public final class l0 extends i implements Handler.Callback {

    /* renamed from: d  reason: collision with root package name */
    private final Context f6250d;

    /* renamed from: e  reason: collision with root package name */
    private final Handler f6251e;

    /* renamed from: c  reason: collision with root package name */
    private final HashMap<i.a, n0> f6249c = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    private final com.google.android.gms.common.stats.a f6252f = com.google.android.gms.common.stats.a.b();

    /* renamed from: g  reason: collision with root package name */
    private final long f6253g = 5000;

    /* renamed from: h  reason: collision with root package name */
    private final long f6254h = 300000;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l0(Context context) {
        this.f6250d = context.getApplicationContext();
        this.f6251e = new e.g.a.e.d.e.h(context.getMainLooper(), this);
    }

    @Override // com.google.android.gms.common.internal.i
    protected final boolean e(i.a aVar, ServiceConnection serviceConnection, String str) {
        boolean d2;
        t.l(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f6249c) {
            n0 n0Var = this.f6249c.get(aVar);
            if (n0Var == null) {
                n0Var = new n0(this, aVar);
                n0Var.e(serviceConnection, serviceConnection, str);
                n0Var.h(str);
                this.f6249c.put(aVar, n0Var);
            } else {
                this.f6251e.removeMessages(0, aVar);
                if (!n0Var.g(serviceConnection)) {
                    n0Var.e(serviceConnection, serviceConnection, str);
                    int c2 = n0Var.c();
                    if (c2 == 1) {
                        serviceConnection.onServiceConnected(n0Var.b(), n0Var.a());
                    } else if (c2 == 2) {
                        n0Var.h(str);
                    }
                } else {
                    String valueOf = String.valueOf(aVar);
                    StringBuilder sb = new StringBuilder(valueOf.length() + 81);
                    sb.append("Trying to bind a GmsServiceConnection that was already connected before.  config=");
                    sb.append(valueOf);
                    throw new IllegalStateException(sb.toString());
                }
            }
            d2 = n0Var.d();
        }
        return d2;
    }

    @Override // com.google.android.gms.common.internal.i
    protected final void f(i.a aVar, ServiceConnection serviceConnection, String str) {
        t.l(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f6249c) {
            n0 n0Var = this.f6249c.get(aVar);
            if (n0Var != null) {
                if (n0Var.g(serviceConnection)) {
                    n0Var.f(serviceConnection, str);
                    if (n0Var.j()) {
                        this.f6251e.sendMessageDelayed(this.f6251e.obtainMessage(0, aVar), this.f6253g);
                    }
                } else {
                    String valueOf = String.valueOf(aVar);
                    StringBuilder sb = new StringBuilder(valueOf.length() + 76);
                    sb.append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=");
                    sb.append(valueOf);
                    throw new IllegalStateException(sb.toString());
                }
            } else {
                String valueOf2 = String.valueOf(aVar);
                StringBuilder sb2 = new StringBuilder(valueOf2.length() + 50);
                sb2.append("Nonexistent connection status for service config: ");
                sb2.append(valueOf2);
                throw new IllegalStateException(sb2.toString());
            }
        }
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i2 = message.what;
        if (i2 == 0) {
            synchronized (this.f6249c) {
                i.a aVar = (i.a) message.obj;
                n0 n0Var = this.f6249c.get(aVar);
                if (n0Var != null && n0Var.j()) {
                    if (n0Var.d()) {
                        n0Var.i("GmsClientSupervisor");
                    }
                    this.f6249c.remove(aVar);
                }
            }
            return true;
        } else if (i2 != 1) {
            return false;
        } else {
            synchronized (this.f6249c) {
                i.a aVar2 = (i.a) message.obj;
                n0 n0Var2 = this.f6249c.get(aVar2);
                if (n0Var2 != null && n0Var2.c() == 3) {
                    String valueOf = String.valueOf(aVar2);
                    StringBuilder sb = new StringBuilder(valueOf.length() + 47);
                    sb.append("Timeout waiting for ServiceConnection callback ");
                    sb.append(valueOf);
                    Log.e("GmsClientSupervisor", sb.toString(), new Exception());
                    ComponentName b2 = n0Var2.b();
                    if (b2 == null) {
                        b2 = aVar2.a();
                    }
                    if (b2 == null) {
                        b2 = new ComponentName(aVar2.b(), "unknown");
                    }
                    n0Var2.onServiceDisconnected(b2);
                }
            }
            return true;
        }
    }
}
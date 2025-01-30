package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.google.android.gms.common.internal.i;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
public final class n0 implements ServiceConnection {
    private final Map<ServiceConnection, ServiceConnection> a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private int f6256b = 2;

    /* renamed from: c  reason: collision with root package name */
    private boolean f6257c;

    /* renamed from: d  reason: collision with root package name */
    private IBinder f6258d;

    /* renamed from: e  reason: collision with root package name */
    private final i.a f6259e;

    /* renamed from: f  reason: collision with root package name */
    private ComponentName f6260f;

    /* renamed from: g  reason: collision with root package name */
    private final /* synthetic */ l0 f6261g;

    public n0(l0 l0Var, i.a aVar) {
        this.f6261g = l0Var;
        this.f6259e = aVar;
    }

    public final IBinder a() {
        return this.f6258d;
    }

    public final ComponentName b() {
        return this.f6260f;
    }

    public final int c() {
        return this.f6256b;
    }

    public final boolean d() {
        return this.f6257c;
    }

    public final void e(ServiceConnection serviceConnection, ServiceConnection serviceConnection2, String str) {
        Context context;
        com.google.android.gms.common.stats.a unused;
        Context unused2;
        unused = this.f6261g.f6252f;
        unused2 = this.f6261g.f6250d;
        i.a aVar = this.f6259e;
        context = this.f6261g.f6250d;
        aVar.c(context);
        this.a.put(serviceConnection, serviceConnection2);
    }

    public final void f(ServiceConnection serviceConnection, String str) {
        com.google.android.gms.common.stats.a unused;
        Context unused2;
        unused = this.f6261g.f6252f;
        unused2 = this.f6261g.f6250d;
        this.a.remove(serviceConnection);
    }

    public final boolean g(ServiceConnection serviceConnection) {
        return this.a.containsKey(serviceConnection);
    }

    public final void h(String str) {
        com.google.android.gms.common.stats.a aVar;
        Context context;
        Context context2;
        com.google.android.gms.common.stats.a aVar2;
        Context context3;
        Handler handler;
        Handler handler2;
        long j2;
        this.f6256b = 3;
        aVar = this.f6261g.f6252f;
        context = this.f6261g.f6250d;
        i.a aVar3 = this.f6259e;
        context2 = this.f6261g.f6250d;
        boolean d2 = aVar.d(context, str, aVar3.c(context2), this, this.f6259e.d());
        this.f6257c = d2;
        if (d2) {
            handler = this.f6261g.f6251e;
            Message obtainMessage = handler.obtainMessage(1, this.f6259e);
            handler2 = this.f6261g.f6251e;
            j2 = this.f6261g.f6254h;
            handler2.sendMessageDelayed(obtainMessage, j2);
            return;
        }
        this.f6256b = 2;
        try {
            aVar2 = this.f6261g.f6252f;
            context3 = this.f6261g.f6250d;
            aVar2.c(context3, this);
        } catch (IllegalArgumentException unused) {
        }
    }

    public final void i(String str) {
        Handler handler;
        com.google.android.gms.common.stats.a aVar;
        Context context;
        handler = this.f6261g.f6251e;
        handler.removeMessages(1, this.f6259e);
        aVar = this.f6261g.f6252f;
        context = this.f6261g.f6250d;
        aVar.c(context, this);
        this.f6257c = false;
        this.f6256b = 2;
    }

    public final boolean j() {
        return this.a.isEmpty();
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        HashMap hashMap;
        Handler handler;
        hashMap = this.f6261g.f6249c;
        synchronized (hashMap) {
            handler = this.f6261g.f6251e;
            handler.removeMessages(1, this.f6259e);
            this.f6258d = iBinder;
            this.f6260f = componentName;
            for (ServiceConnection serviceConnection : this.a.values()) {
                serviceConnection.onServiceConnected(componentName, iBinder);
            }
            this.f6256b = 1;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        HashMap hashMap;
        Handler handler;
        hashMap = this.f6261g.f6249c;
        synchronized (hashMap) {
            handler = this.f6261g.f6251e;
            handler.removeMessages(1, this.f6259e);
            this.f6258d = null;
            this.f6260f = componentName;
            for (ServiceConnection serviceConnection : this.a.values()) {
                serviceConnection.onServiceDisconnected(componentName);
            }
            this.f6256b = 2;
        }
    }
}
package com.google.firebase.iid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-iid@@20.1.6 */
/* loaded from: classes2.dex */
public final class f implements ServiceConnection {
    int a;

    /* renamed from: b  reason: collision with root package name */
    final Messenger f9158b;

    /* renamed from: c  reason: collision with root package name */
    o f9159c;

    /* renamed from: d  reason: collision with root package name */
    final Queue<p<?>> f9160d;

    /* renamed from: e  reason: collision with root package name */
    final SparseArray<p<?>> f9161e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ e f9162f;

    private f(e eVar) {
        this.f9162f = eVar;
        this.a = 0;
        this.f9158b = new Messenger(new e.g.a.e.d.f.e(Looper.getMainLooper(), new Handler.Callback(this) { // from class: com.google.firebase.iid.i
            private final f a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
            }

            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return this.a.d(message);
            }
        }));
        this.f9160d = new ArrayDeque();
        this.f9161e = new SparseArray<>();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        ScheduledExecutorService scheduledExecutorService;
        scheduledExecutorService = this.f9162f.f9147c;
        scheduledExecutorService.execute(new Runnable(this) { // from class: com.google.firebase.iid.j
            private final f a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                final p<?> poll;
                ScheduledExecutorService scheduledExecutorService2;
                Context context;
                final f fVar = this.a;
                while (true) {
                    synchronized (fVar) {
                        if (fVar.a != 2) {
                            return;
                        }
                        if (fVar.f9160d.isEmpty()) {
                            fVar.f();
                            return;
                        }
                        poll = fVar.f9160d.poll();
                        fVar.f9161e.put(poll.a, poll);
                        scheduledExecutorService2 = fVar.f9162f.f9147c;
                        scheduledExecutorService2.schedule(new Runnable(fVar, poll) { // from class: com.google.firebase.iid.l
                            private final f a;

                            /* renamed from: b  reason: collision with root package name */
                            private final p f9172b;

                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                this.a = fVar;
                                this.f9172b = poll;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                this.a.b(this.f9172b.a);
                            }
                        }, 30L, TimeUnit.SECONDS);
                    }
                    if (Log.isLoggable("MessengerIpcClient", 3)) {
                        String valueOf = String.valueOf(poll);
                        StringBuilder sb = new StringBuilder(valueOf.length() + 8);
                        sb.append("Sending ");
                        sb.append(valueOf);
                        Log.d("MessengerIpcClient", sb.toString());
                    }
                    context = fVar.f9162f.f9146b;
                    Messenger messenger = fVar.f9158b;
                    Message obtain = Message.obtain();
                    obtain.what = poll.f9177c;
                    obtain.arg1 = poll.a;
                    obtain.replyTo = messenger;
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("oneWay", poll.d());
                    bundle.putString("pkg", context.getPackageName());
                    bundle.putBundle("data", poll.f9178d);
                    obtain.setData(bundle);
                    try {
                        fVar.f9159c.a(obtain);
                    } catch (RemoteException e2) {
                        fVar.c(2, e2.getMessage());
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void b(int i2) {
        p<?> pVar = this.f9161e.get(i2);
        if (pVar != null) {
            StringBuilder sb = new StringBuilder(31);
            sb.append("Timing out request: ");
            sb.append(i2);
            Log.w("MessengerIpcClient", sb.toString());
            this.f9161e.remove(i2);
            pVar.b(new zzam(3, "Timed out waiting for response"));
            f();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void c(int i2, String str) {
        Context context;
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(str);
            Log.d("MessengerIpcClient", valueOf.length() != 0 ? "Disconnected: ".concat(valueOf) : new String("Disconnected: "));
        }
        int i3 = this.a;
        if (i3 == 0) {
            throw new IllegalStateException();
        }
        if (i3 != 1 && i3 != 2) {
            if (i3 == 3) {
                this.a = 4;
                return;
            } else if (i3 == 4) {
                return;
            } else {
                int i4 = this.a;
                StringBuilder sb = new StringBuilder(26);
                sb.append("Unknown state: ");
                sb.append(i4);
                throw new IllegalStateException(sb.toString());
            }
        }
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Unbinding service");
        }
        this.a = 4;
        com.google.android.gms.common.stats.a b2 = com.google.android.gms.common.stats.a.b();
        context = this.f9162f.f9146b;
        b2.c(context, this);
        zzam zzamVar = new zzam(i2, str);
        for (p<?> pVar : this.f9160d) {
            pVar.b(zzamVar);
        }
        this.f9160d.clear();
        for (int i5 = 0; i5 < this.f9161e.size(); i5++) {
            this.f9161e.valueAt(i5).b(zzamVar);
        }
        this.f9161e.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean d(Message message) {
        int i2 = message.arg1;
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            StringBuilder sb = new StringBuilder(41);
            sb.append("Received response to request: ");
            sb.append(i2);
            Log.d("MessengerIpcClient", sb.toString());
        }
        synchronized (this) {
            p<?> pVar = this.f9161e.get(i2);
            if (pVar == null) {
                StringBuilder sb2 = new StringBuilder(50);
                sb2.append("Received response for unknown request: ");
                sb2.append(i2);
                Log.w("MessengerIpcClient", sb2.toString());
                return true;
            }
            this.f9161e.remove(i2);
            f();
            Bundle data = message.getData();
            if (data.getBoolean("unsupported", false)) {
                pVar.b(new zzam(4, "Not supported by GmsCore"));
            } else {
                pVar.a(data);
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized boolean e(p<?> pVar) {
        Context context;
        ScheduledExecutorService scheduledExecutorService;
        int i2 = this.a;
        if (i2 == 0) {
            this.f9160d.add(pVar);
            com.google.android.gms.common.internal.t.n(this.a == 0);
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Starting bind to GmsCore");
            }
            this.a = 1;
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            com.google.android.gms.common.stats.a b2 = com.google.android.gms.common.stats.a.b();
            context = this.f9162f.f9146b;
            if (b2.a(context, intent, this, 1)) {
                scheduledExecutorService = this.f9162f.f9147c;
                scheduledExecutorService.schedule(new Runnable(this) { // from class: com.google.firebase.iid.h
                    private final f a;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.a = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.g();
                    }
                }, 30L, TimeUnit.SECONDS);
            } else {
                c(0, "Unable to bind to service");
            }
            return true;
        } else if (i2 == 1) {
            this.f9160d.add(pVar);
            return true;
        } else if (i2 == 2) {
            this.f9160d.add(pVar);
            a();
            return true;
        } else {
            if (i2 != 3 && i2 != 4) {
                int i3 = this.a;
                StringBuilder sb = new StringBuilder(26);
                sb.append("Unknown state: ");
                sb.append(i3);
                throw new IllegalStateException(sb.toString());
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void f() {
        Context context;
        if (this.a == 2 && this.f9160d.isEmpty() && this.f9161e.size() == 0) {
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Finished handling requests, unbinding");
            }
            this.a = 3;
            com.google.android.gms.common.stats.a b2 = com.google.android.gms.common.stats.a.b();
            context = this.f9162f.f9146b;
            b2.c(context, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void g() {
        if (this.a == 1) {
            c(1, "Timed out while binding");
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        ScheduledExecutorService scheduledExecutorService;
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service connected");
        }
        scheduledExecutorService = this.f9162f.f9147c;
        scheduledExecutorService.execute(new Runnable(this, iBinder) { // from class: com.google.firebase.iid.k
            private final f a;

            /* renamed from: b  reason: collision with root package name */
            private final IBinder f9166b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
                this.f9166b = iBinder;
            }

            @Override // java.lang.Runnable
            public final void run() {
                f fVar = this.a;
                IBinder iBinder2 = this.f9166b;
                synchronized (fVar) {
                    try {
                        if (iBinder2 == null) {
                            fVar.c(0, "Null service connection");
                            return;
                        }
                        try {
                            fVar.f9159c = new o(iBinder2);
                            fVar.a = 2;
                            fVar.a();
                        } catch (RemoteException e2) {
                            fVar.c(0, e2.getMessage());
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        });
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        ScheduledExecutorService scheduledExecutorService;
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service disconnected");
        }
        scheduledExecutorService = this.f9162f.f9147c;
        scheduledExecutorService.execute(new Runnable(this) { // from class: com.google.firebase.iid.m
            private final f a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.c(2, "Service disconnected");
            }
        });
    }
}
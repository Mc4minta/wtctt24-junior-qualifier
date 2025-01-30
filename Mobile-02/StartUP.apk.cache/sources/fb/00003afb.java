package com.google.firebase.iid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.firebase:firebase-iid@@20.1.6 */
/* loaded from: classes2.dex */
public final class k0 implements ServiceConnection {
    private final Context a;

    /* renamed from: b  reason: collision with root package name */
    private final Intent f9167b;

    /* renamed from: c  reason: collision with root package name */
    private final ScheduledExecutorService f9168c;

    /* renamed from: d  reason: collision with root package name */
    private final Queue<j0> f9169d;

    /* renamed from: e  reason: collision with root package name */
    private f0 f9170e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f9171f;

    public k0(Context context, String str) {
        this(context, str, new ScheduledThreadPoolExecutor(0, new com.google.android.gms.common.util.q.a("Firebase-FirebaseInstanceIdServiceConnection")));
    }

    private final synchronized void b() {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "flush queue called");
        }
        while (!this.f9169d.isEmpty()) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                Log.d("FirebaseInstanceId", "found intent to be delivered");
            }
            f0 f0Var = this.f9170e;
            if (f0Var != null && f0Var.isBinderAlive()) {
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    Log.d("FirebaseInstanceId", "binder is alive, sending the intent.");
                }
                this.f9170e.a(this.f9169d.poll());
            } else {
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    boolean z = !this.f9171f;
                    StringBuilder sb = new StringBuilder(39);
                    sb.append("binder is dead. start connection? ");
                    sb.append(z);
                    Log.d("FirebaseInstanceId", sb.toString());
                }
                if (!this.f9171f) {
                    this.f9171f = true;
                    try {
                    } catch (SecurityException e2) {
                        Log.e("FirebaseInstanceId", "Exception while binding the service", e2);
                    }
                    if (com.google.android.gms.common.stats.a.b().a(this.a, this.f9167b, this, 65)) {
                        return;
                    }
                    Log.e("FirebaseInstanceId", "binding to the service failed");
                    this.f9171f = false;
                    c();
                }
                return;
            }
        }
    }

    private final void c() {
        while (!this.f9169d.isEmpty()) {
            this.f9169d.poll().b();
        }
    }

    public final synchronized com.google.android.gms.tasks.g<Void> a(Intent intent) {
        j0 j0Var;
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "new intent queued in the bind-strategy delivery");
        }
        j0Var = new j0(intent);
        ScheduledExecutorService scheduledExecutorService = this.f9168c;
        j0Var.a().c(scheduledExecutorService, new com.google.android.gms.tasks.c(scheduledExecutorService.schedule(new Runnable(j0Var) { // from class: com.google.firebase.iid.m0
            private final j0 a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = j0Var;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.c();
            }
        }, 9000L, TimeUnit.MILLISECONDS)) { // from class: com.google.firebase.iid.l0
            private final ScheduledFuture a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = r1;
            }

            @Override // com.google.android.gms.tasks.c
            public final void a(com.google.android.gms.tasks.g gVar) {
                this.a.cancel(false);
            }
        });
        this.f9169d.add(j0Var);
        b();
        return j0Var.a();
    }

    @Override // android.content.ServiceConnection
    public final synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            String valueOf = String.valueOf(componentName);
            StringBuilder sb = new StringBuilder(valueOf.length() + 20);
            sb.append("onServiceConnected: ");
            sb.append(valueOf);
            Log.d("FirebaseInstanceId", sb.toString());
        }
        this.f9171f = false;
        if (!(iBinder instanceof f0)) {
            String valueOf2 = String.valueOf(iBinder);
            StringBuilder sb2 = new StringBuilder(valueOf2.length() + 28);
            sb2.append("Invalid service connection: ");
            sb2.append(valueOf2);
            Log.e("FirebaseInstanceId", sb2.toString());
            c();
            return;
        }
        this.f9170e = (f0) iBinder;
        b();
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            String valueOf = String.valueOf(componentName);
            StringBuilder sb = new StringBuilder(valueOf.length() + 23);
            sb.append("onServiceDisconnected: ");
            sb.append(valueOf);
            Log.d("FirebaseInstanceId", sb.toString());
        }
        b();
    }

    private k0(Context context, String str, ScheduledExecutorService scheduledExecutorService) {
        this.f9169d = new ArrayDeque();
        this.f9171f = false;
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        this.f9167b = new Intent(str).setPackage(applicationContext.getPackageName());
        this.f9168c = scheduledExecutorService;
    }
}
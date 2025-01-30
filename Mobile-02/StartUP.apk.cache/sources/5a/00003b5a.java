package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import com.google.firebase.iid.f0;
import com.google.firebase.iid.g0;
import com.google.firebase.iid.h0;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.firebase:firebase-messaging@@20.1.6 */
@SuppressLint({"UnwrappedWakefulBroadcastReceiver"})
/* loaded from: classes2.dex */
public abstract class h extends Service {
    private Binder zzb;
    private int zzd;
    private final ExecutorService zza = e.g.a.e.d.f.a.a().b(new com.google.android.gms.common.util.q.a("Firebase-Messaging-Intent-Handle"), e.g.a.e.d.f.f.a);
    private final Object zzc = new Object();
    private int zze = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zze */
    public final com.google.android.gms.tasks.g<Void> zzd(Intent intent) {
        if (zzb(intent)) {
            return com.google.android.gms.tasks.j.e(null);
        }
        com.google.android.gms.tasks.h hVar = new com.google.android.gms.tasks.h();
        this.zza.execute(new Runnable(this, intent, hVar) { // from class: com.google.firebase.messaging.j
            private final h a;

            /* renamed from: b  reason: collision with root package name */
            private final Intent f9274b;

            /* renamed from: c  reason: collision with root package name */
            private final com.google.android.gms.tasks.h f9275c;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
                this.f9274b = intent;
                this.f9275c = hVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                h hVar2 = this.a;
                Intent intent2 = this.f9274b;
                com.google.android.gms.tasks.h hVar3 = this.f9275c;
                try {
                    hVar2.zzc(intent2);
                } finally {
                    hVar3.c(null);
                }
            }
        });
        return hVar.a();
    }

    private final void zzf(Intent intent) {
        if (intent != null) {
            g0.b(intent);
        }
        synchronized (this.zzc) {
            int i2 = this.zze - 1;
            this.zze = i2;
            if (i2 == 0) {
                stopSelfResult(this.zzd);
            }
        }
    }

    @Override // android.app.Service
    public final synchronized IBinder onBind(Intent intent) {
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "Service received bind request");
        }
        if (this.zzb == null) {
            this.zzb = new f0(new h0(this) { // from class: com.google.firebase.messaging.g
                private final h a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.a = this;
                }

                @Override // com.google.firebase.iid.h0
                public final com.google.android.gms.tasks.g a(Intent intent2) {
                    return this.a.zzd(intent2);
                }
            });
        }
        return this.zzb;
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.zza.shutdown();
        super.onDestroy();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i2, int i3) {
        synchronized (this.zzc) {
            this.zzd = i3;
            this.zze++;
        }
        Intent zza = zza(intent);
        if (zza == null) {
            zzf(intent);
            return 2;
        }
        com.google.android.gms.tasks.g<Void> zzd = zzd(zza);
        if (zzd.p()) {
            zzf(intent);
            return 2;
        }
        zzd.c(i.a, new com.google.android.gms.tasks.c(this, intent) { // from class: com.google.firebase.messaging.l
            private final h a;

            /* renamed from: b  reason: collision with root package name */
            private final Intent f9276b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
                this.f9276b = intent;
            }

            @Override // com.google.android.gms.tasks.c
            public final void a(com.google.android.gms.tasks.g gVar) {
                this.a.zza(this.f9276b, gVar);
            }
        });
        return 3;
    }

    protected abstract Intent zza(Intent intent);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Intent intent, com.google.android.gms.tasks.g gVar) {
        zzf(intent);
    }

    public abstract boolean zzb(Intent intent);

    public abstract void zzc(Intent intent);
}
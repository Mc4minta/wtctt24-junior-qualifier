package com.google.firebase.iid;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.firebase:firebase-iid@@20.1.6 */
/* loaded from: classes2.dex */
public final class e {
    private static e a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f9146b;

    /* renamed from: c  reason: collision with root package name */
    private final ScheduledExecutorService f9147c;

    /* renamed from: d  reason: collision with root package name */
    private f f9148d = new f(this);

    /* renamed from: e  reason: collision with root package name */
    private int f9149e = 1;

    private e(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.f9147c = scheduledExecutorService;
        this.f9146b = context.getApplicationContext();
    }

    private final synchronized int a() {
        int i2;
        i2 = this.f9149e;
        this.f9149e = i2 + 1;
        return i2;
    }

    private final synchronized <T> com.google.android.gms.tasks.g<T> d(p<T> pVar) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(pVar);
            StringBuilder sb = new StringBuilder(valueOf.length() + 9);
            sb.append("Queueing ");
            sb.append(valueOf);
            Log.d("MessengerIpcClient", sb.toString());
        }
        if (!this.f9148d.e(pVar)) {
            f fVar = new f(this);
            this.f9148d = fVar;
            fVar.e(pVar);
        }
        return pVar.f9176b.a();
    }

    public static synchronized e e(Context context) {
        e eVar;
        synchronized (e.class) {
            if (a == null) {
                a = new e(context, e.g.a.e.d.f.a.a().a(1, new com.google.android.gms.common.util.q.a("MessengerIpcClient"), e.g.a.e.d.f.f.a));
            }
            eVar = a;
        }
        return eVar;
    }

    public final com.google.android.gms.tasks.g<Void> c(int i2, Bundle bundle) {
        return d(new n(a(), 2, bundle));
    }

    public final com.google.android.gms.tasks.g<Bundle> f(int i2, Bundle bundle) {
        return d(new r(a(), 1, bundle));
    }
}
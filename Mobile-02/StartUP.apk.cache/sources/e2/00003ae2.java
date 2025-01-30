package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import android.util.Log;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.firebase:firebase-iid@@20.1.6 */
/* loaded from: classes2.dex */
public final class c implements c0 {
    private static final Object a = new Object();

    /* renamed from: b */
    private static k0 f9136b;

    /* renamed from: c */
    private final Context f9137c;

    /* renamed from: d */
    private final ExecutorService f9138d;

    public c(Context context, ExecutorService executorService) {
        this.f9137c = context;
        this.f9138d = executorService;
    }

    public static final /* synthetic */ com.google.android.gms.tasks.g b(Context context, Intent intent, com.google.android.gms.tasks.g gVar) throws Exception {
        return (com.google.android.gms.common.util.l.j() && ((Integer) gVar.m()).intValue() == 402) ? f(context, intent).i(s0.a(), p0.a) : gVar;
    }

    private static k0 c(Context context, String str) {
        k0 k0Var;
        synchronized (a) {
            if (f9136b == null) {
                f9136b = new k0(context, str);
            }
            k0Var = f9136b;
        }
        return k0Var;
    }

    public static final /* synthetic */ Integer d(Context context, Intent intent) throws Exception {
        return Integer.valueOf(y.b().a(context, intent));
    }

    public static final /* synthetic */ Integer e(com.google.android.gms.tasks.g gVar) throws Exception {
        return -1;
    }

    private static com.google.android.gms.tasks.g<Integer> f(Context context, Intent intent) {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "Binding to service");
        }
        return c(context, "com.google.firebase.MESSAGING_EVENT").a(intent).i(s0.a(), q0.a);
    }

    @Override // com.google.firebase.iid.c0
    public final com.google.android.gms.tasks.g<Integer> a(Intent intent) {
        String stringExtra = intent.getStringExtra("gcm.rawData64");
        if (stringExtra != null) {
            intent.putExtra("rawData", Base64.decode(stringExtra, 0));
            intent.removeExtra("gcm.rawData64");
        }
        Context context = this.f9137c;
        boolean z = com.google.android.gms.common.util.l.j() && context.getApplicationInfo().targetSdkVersion >= 26;
        boolean z2 = (intent.getFlags() & 268435456) != 0;
        if (z && !z2) {
            return f(context, intent);
        }
        return com.google.android.gms.tasks.j.c(this.f9138d, new Callable(context, intent) { // from class: com.google.firebase.iid.o0
            private final Context a;

            /* renamed from: b  reason: collision with root package name */
            private final Intent f9175b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = context;
                this.f9175b = intent;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return c.d(this.a, this.f9175b);
            }
        }).k(this.f9138d, new com.google.android.gms.tasks.a(context, intent) { // from class: com.google.firebase.iid.n0
            private final Context a;

            /* renamed from: b  reason: collision with root package name */
            private final Intent f9173b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = context;
                this.f9173b = intent;
            }

            @Override // com.google.android.gms.tasks.a
            public final Object a(com.google.android.gms.tasks.g gVar) {
                return c.b(this.a, this.f9173b, gVar);
            }
        });
    }
}
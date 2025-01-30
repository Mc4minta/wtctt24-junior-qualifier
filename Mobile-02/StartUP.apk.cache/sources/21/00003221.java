package com.google.android.gms.common;

import android.content.Context;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import com.google.android.gms.common.internal.s0;
import com.google.android.gms.common.internal.t0;
import com.google.android.gms.dynamite.DynamiteModule;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
public final class q {
    private static volatile t0 a;

    /* renamed from: b */
    private static final Object f6290b = new Object();

    /* renamed from: c */
    private static Context f6291c;

    public static z a(String str, r rVar, boolean z, boolean z2) {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return d(str, rVar, z, z2);
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    public static final /* synthetic */ String b(boolean z, String str, r rVar) throws Exception {
        boolean z2 = true;
        if (z || !d(str, rVar, true, false).f6346b) {
            z2 = false;
        }
        return z.e(str, rVar, z, z2);
    }

    public static synchronized void c(Context context) {
        synchronized (q.class) {
            if (f6291c != null) {
                Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
            } else if (context != null) {
                f6291c = context.getApplicationContext();
            }
        }
    }

    private static z d(String str, r rVar, boolean z, boolean z2) {
        try {
            if (a == null) {
                com.google.android.gms.common.internal.t.k(f6291c);
                synchronized (f6290b) {
                    if (a == null) {
                        a = s0.p(DynamiteModule.e(f6291c, DynamiteModule.f6358k, "com.google.android.gms.googlecertificates").d("com.google.android.gms.common.GoogleCertificatesImpl"));
                    }
                }
            }
            com.google.android.gms.common.internal.t.k(f6291c);
            try {
                if (a.I0(new x(str, rVar, z, z2), com.google.android.gms.dynamic.b.Y0(f6291c.getPackageManager()))) {
                    return z.f();
                }
                return z.c(new Callable(z, str, rVar) { // from class: com.google.android.gms.common.s
                    private final boolean a;

                    /* renamed from: b  reason: collision with root package name */
                    private final String f6292b;

                    /* renamed from: c  reason: collision with root package name */
                    private final r f6293c;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.a = z;
                        this.f6292b = str;
                        this.f6293c = rVar;
                    }

                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return q.b(this.a, this.f6292b, this.f6293c);
                    }
                });
            } catch (RemoteException e2) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
                return z.b("module call", e2);
            }
        } catch (DynamiteModule.LoadingException e3) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e3);
            String valueOf = String.valueOf(e3.getMessage());
            return z.b(valueOf.length() != 0 ? "module init: ".concat(valueOf) : new String("module init: "), e3);
        }
    }
}
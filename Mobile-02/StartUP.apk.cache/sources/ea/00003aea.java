package com.google.firebase.iid;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.appsflyer.AppsFlyerProperties;
import com.google.firebase.f.c;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import okhttp3.internal.cache.DiskLruCache;

/* compiled from: com.google.firebase:firebase-iid@@20.1.6 */
/* loaded from: classes2.dex */
public final class e1 {
    private final com.google.firebase.c a;

    /* renamed from: b  reason: collision with root package name */
    private final q f9152b;

    /* renamed from: c  reason: collision with root package name */
    private final w f9153c;

    /* renamed from: d  reason: collision with root package name */
    private final Executor f9154d;

    /* renamed from: e  reason: collision with root package name */
    private final com.google.firebase.i.h f9155e;

    /* renamed from: f  reason: collision with root package name */
    private final com.google.firebase.f.c f9156f;

    /* renamed from: g  reason: collision with root package name */
    private final com.google.firebase.installations.i f9157g;

    public e1(com.google.firebase.c cVar, q qVar, Executor executor, com.google.firebase.i.h hVar, com.google.firebase.f.c cVar2, com.google.firebase.installations.i iVar) {
        this(cVar, qVar, executor, new w(cVar.g(), qVar), hVar, cVar2, iVar);
    }

    private static <T> com.google.android.gms.tasks.g<Void> a(com.google.android.gms.tasks.g<T> gVar) {
        return gVar.i(s0.a(), g1.a);
    }

    private final com.google.android.gms.tasks.g<Bundle> c(String str, String str2, String str3, Bundle bundle) {
        com.google.android.gms.tasks.h hVar = new com.google.android.gms.tasks.h();
        this.f9154d.execute(new Runnable(this, str, str2, str3, bundle, hVar) { // from class: com.google.firebase.iid.d1
            private final e1 a;

            /* renamed from: b  reason: collision with root package name */
            private final String f9141b;

            /* renamed from: c  reason: collision with root package name */
            private final String f9142c;

            /* renamed from: d  reason: collision with root package name */
            private final String f9143d;

            /* renamed from: e  reason: collision with root package name */
            private final Bundle f9144e;

            /* renamed from: f  reason: collision with root package name */
            private final com.google.android.gms.tasks.h f9145f;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
                this.f9141b = str;
                this.f9142c = str2;
                this.f9143d = str3;
                this.f9144e = bundle;
                this.f9145f = hVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.e(this.f9141b, this.f9142c, this.f9143d, this.f9144e, this.f9145f);
            }
        });
        return hVar.a();
    }

    private final String d() {
        try {
            return Base64.encodeToString(MessageDigest.getInstance("SHA-1").digest(this.a.i().getBytes()), 11);
        } catch (NoSuchAlgorithmException unused) {
            return "[HASH-ERROR]";
        }
    }

    private final Bundle f(String str, String str2, String str3, Bundle bundle) {
        bundle.putString("scope", str3);
        bundle.putString("sender", str2);
        bundle.putString("subtype", str2);
        bundle.putString(AppsFlyerProperties.APP_ID, str);
        bundle.putString("gmp_app_id", this.a.j().c());
        bundle.putString("gmsv", Integer.toString(this.f9152b.g()));
        bundle.putString("osv", Integer.toString(Build.VERSION.SDK_INT));
        bundle.putString("app_ver", this.f9152b.e());
        bundle.putString("app_ver_name", this.f9152b.f());
        bundle.putString("firebase-app-name-hash", d());
        try {
            String b2 = ((com.google.firebase.installations.m) com.google.android.gms.tasks.j.a(this.f9157g.a(false))).b();
            if (!TextUtils.isEmpty(b2)) {
                bundle.putString("Goog-Firebase-Installations-Auth", b2);
            } else {
                Log.w("FirebaseInstanceId", "FIS auth token is empty");
            }
        } catch (InterruptedException | ExecutionException e2) {
            Log.e("FirebaseInstanceId", "Failed to get FIS auth token", e2);
        }
        String b3 = com.google.android.gms.common.internal.q.a().b("firebase-iid");
        if ("UNKNOWN".equals(b3)) {
            int i2 = com.google.android.gms.common.f.a;
            StringBuilder sb = new StringBuilder(19);
            sb.append("unknown_");
            sb.append(i2);
            b3 = sb.toString();
        }
        String valueOf = String.valueOf(b3);
        bundle.putString("cliv", valueOf.length() != 0 ? "fiid-".concat(valueOf) : new String("fiid-"));
        c.a a = this.f9156f.a("fire-iid");
        if (a != c.a.NONE) {
            bundle.putString("Firebase-Client-Log-Type", Integer.toString(a.h()));
            bundle.putString("Firebase-Client", this.f9155e.a());
        }
        return bundle;
    }

    private final com.google.android.gms.tasks.g<String> g(com.google.android.gms.tasks.g<Bundle> gVar) {
        return gVar.i(this.f9154d, new com.google.android.gms.tasks.a(this) { // from class: com.google.firebase.iid.f1
            private final e1 a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
            }

            @Override // com.google.android.gms.tasks.a
            public final Object a(com.google.android.gms.tasks.g gVar2) {
                Bundle bundle = (Bundle) gVar2.n(IOException.class);
                if (bundle != null) {
                    String string = bundle.getString("registration_id");
                    if (string != null) {
                        return string;
                    }
                    String string2 = bundle.getString("unregistered");
                    if (string2 != null) {
                        return string2;
                    }
                    String string3 = bundle.getString("error");
                    if ("RST".equals(string3)) {
                        throw new IOException("INSTANCE_ID_RESET");
                    }
                    if (string3 != null) {
                        throw new IOException(string3);
                    }
                    String valueOf = String.valueOf(bundle);
                    StringBuilder sb = new StringBuilder(valueOf.length() + 21);
                    sb.append("Unexpected response: ");
                    sb.append(valueOf);
                    Log.w("FirebaseInstanceId", sb.toString(), new Throwable());
                    throw new IOException("SERVICE_NOT_AVAILABLE");
                }
                throw new IOException("SERVICE_NOT_AVAILABLE");
            }
        });
    }

    public final com.google.android.gms.tasks.g<String> b(String str, String str2, String str3) {
        return g(c(str, str2, str3, new Bundle()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void e(String str, String str2, String str3, Bundle bundle, com.google.android.gms.tasks.h hVar) {
        try {
            f(str, str2, str3, bundle);
            hVar.c(this.f9153c.a(bundle));
        } catch (IOException e2) {
            hVar.b(e2);
        }
    }

    public final com.google.android.gms.tasks.g<Void> h(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        String valueOf = String.valueOf(str3);
        bundle.putString("gcm.topic", valueOf.length() != 0 ? "/topics/".concat(valueOf) : new String("/topics/"));
        String valueOf2 = String.valueOf(str3);
        return a(g(c(str, str2, valueOf2.length() != 0 ? "/topics/".concat(valueOf2) : new String("/topics/"), bundle)));
    }

    public final com.google.android.gms.tasks.g<Void> i(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        String valueOf = String.valueOf(str3);
        bundle.putString("gcm.topic", valueOf.length() != 0 ? "/topics/".concat(valueOf) : new String("/topics/"));
        bundle.putString("delete", DiskLruCache.VERSION_1);
        String valueOf2 = String.valueOf(str3);
        return a(g(c(str, str2, valueOf2.length() != 0 ? "/topics/".concat(valueOf2) : new String("/topics/"), bundle)));
    }

    private e1(com.google.firebase.c cVar, q qVar, Executor executor, w wVar, com.google.firebase.i.h hVar, com.google.firebase.f.c cVar2, com.google.firebase.installations.i iVar) {
        this.a = cVar;
        this.f9152b = qVar;
        this.f9153c = wVar;
        this.f9154d = executor;
        this.f9155e = hVar;
        this.f9156f = cVar2;
        this.f9157g = iVar;
    }
}
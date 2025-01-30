package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.Keep;
import com.google.firebase.e.b;
import com.google.firebase.iid.FirebaseInstanceId;
import java.io.IOException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;

/* compiled from: com.google.firebase:firebase-iid@@20.1.6 */
/* loaded from: classes2.dex */
public class FirebaseInstanceId {

    /* renamed from: b */
    private static b0 f9111b;

    /* renamed from: d */
    private static ScheduledExecutorService f9113d;

    /* renamed from: e */
    private final Executor f9114e;

    /* renamed from: f */
    private final com.google.firebase.c f9115f;

    /* renamed from: g */
    private final q f9116g;

    /* renamed from: h */
    private final e1 f9117h;

    /* renamed from: i */
    private final v f9118i;

    /* renamed from: j */
    private final com.google.firebase.installations.i f9119j;

    /* renamed from: k */
    private boolean f9120k;

    /* renamed from: l */
    private final a f9121l;
    private static final long a = TimeUnit.HOURS.toSeconds(8);

    /* renamed from: c */
    private static final Pattern f9112c = Pattern.compile("\\AA[\\w-]{38}\\z");

    /* compiled from: com.google.firebase:firebase-iid@@20.1.6 */
    /* loaded from: classes2.dex */
    public class a {
        private boolean a;

        /* renamed from: b */
        private final com.google.firebase.e.d f9122b;

        /* renamed from: c */
        private boolean f9123c;

        /* renamed from: d */
        private b<com.google.firebase.a> f9124d;

        /* renamed from: e */
        private Boolean f9125e;

        a(com.google.firebase.e.d dVar) {
            FirebaseInstanceId.this = r1;
            this.f9122b = dVar;
        }

        private final synchronized void b() {
            if (this.f9123c) {
                return;
            }
            this.a = d();
            Boolean c2 = c();
            this.f9125e = c2;
            if (c2 == null && this.a) {
                b<com.google.firebase.a> bVar = new b(this) { // from class: com.google.firebase.iid.b1
                    private final FirebaseInstanceId.a a;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.a = this;
                    }

                    @Override // com.google.firebase.e.b
                    public final void a(com.google.firebase.e.a aVar) {
                        FirebaseInstanceId.a aVar2 = this.a;
                        synchronized (aVar2) {
                            if (aVar2.a()) {
                                FirebaseInstanceId.w(FirebaseInstanceId.this);
                            }
                        }
                    }
                };
                this.f9124d = bVar;
                this.f9122b.a(com.google.firebase.a.class, bVar);
            }
            this.f9123c = true;
        }

        private final Boolean c() {
            ApplicationInfo applicationInfo;
            Bundle bundle;
            Context g2 = FirebaseInstanceId.this.f9115f.g();
            SharedPreferences sharedPreferences = g2.getSharedPreferences("com.google.firebase.messaging", 0);
            if (sharedPreferences.contains("auto_init")) {
                return Boolean.valueOf(sharedPreferences.getBoolean("auto_init", false));
            }
            try {
                PackageManager packageManager = g2.getPackageManager();
                if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(g2.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_messaging_auto_init_enabled")) {
                    return null;
                }
                return Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_messaging_auto_init_enabled"));
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }

        private final boolean d() {
            try {
                Class.forName("com.google.firebase.messaging.FirebaseMessaging");
                return true;
            } catch (ClassNotFoundException unused) {
                Context g2 = FirebaseInstanceId.this.f9115f.g();
                Intent intent = new Intent("com.google.firebase.MESSAGING_EVENT");
                intent.setPackage(g2.getPackageName());
                ResolveInfo resolveService = g2.getPackageManager().resolveService(intent, 0);
                return (resolveService == null || resolveService.serviceInfo == null) ? false : true;
            }
        }

        public final synchronized boolean a() {
            b();
            Boolean bool = this.f9125e;
            if (bool != null) {
                return bool.booleanValue();
            }
            return this.a && FirebaseInstanceId.this.f9115f.p();
        }
    }

    public FirebaseInstanceId(com.google.firebase.c cVar, com.google.firebase.e.d dVar, com.google.firebase.i.h hVar, com.google.firebase.f.c cVar2, com.google.firebase.installations.i iVar) {
        this(cVar, new q(cVar.g()), s0.b(), s0.b(), dVar, hVar, cVar2, iVar);
    }

    public final void E() {
        if (t(u())) {
            F();
        }
    }

    private final synchronized void F() {
        if (!this.f9120k) {
            o(0L);
        }
    }

    private final String G() {
        try {
            f9111b.e(this.f9115f.k());
            com.google.android.gms.tasks.g<String> id = this.f9119j.getId();
            com.google.android.gms.common.internal.t.l(id, "Task must not be null");
            CountDownLatch countDownLatch = new CountDownLatch(1);
            id.c(y0.a, new com.google.android.gms.tasks.c(countDownLatch) { // from class: com.google.firebase.iid.x0
                private final CountDownLatch a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.a = countDownLatch;
                }

                @Override // com.google.android.gms.tasks.c
                public final void a(com.google.android.gms.tasks.g gVar) {
                    this.a.countDown();
                }
            });
            countDownLatch.await(30000L, TimeUnit.MILLISECONDS);
            if (id.q()) {
                return id.m();
            }
            if (id.o()) {
                throw new CancellationException("Task is already canceled");
            }
            throw new IllegalStateException(id.l());
        } catch (InterruptedException e2) {
            throw new IllegalStateException(e2);
        }
    }

    private final String H() {
        return "[DEFAULT]".equals(this.f9115f.i()) ? "" : this.f9115f.k();
    }

    public static FirebaseInstanceId c() {
        return getInstance(com.google.firebase.c.h());
    }

    private final com.google.android.gms.tasks.g<com.google.firebase.iid.a> g(String str, String str2) {
        return com.google.android.gms.tasks.j.e(null).k(this.f9114e, new com.google.android.gms.tasks.a(this, str, n(str2)) { // from class: com.google.firebase.iid.v0
            private final FirebaseInstanceId a;

            /* renamed from: b  reason: collision with root package name */
            private final String f9186b;

            /* renamed from: c  reason: collision with root package name */
            private final String f9187c;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
                this.f9186b = str;
                this.f9187c = r3;
            }

            @Override // com.google.android.gms.tasks.a
            public final Object a(com.google.android.gms.tasks.g gVar) {
                return this.a.h(this.f9186b, this.f9187c, gVar);
            }
        });
    }

    @Keep
    public static FirebaseInstanceId getInstance(com.google.firebase.c cVar) {
        return (FirebaseInstanceId) cVar.f(FirebaseInstanceId.class);
    }

    private final <T> T m(com.google.android.gms.tasks.g<T> gVar) throws IOException {
        try {
            return (T) com.google.android.gms.tasks.j.b(gVar, 30000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | TimeoutException unused) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        } catch (ExecutionException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof IOException) {
                if ("INSTANCE_ID_RESET".equals(cause.getMessage())) {
                    z();
                }
                throw ((IOException) cause);
            } else if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else {
                throw new IOException(e2);
            }
        }
    }

    private static String n(String str) {
        return (str.isEmpty() || str.equalsIgnoreCase("fcm") || str.equalsIgnoreCase("gcm")) ? "*" : str;
    }

    private static void p(com.google.firebase.c cVar) {
        com.google.android.gms.common.internal.t.h(cVar.j().e(), "Please set your project ID. A valid Firebase project ID is required to communicate with Firebase server APIs: It identifies your project with Google.");
        com.google.android.gms.common.internal.t.h(cVar.j().c(), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.");
        com.google.android.gms.common.internal.t.h(cVar.j().b(), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.");
        com.google.android.gms.common.internal.t.b(cVar.j().c().contains(":"), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        com.google.android.gms.common.internal.t.b(f9112c.matcher(cVar.j().b()).matches(), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
    }

    public static void q(Runnable runnable, long j2) {
        synchronized (FirebaseInstanceId.class) {
            if (f9113d == null) {
                f9113d = new ScheduledThreadPoolExecutor(1, new com.google.android.gms.common.util.q.a("FirebaseInstanceId"));
            }
            f9113d.schedule(runnable, j2, TimeUnit.SECONDS);
        }
    }

    private final a0 v(String str, String str2) {
        return f9111b.a(H(), str, str2);
    }

    public static /* synthetic */ void w(FirebaseInstanceId firebaseInstanceId) {
        firebaseInstanceId.E();
    }

    public static boolean y() {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            return true;
        }
        return Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseInstanceId", 3);
    }

    public final boolean A() {
        return this.f9116g.c();
    }

    public final void B() {
        f9111b.h(H());
        F();
    }

    public final boolean C() {
        return this.f9121l.a();
    }

    public final /* synthetic */ void D() {
        if (this.f9121l.a()) {
            E();
        }
    }

    public void a() throws IOException {
        p(this.f9115f);
        if (Looper.getMainLooper() != Looper.myLooper()) {
            m(this.f9119j.b());
            z();
            return;
        }
        throw new IOException("MAIN_THREAD");
    }

    public String b() {
        p(this.f9115f);
        E();
        return G();
    }

    public com.google.android.gms.tasks.g<com.google.firebase.iid.a> d() {
        return g(q.b(this.f9115f), "*");
    }

    @Deprecated
    public String e() {
        p(this.f9115f);
        a0 u = u();
        if (t(u)) {
            F();
        }
        return a0.b(u);
    }

    public String f(String str, String str2) throws IOException {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            return ((com.google.firebase.iid.a) m(g(str, str2))).a();
        }
        throw new IOException("MAIN_THREAD");
    }

    public final /* synthetic */ com.google.android.gms.tasks.g h(String str, String str2, com.google.android.gms.tasks.g gVar) throws Exception {
        String G = G();
        a0 v = v(str, str2);
        if (!t(v)) {
            return com.google.android.gms.tasks.j.e(new d(G, v.f9128b));
        }
        return this.f9118i.b(str, str2, new x(this, G, str, str2) { // from class: com.google.firebase.iid.a1
            private final FirebaseInstanceId a;

            /* renamed from: b  reason: collision with root package name */
            private final String f9131b;

            /* renamed from: c  reason: collision with root package name */
            private final String f9132c;

            /* renamed from: d  reason: collision with root package name */
            private final String f9133d;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
                this.f9131b = G;
                this.f9132c = str;
                this.f9133d = str2;
            }

            @Override // com.google.firebase.iid.x
            public final com.google.android.gms.tasks.g a() {
                return this.a.i(this.f9131b, this.f9132c, this.f9133d);
            }
        });
    }

    public final /* synthetic */ com.google.android.gms.tasks.g i(String str, String str2, String str3) {
        return this.f9117h.b(str, str2, str3).s(this.f9114e, new com.google.android.gms.tasks.f(this, str2, str3, str) { // from class: com.google.firebase.iid.z0
            private final FirebaseInstanceId a;

            /* renamed from: b  reason: collision with root package name */
            private final String f9199b;

            /* renamed from: c  reason: collision with root package name */
            private final String f9200c;

            /* renamed from: d  reason: collision with root package name */
            private final String f9201d;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
                this.f9199b = str2;
                this.f9200c = str3;
                this.f9201d = str;
            }

            @Override // com.google.android.gms.tasks.f
            public final com.google.android.gms.tasks.g a(Object obj) {
                return this.a.j(this.f9199b, this.f9200c, this.f9201d, (String) obj);
            }
        });
    }

    public final /* synthetic */ com.google.android.gms.tasks.g j(String str, String str2, String str3, String str4) throws Exception {
        f9111b.d(H(), str, str2, str4, this.f9116g.e());
        return com.google.android.gms.tasks.j.e(new d(str3, str4));
    }

    public final com.google.firebase.c k() {
        return this.f9115f;
    }

    public final synchronized void o(long j2) {
        q(new e0(this, Math.min(Math.max(30L, j2 << 1), a)), j2);
        this.f9120k = true;
    }

    public final synchronized void s(boolean z) {
        this.f9120k = z;
    }

    public final boolean t(a0 a0Var) {
        return a0Var == null || a0Var.d(this.f9116g.e());
    }

    public final a0 u() {
        return v(q.b(this.f9115f), "*");
    }

    public final String x() throws IOException {
        return f(q.b(this.f9115f), "*");
    }

    public final synchronized void z() {
        f9111b.c();
        if (this.f9121l.a()) {
            F();
        }
    }

    private FirebaseInstanceId(com.google.firebase.c cVar, q qVar, Executor executor, Executor executor2, com.google.firebase.e.d dVar, com.google.firebase.i.h hVar, com.google.firebase.f.c cVar2, com.google.firebase.installations.i iVar) {
        this.f9120k = false;
        if (q.b(cVar) != null) {
            synchronized (FirebaseInstanceId.class) {
                if (f9111b == null) {
                    f9111b = new b0(cVar.g());
                }
            }
            this.f9115f = cVar;
            this.f9116g = qVar;
            this.f9117h = new e1(cVar, qVar, executor, hVar, cVar2, iVar);
            this.f9114e = executor2;
            this.f9121l = new a(dVar);
            this.f9118i = new v(executor);
            this.f9119j = iVar;
            executor2.execute(new Runnable(this) { // from class: com.google.firebase.iid.w0
                private final FirebaseInstanceId a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.a = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.a.D();
                }
            });
            return;
        }
        throw new IllegalStateException("FirebaseInstanceId failed to initialize, FirebaseApp is missing project ID");
    }
}
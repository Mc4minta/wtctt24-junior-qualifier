package com.google.firebase.crashlytics.c.g;

import android.content.Context;
import android.util.Log;
import com.google.firebase.crashlytics.c.f.a;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
public class k {
    private final Context a;

    /* renamed from: b  reason: collision with root package name */
    private final com.google.firebase.c f8758b;

    /* renamed from: c  reason: collision with root package name */
    private final q f8759c;

    /* renamed from: d  reason: collision with root package name */
    private final long f8760d;

    /* renamed from: e  reason: collision with root package name */
    private l f8761e;

    /* renamed from: f  reason: collision with root package name */
    private l f8762f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f8763g;

    /* renamed from: h  reason: collision with root package name */
    private j f8764h;

    /* renamed from: i  reason: collision with root package name */
    private final v f8765i;

    /* renamed from: j  reason: collision with root package name */
    private final com.google.firebase.analytics.a.a f8766j;

    /* renamed from: k  reason: collision with root package name */
    private ExecutorService f8767k;

    /* renamed from: l  reason: collision with root package name */
    private i f8768l;
    private com.google.firebase.crashlytics.c.a m;

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    class a implements a.InterfaceC0164a {
        a() {
        }

        @Override // com.google.firebase.crashlytics.c.f.a.InterfaceC0164a
        public void a(String str) {
            k.this.k(str);
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    class b implements Callable<com.google.android.gms.tasks.g<Void>> {
        final /* synthetic */ com.google.firebase.crashlytics.c.p.e a;

        b(com.google.firebase.crashlytics.c.p.e eVar) {
            this.a = eVar;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public com.google.android.gms.tasks.g<Void> call() throws Exception {
            return k.this.f(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    public class c implements Runnable {
        final /* synthetic */ com.google.firebase.crashlytics.c.p.e a;

        c(com.google.firebase.crashlytics.c.p.e eVar) {
            this.a = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            k.this.f(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    public class d implements Callable<Boolean> {
        d() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() throws Exception {
            try {
                boolean d2 = k.this.f8761e.d();
                com.google.firebase.crashlytics.c.b f2 = com.google.firebase.crashlytics.c.b.f();
                f2.b("Initialization marker file removed: " + d2);
                return Boolean.valueOf(d2);
            } catch (Exception e2) {
                com.google.firebase.crashlytics.c.b.f().e("Problem encountered deleting Crashlytics initialization marker.", e2);
                return Boolean.FALSE;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    public class e implements Callable<Boolean> {
        e() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() throws Exception {
            return Boolean.valueOf(k.this.f8764h.H());
        }
    }

    public k(com.google.firebase.c cVar, v vVar, com.google.firebase.crashlytics.c.a aVar, q qVar, com.google.firebase.analytics.a.a aVar2) {
        this(cVar, vVar, aVar, qVar, aVar2, t.c("Crashlytics Exception Handler"));
    }

    private void d() {
        try {
            this.f8763g = Boolean.TRUE.equals((Boolean) h0.a(this.f8768l.h(new e())));
        } catch (Exception unused) {
            this.f8763g = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.google.android.gms.tasks.g<Void> f(com.google.firebase.crashlytics.c.p.e eVar) {
        n();
        this.f8764h.B();
        try {
            this.f8764h.r0();
            com.google.firebase.crashlytics.c.p.i.e b2 = eVar.b();
            if (!b2.a().a) {
                com.google.firebase.crashlytics.c.b.f().b("Collection of crash reports disabled in Crashlytics settings.");
                return com.google.android.gms.tasks.j.d(new RuntimeException("Collection of crash reports disabled in Crashlytics settings."));
            }
            if (!this.f8764h.Q(b2.b().a)) {
                com.google.firebase.crashlytics.c.b.f().b("Could not finalize previous sessions.");
            }
            return this.f8764h.w0(1.0f, eVar.a());
        } catch (Exception e2) {
            com.google.firebase.crashlytics.c.b.f().e("Crashlytics encountered a problem during asynchronous initialization.", e2);
            return com.google.android.gms.tasks.j.d(e2);
        } finally {
            m();
        }
    }

    private void h(com.google.firebase.crashlytics.c.p.e eVar) {
        Future<?> submit = this.f8767k.submit(new c(eVar));
        com.google.firebase.crashlytics.c.b.f().b("Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.");
        try {
            submit.get(4L, TimeUnit.SECONDS);
        } catch (InterruptedException e2) {
            com.google.firebase.crashlytics.c.b.f().e("Crashlytics was interrupted during initialization.", e2);
        } catch (ExecutionException e3) {
            com.google.firebase.crashlytics.c.b.f().e("Problem encountered during Crashlytics initialization.", e3);
        } catch (TimeoutException e4) {
            com.google.firebase.crashlytics.c.b.f().e("Crashlytics timed out during initialization.", e4);
        }
    }

    public static String i() {
        return "17.0.0";
    }

    static boolean j(String str, boolean z) {
        if (!z) {
            com.google.firebase.crashlytics.c.b.f().b("Configured not to require a build ID.");
            return true;
        } else if (h.D(str)) {
            Log.e("FirebaseCrashlytics", ".");
            Log.e("FirebaseCrashlytics", ".     |  | ");
            Log.e("FirebaseCrashlytics", ".     |  |");
            Log.e("FirebaseCrashlytics", ".     |  |");
            Log.e("FirebaseCrashlytics", ".   \\ |  | /");
            Log.e("FirebaseCrashlytics", ".    \\    /");
            Log.e("FirebaseCrashlytics", ".     \\  /");
            Log.e("FirebaseCrashlytics", ".      \\/");
            Log.e("FirebaseCrashlytics", ".");
            Log.e("FirebaseCrashlytics", "The Crashlytics build ID is missing. This occurs when Crashlytics tooling is absent from your app's build configuration. Please review Crashlytics onboarding instructions and ensure you have a valid Crashlytics account.");
            Log.e("FirebaseCrashlytics", ".");
            Log.e("FirebaseCrashlytics", ".      /\\");
            Log.e("FirebaseCrashlytics", ".     /  \\");
            Log.e("FirebaseCrashlytics", ".    /    \\");
            Log.e("FirebaseCrashlytics", ".   / |  | \\");
            Log.e("FirebaseCrashlytics", ".     |  |");
            Log.e("FirebaseCrashlytics", ".     |  |");
            Log.e("FirebaseCrashlytics", ".     |  |");
            Log.e("FirebaseCrashlytics", ".");
            return false;
        } else {
            return true;
        }
    }

    boolean e() {
        return this.f8761e.c();
    }

    public com.google.android.gms.tasks.g<Void> g(com.google.firebase.crashlytics.c.p.e eVar) {
        return h0.b(this.f8767k, new b(eVar));
    }

    public void k(String str) {
        this.f8764h.P0(System.currentTimeMillis() - this.f8760d, str);
    }

    public void l(Throwable th) {
        this.f8764h.G0(Thread.currentThread(), th);
    }

    void m() {
        this.f8768l.h(new d());
    }

    void n() {
        this.f8768l.b();
        this.f8761e.a();
        com.google.firebase.crashlytics.c.b.f().b("Initialization marker file created.");
    }

    public boolean o(com.google.firebase.crashlytics.c.p.e eVar) {
        String p = h.p(this.a);
        com.google.firebase.crashlytics.c.b f2 = com.google.firebase.crashlytics.c.b.f();
        f2.b("Mapping file ID is: " + p);
        if (j(p, h.l(this.a, "com.crashlytics.RequireBuildId", true))) {
            String c2 = this.f8758b.j().c();
            try {
                com.google.firebase.crashlytics.c.b f3 = com.google.firebase.crashlytics.c.b.f();
                f3.g("Initializing Crashlytics " + i());
                com.google.firebase.crashlytics.c.l.i iVar = new com.google.firebase.crashlytics.c.l.i(this.a);
                this.f8762f = new l("crash_marker", iVar);
                this.f8761e = new l("initialization_marker", iVar);
                com.google.firebase.crashlytics.c.k.c cVar = new com.google.firebase.crashlytics.c.k.c();
                com.google.firebase.crashlytics.c.g.b a2 = com.google.firebase.crashlytics.c.g.b.a(this.a, this.f8765i, c2, p);
                com.google.firebase.crashlytics.c.r.a aVar = new com.google.firebase.crashlytics.c.r.a(this.a);
                com.google.firebase.crashlytics.c.f.a aVar2 = new com.google.firebase.crashlytics.c.f.a(this.f8766j, new a());
                com.google.firebase.crashlytics.c.b f4 = com.google.firebase.crashlytics.c.b.f();
                f4.b("Installer package name is: " + a2.f8668c);
                this.f8764h = new j(this.a, this.f8768l, cVar, this.f8765i, this.f8759c, iVar, this.f8762f, a2, null, null, this.m, aVar, aVar2, this.f8766j, eVar);
                boolean e2 = e();
                d();
                this.f8764h.N(Thread.getDefaultUncaughtExceptionHandler(), eVar);
                if (e2 && h.c(this.a)) {
                    com.google.firebase.crashlytics.c.b.f().b("Crashlytics did not finish previous background initialization. Initializing synchronously.");
                    h(eVar);
                    return false;
                }
                com.google.firebase.crashlytics.c.b.f().b("Exception handling initialization successful");
                return true;
            } catch (Exception e3) {
                com.google.firebase.crashlytics.c.b.f().e("Crashlytics was not started due to an exception during initialization", e3);
                this.f8764h = null;
                return false;
            }
        }
        throw new IllegalStateException("The Crashlytics build ID is missing. This occurs when Crashlytics tooling is absent from your app's build configuration. Please review Crashlytics onboarding instructions and ensure you have a valid Crashlytics account.");
    }

    public void p(String str, String str2) {
        this.f8764h.u0(str, str2);
    }

    public void q(String str) {
        this.f8764h.v0(str);
    }

    k(com.google.firebase.c cVar, v vVar, com.google.firebase.crashlytics.c.a aVar, q qVar, com.google.firebase.analytics.a.a aVar2, ExecutorService executorService) {
        this.f8758b = cVar;
        this.f8759c = qVar;
        this.a = cVar.g();
        this.f8765i = vVar;
        this.m = aVar;
        this.f8766j = aVar2;
        this.f8767k = executorService;
        this.f8768l = new i(executorService);
        this.f8760d = System.currentTimeMillis();
    }
}
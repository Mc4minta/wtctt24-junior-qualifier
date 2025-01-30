package com.google.firebase.crashlytics.c;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.coinbase.wallet.core.extensions.Strings;
import com.google.android.gms.tasks.f;
import com.google.android.gms.tasks.g;
import com.google.firebase.crashlytics.c.g.h;
import com.google.firebase.crashlytics.c.g.k;
import com.google.firebase.crashlytics.c.g.q;
import com.google.firebase.crashlytics.c.g.s;
import com.google.firebase.crashlytics.c.g.v;
import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
public class e {
    private final com.google.firebase.crashlytics.c.k.c a = new com.google.firebase.crashlytics.c.k.c();

    /* renamed from: b  reason: collision with root package name */
    private final com.google.firebase.c f8645b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f8646c;

    /* renamed from: d  reason: collision with root package name */
    private PackageManager f8647d;

    /* renamed from: e  reason: collision with root package name */
    private String f8648e;

    /* renamed from: f  reason: collision with root package name */
    private PackageInfo f8649f;

    /* renamed from: g  reason: collision with root package name */
    private String f8650g;

    /* renamed from: h  reason: collision with root package name */
    private String f8651h;

    /* renamed from: i  reason: collision with root package name */
    private String f8652i;

    /* renamed from: j  reason: collision with root package name */
    private String f8653j;

    /* renamed from: k  reason: collision with root package name */
    private String f8654k;

    /* renamed from: l  reason: collision with root package name */
    private v f8655l;
    private q m;

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    class a implements f<com.google.firebase.crashlytics.c.p.i.b, Void> {
        final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.google.firebase.crashlytics.c.p.d f8656b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Executor f8657c;

        a(String str, com.google.firebase.crashlytics.c.p.d dVar, Executor executor) {
            this.a = str;
            this.f8656b = dVar;
            this.f8657c = executor;
        }

        @Override // com.google.android.gms.tasks.f
        /* renamed from: b */
        public g<Void> a(com.google.firebase.crashlytics.c.p.i.b bVar) throws Exception {
            try {
                e.this.i(bVar, this.a, this.f8656b, this.f8657c, true);
                return null;
            } catch (Exception e2) {
                com.google.firebase.crashlytics.c.b.f().e("Error performing auto configuration.", e2);
                throw e2;
            }
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    class b implements f<Void, com.google.firebase.crashlytics.c.p.i.b> {
        final /* synthetic */ com.google.firebase.crashlytics.c.p.d a;

        b(com.google.firebase.crashlytics.c.p.d dVar) {
            this.a = dVar;
        }

        @Override // com.google.android.gms.tasks.f
        /* renamed from: b */
        public g<com.google.firebase.crashlytics.c.p.i.b> a(Void r1) throws Exception {
            return this.a.a();
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    class c implements com.google.android.gms.tasks.a<Void, Object> {
        c() {
        }

        @Override // com.google.android.gms.tasks.a
        public Object a(g<Void> gVar) throws Exception {
            if (gVar.q()) {
                return null;
            }
            com.google.firebase.crashlytics.c.b.f().e("Error fetching settings.", gVar.l());
            return null;
        }
    }

    public e(com.google.firebase.c cVar, Context context, v vVar, q qVar) {
        this.f8645b = cVar;
        this.f8646c = context;
        this.f8655l = vVar;
        this.m = qVar;
    }

    private com.google.firebase.crashlytics.c.p.i.a b(String str, String str2) {
        return new com.google.firebase.crashlytics.c.p.i.a(str, str2, e().d(), this.f8651h, this.f8650g, h.h(h.p(d()), str2, this.f8651h, this.f8650g), this.f8653j, s.h(this.f8652i).n(), this.f8654k, Strings.zero);
    }

    private v e() {
        return this.f8655l;
    }

    private static String g() {
        return k.i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(com.google.firebase.crashlytics.c.p.i.b bVar, String str, com.google.firebase.crashlytics.c.p.d dVar, Executor executor, boolean z) {
        if ("new".equals(bVar.a)) {
            if (j(bVar, str, z)) {
                dVar.o(com.google.firebase.crashlytics.c.p.c.SKIP_CACHE_LOOKUP, executor);
            } else {
                com.google.firebase.crashlytics.c.b.f().e("Failed to create app with Crashlytics service.", null);
            }
        } else if ("configured".equals(bVar.a)) {
            dVar.o(com.google.firebase.crashlytics.c.p.c.SKIP_CACHE_LOOKUP, executor);
        } else if (bVar.f9053g) {
            com.google.firebase.crashlytics.c.b.f().b("Server says an update is required - forcing a full App update.");
            k(bVar, str, z);
        }
    }

    private boolean j(com.google.firebase.crashlytics.c.p.i.b bVar, String str, boolean z) {
        return new com.google.firebase.crashlytics.c.p.j.b(f(), bVar.f9048b, this.a, g()).i(b(bVar.f9052f, str), z);
    }

    private boolean k(com.google.firebase.crashlytics.c.p.i.b bVar, String str, boolean z) {
        return new com.google.firebase.crashlytics.c.p.j.e(f(), bVar.f9048b, this.a, g()).i(b(bVar.f9052f, str), z);
    }

    public void c(Executor executor, com.google.firebase.crashlytics.c.p.d dVar) {
        this.m.d().s(executor, new b(dVar)).s(executor, new a(this.f8645b.j().c(), dVar, executor));
    }

    public Context d() {
        return this.f8646c;
    }

    String f() {
        return h.u(this.f8646c, "com.crashlytics.ApiEndpoint");
    }

    public boolean h() {
        try {
            this.f8652i = this.f8655l.e();
            this.f8647d = this.f8646c.getPackageManager();
            String packageName = this.f8646c.getPackageName();
            this.f8648e = packageName;
            PackageInfo packageInfo = this.f8647d.getPackageInfo(packageName, 0);
            this.f8649f = packageInfo;
            this.f8650g = Integer.toString(packageInfo.versionCode);
            String str = this.f8649f.versionName;
            if (str == null) {
                str = "0.0";
            }
            this.f8651h = str;
            this.f8653j = this.f8647d.getApplicationLabel(this.f8646c.getApplicationInfo()).toString();
            this.f8654k = Integer.toString(this.f8646c.getApplicationInfo().targetSdkVersion);
            return true;
        } catch (PackageManager.NameNotFoundException e2) {
            com.google.firebase.crashlytics.c.b.f().e("Failed init", e2);
            return false;
        }
    }

    public com.google.firebase.crashlytics.c.p.d l(Context context, com.google.firebase.c cVar, Executor executor) {
        com.google.firebase.crashlytics.c.p.d l2 = com.google.firebase.crashlytics.c.p.d.l(context, cVar.j().c(), this.f8655l, this.a, this.f8650g, this.f8651h, f(), this.m);
        l2.p(executor).i(executor, new c());
        return l2;
    }
}
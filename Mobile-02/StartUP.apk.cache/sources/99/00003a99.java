package com.google.firebase.crashlytics.c.p;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.tasks.j;
import com.google.firebase.crashlytics.c.g.f0;
import com.google.firebase.crashlytics.c.g.p;
import com.google.firebase.crashlytics.c.g.q;
import com.google.firebase.crashlytics.c.g.s;
import com.google.firebase.crashlytics.c.g.v;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
public class d implements e {
    private final Context a;

    /* renamed from: b  reason: collision with root package name */
    private final com.google.firebase.crashlytics.c.p.i.g f9031b;

    /* renamed from: c  reason: collision with root package name */
    private final f f9032c;

    /* renamed from: d  reason: collision with root package name */
    private final p f9033d;

    /* renamed from: e  reason: collision with root package name */
    private final com.google.firebase.crashlytics.c.p.a f9034e;

    /* renamed from: f  reason: collision with root package name */
    private final com.google.firebase.crashlytics.c.p.j.d f9035f;

    /* renamed from: g  reason: collision with root package name */
    private final q f9036g;

    /* renamed from: h  reason: collision with root package name */
    private final AtomicReference<com.google.firebase.crashlytics.c.p.i.e> f9037h;

    /* renamed from: i  reason: collision with root package name */
    private final AtomicReference<com.google.android.gms.tasks.h<com.google.firebase.crashlytics.c.p.i.b>> f9038i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    public class a implements com.google.android.gms.tasks.f<Void, Void> {
        a() {
        }

        @Override // com.google.android.gms.tasks.f
        /* renamed from: b */
        public com.google.android.gms.tasks.g<Void> a(Void r5) throws Exception {
            JSONObject a = d.this.f9035f.a(d.this.f9031b, true);
            if (a != null) {
                com.google.firebase.crashlytics.c.p.i.f b2 = d.this.f9032c.b(a);
                d.this.f9034e.c(b2.d(), a);
                d.this.q(a, "Loaded settings: ");
                d dVar = d.this;
                dVar.r(dVar.f9031b.f9066f);
                d.this.f9037h.set(b2);
                ((com.google.android.gms.tasks.h) d.this.f9038i.get()).e(b2.c());
                com.google.android.gms.tasks.h hVar = new com.google.android.gms.tasks.h();
                hVar.e(b2.c());
                d.this.f9038i.set(hVar);
            }
            return j.e(null);
        }
    }

    d(Context context, com.google.firebase.crashlytics.c.p.i.g gVar, p pVar, f fVar, com.google.firebase.crashlytics.c.p.a aVar, com.google.firebase.crashlytics.c.p.j.d dVar, q qVar) {
        AtomicReference<com.google.firebase.crashlytics.c.p.i.e> atomicReference = new AtomicReference<>();
        this.f9037h = atomicReference;
        this.f9038i = new AtomicReference<>(new com.google.android.gms.tasks.h());
        this.a = context;
        this.f9031b = gVar;
        this.f9033d = pVar;
        this.f9032c = fVar;
        this.f9034e = aVar;
        this.f9035f = dVar;
        this.f9036g = qVar;
        atomicReference.set(b.e(pVar));
    }

    public static d l(Context context, String str, v vVar, com.google.firebase.crashlytics.c.k.c cVar, String str2, String str3, String str4, q qVar) {
        String e2 = vVar.e();
        f0 f0Var = new f0();
        return new d(context, new com.google.firebase.crashlytics.c.p.i.g(str, vVar.f(), vVar.g(), vVar.h(), vVar, com.google.firebase.crashlytics.c.g.h.h(com.google.firebase.crashlytics.c.g.h.p(context), str, str3, str2), str3, str2, s.h(e2).n()), f0Var, new f(f0Var), new com.google.firebase.crashlytics.c.p.a(context), new com.google.firebase.crashlytics.c.p.j.c(str4, String.format(Locale.US, "https://firebase-settings.crashlytics.com/spi/v2/platforms/android/gmp/%s/settings", str), cVar), qVar);
    }

    private com.google.firebase.crashlytics.c.p.i.f m(c cVar) {
        com.google.firebase.crashlytics.c.p.i.f fVar = null;
        try {
            if (!c.SKIP_CACHE_LOOKUP.equals(cVar)) {
                JSONObject b2 = this.f9034e.b();
                if (b2 != null) {
                    com.google.firebase.crashlytics.c.p.i.f b3 = this.f9032c.b(b2);
                    if (b3 != null) {
                        q(b2, "Loaded cached settings: ");
                        long a2 = this.f9033d.a();
                        if (!c.IGNORE_CACHE_EXPIRATION.equals(cVar) && b3.e(a2)) {
                            com.google.firebase.crashlytics.c.b.f().b("Cached settings have expired.");
                        }
                        try {
                            com.google.firebase.crashlytics.c.b.f().b("Returning cached settings.");
                            fVar = b3;
                        } catch (Exception e2) {
                            e = e2;
                            fVar = b3;
                            com.google.firebase.crashlytics.c.b.f().e("Failed to get cached settings", e);
                            return fVar;
                        }
                    } else {
                        com.google.firebase.crashlytics.c.b.f().e("Failed to parse cached settings data.", null);
                    }
                } else {
                    com.google.firebase.crashlytics.c.b.f().b("No cached settings data found.");
                }
            }
        } catch (Exception e3) {
            e = e3;
        }
        return fVar;
    }

    private String n() {
        return com.google.firebase.crashlytics.c.g.h.t(this.a).getString("existing_instance_identifier", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(JSONObject jSONObject, String str) throws JSONException {
        com.google.firebase.crashlytics.c.b f2 = com.google.firebase.crashlytics.c.b.f();
        f2.b(str + jSONObject.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"CommitPrefEdits"})
    public boolean r(String str) {
        SharedPreferences.Editor edit = com.google.firebase.crashlytics.c.g.h.t(this.a).edit();
        edit.putString("existing_instance_identifier", str);
        edit.apply();
        return true;
    }

    @Override // com.google.firebase.crashlytics.c.p.e
    public com.google.android.gms.tasks.g<com.google.firebase.crashlytics.c.p.i.b> a() {
        return this.f9038i.get().a();
    }

    @Override // com.google.firebase.crashlytics.c.p.e
    public com.google.firebase.crashlytics.c.p.i.e b() {
        return this.f9037h.get();
    }

    boolean k() {
        return !n().equals(this.f9031b.f9066f);
    }

    public com.google.android.gms.tasks.g<Void> o(c cVar, Executor executor) {
        com.google.firebase.crashlytics.c.p.i.f m;
        if (!k() && (m = m(cVar)) != null) {
            this.f9037h.set(m);
            this.f9038i.get().e(m.c());
            return j.e(null);
        }
        com.google.firebase.crashlytics.c.p.i.f m2 = m(c.IGNORE_CACHE_EXPIRATION);
        if (m2 != null) {
            this.f9037h.set(m2);
            this.f9038i.get().e(m2.c());
        }
        return this.f9036g.d().s(executor, new a());
    }

    public com.google.android.gms.tasks.g<Void> p(Executor executor) {
        return o(c.USE_CACHE, executor);
    }
}
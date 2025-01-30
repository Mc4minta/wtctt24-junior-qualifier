package com.google.firebase.crashlytics.c.i;

import com.coinbase.ApiConstants;
import com.facebook.react.modules.appstate.AppStateModule;
import com.google.firebase.crashlytics.c.i.v;
import java.io.IOException;
import org.apache.http.cookie.ClientCookie;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
public final class a implements com.google.firebase.encoders.f.a {
    public static final com.google.firebase.encoders.f.a a = new a();

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.google.firebase.crashlytics.c.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static final class C0170a implements com.google.firebase.encoders.b<v.b> {
        static final C0170a a = new C0170a();

        private C0170a() {
        }

        @Override // com.google.firebase.encoders.b
        /* renamed from: b */
        public void a(v.b bVar, com.google.firebase.encoders.c cVar) throws IOException {
            cVar.e("key", bVar.b());
            cVar.e("value", bVar.c());
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    private static final class b implements com.google.firebase.encoders.b<v> {
        static final b a = new b();

        private b() {
        }

        @Override // com.google.firebase.encoders.b
        /* renamed from: b */
        public void a(v vVar, com.google.firebase.encoders.c cVar) throws IOException {
            cVar.e("sdkVersion", vVar.i());
            cVar.e("gmpAppId", vVar.e());
            cVar.c("platform", vVar.h());
            cVar.e("installationUuid", vVar.f());
            cVar.e("buildVersion", vVar.c());
            cVar.e("displayVersion", vVar.d());
            cVar.e("session", vVar.j());
            cVar.e("ndkPayload", vVar.g());
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    private static final class c implements com.google.firebase.encoders.b<v.c> {
        static final c a = new c();

        private c() {
        }

        @Override // com.google.firebase.encoders.b
        /* renamed from: b */
        public void a(v.c cVar, com.google.firebase.encoders.c cVar2) throws IOException {
            cVar2.e("files", cVar.b());
            cVar2.e("orgId", cVar.c());
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    private static final class d implements com.google.firebase.encoders.b<v.c.b> {
        static final d a = new d();

        private d() {
        }

        @Override // com.google.firebase.encoders.b
        /* renamed from: b */
        public void a(v.c.b bVar, com.google.firebase.encoders.c cVar) throws IOException {
            cVar.e("filename", bVar.c());
            cVar.e("contents", bVar.b());
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    private static final class e implements com.google.firebase.encoders.b<v.d.a> {
        static final e a = new e();

        private e() {
        }

        @Override // com.google.firebase.encoders.b
        /* renamed from: b */
        public void a(v.d.a aVar, com.google.firebase.encoders.c cVar) throws IOException {
            cVar.e("identifier", aVar.c());
            cVar.e(ClientCookie.VERSION_ATTR, aVar.f());
            cVar.e("displayVersion", aVar.b());
            cVar.e("organization", aVar.e());
            cVar.e("installationUuid", aVar.d());
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    private static final class f implements com.google.firebase.encoders.b<v.d.a.b> {
        static final f a = new f();

        private f() {
        }

        @Override // com.google.firebase.encoders.b
        /* renamed from: b */
        public void a(v.d.a.b bVar, com.google.firebase.encoders.c cVar) throws IOException {
            cVar.e("clsId", bVar.a());
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    private static final class g implements com.google.firebase.encoders.b<v.d.c> {
        static final g a = new g();

        private g() {
        }

        @Override // com.google.firebase.encoders.b
        /* renamed from: b */
        public void a(v.d.c cVar, com.google.firebase.encoders.c cVar2) throws IOException {
            cVar2.c("arch", cVar.b());
            cVar2.e("model", cVar.f());
            cVar2.c("cores", cVar.c());
            cVar2.b("ram", cVar.h());
            cVar2.b("diskSpace", cVar.d());
            cVar2.a("simulator", cVar.j());
            cVar2.c(ApiConstants.STATE, cVar.i());
            cVar2.e("manufacturer", cVar.e());
            cVar2.e("modelClass", cVar.g());
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    private static final class h implements com.google.firebase.encoders.b<v.d> {
        static final h a = new h();

        private h() {
        }

        @Override // com.google.firebase.encoders.b
        /* renamed from: b */
        public void a(v.d dVar, com.google.firebase.encoders.c cVar) throws IOException {
            cVar.e("generator", dVar.f());
            cVar.e("identifier", dVar.i());
            cVar.b("startedAt", dVar.k());
            cVar.e("endedAt", dVar.d());
            cVar.a("crashed", dVar.m());
            cVar.e("app", dVar.b());
            cVar.e(ApiConstants.USER, dVar.l());
            cVar.e("os", dVar.j());
            cVar.e("device", dVar.c());
            cVar.e("events", dVar.e());
            cVar.c("generatorType", dVar.g());
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    private static final class i implements com.google.firebase.encoders.b<v.d.AbstractC0173d.a> {
        static final i a = new i();

        private i() {
        }

        @Override // com.google.firebase.encoders.b
        /* renamed from: b */
        public void a(v.d.AbstractC0173d.a aVar, com.google.firebase.encoders.c cVar) throws IOException {
            cVar.e("execution", aVar.d());
            cVar.e("customAttributes", aVar.c());
            cVar.e(AppStateModule.APP_STATE_BACKGROUND, aVar.b());
            cVar.c("uiOrientation", aVar.e());
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    private static final class j implements com.google.firebase.encoders.b<v.d.AbstractC0173d.a.b.AbstractC0175a> {
        static final j a = new j();

        private j() {
        }

        @Override // com.google.firebase.encoders.b
        /* renamed from: b */
        public void a(v.d.AbstractC0173d.a.b.AbstractC0175a abstractC0175a, com.google.firebase.encoders.c cVar) throws IOException {
            cVar.b("baseAddress", abstractC0175a.b());
            cVar.b("size", abstractC0175a.d());
            cVar.e(ApiConstants.NAME, abstractC0175a.c());
            cVar.e("uuid", abstractC0175a.f());
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    private static final class k implements com.google.firebase.encoders.b<v.d.AbstractC0173d.a.b> {
        static final k a = new k();

        private k() {
        }

        @Override // com.google.firebase.encoders.b
        /* renamed from: b */
        public void a(v.d.AbstractC0173d.a.b bVar, com.google.firebase.encoders.c cVar) throws IOException {
            cVar.e("threads", bVar.e());
            cVar.e("exception", bVar.c());
            cVar.e("signal", bVar.d());
            cVar.e("binaries", bVar.b());
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    private static final class l implements com.google.firebase.encoders.b<v.d.AbstractC0173d.a.b.c> {
        static final l a = new l();

        private l() {
        }

        @Override // com.google.firebase.encoders.b
        /* renamed from: b */
        public void a(v.d.AbstractC0173d.a.b.c cVar, com.google.firebase.encoders.c cVar2) throws IOException {
            cVar2.e("type", cVar.f());
            cVar2.e("reason", cVar.e());
            cVar2.e("frames", cVar.c());
            cVar2.e("causedBy", cVar.b());
            cVar2.c("overflowCount", cVar.d());
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    private static final class m implements com.google.firebase.encoders.b<v.d.AbstractC0173d.a.b.AbstractC0179d> {
        static final m a = new m();

        private m() {
        }

        @Override // com.google.firebase.encoders.b
        /* renamed from: b */
        public void a(v.d.AbstractC0173d.a.b.AbstractC0179d abstractC0179d, com.google.firebase.encoders.c cVar) throws IOException {
            cVar.e(ApiConstants.NAME, abstractC0179d.d());
            cVar.e("code", abstractC0179d.c());
            cVar.b("address", abstractC0179d.b());
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    private static final class n implements com.google.firebase.encoders.b<v.d.AbstractC0173d.a.b.e> {
        static final n a = new n();

        private n() {
        }

        @Override // com.google.firebase.encoders.b
        /* renamed from: b */
        public void a(v.d.AbstractC0173d.a.b.e eVar, com.google.firebase.encoders.c cVar) throws IOException {
            cVar.e(ApiConstants.NAME, eVar.d());
            cVar.c("importance", eVar.c());
            cVar.e("frames", eVar.b());
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    private static final class o implements com.google.firebase.encoders.b<v.d.AbstractC0173d.a.b.e.AbstractC0182b> {
        static final o a = new o();

        private o() {
        }

        @Override // com.google.firebase.encoders.b
        /* renamed from: b */
        public void a(v.d.AbstractC0173d.a.b.e.AbstractC0182b abstractC0182b, com.google.firebase.encoders.c cVar) throws IOException {
            cVar.b("pc", abstractC0182b.e());
            cVar.e("symbol", abstractC0182b.f());
            cVar.e("file", abstractC0182b.b());
            cVar.b("offset", abstractC0182b.d());
            cVar.c("importance", abstractC0182b.c());
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    private static final class p implements com.google.firebase.encoders.b<v.d.AbstractC0173d.c> {
        static final p a = new p();

        private p() {
        }

        @Override // com.google.firebase.encoders.b
        /* renamed from: b */
        public void a(v.d.AbstractC0173d.c cVar, com.google.firebase.encoders.c cVar2) throws IOException {
            cVar2.e("batteryLevel", cVar.b());
            cVar2.c("batteryVelocity", cVar.c());
            cVar2.a("proximityOn", cVar.g());
            cVar2.c("orientation", cVar.e());
            cVar2.b("ramUsed", cVar.f());
            cVar2.b("diskUsed", cVar.d());
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    private static final class q implements com.google.firebase.encoders.b<v.d.AbstractC0173d> {
        static final q a = new q();

        private q() {
        }

        @Override // com.google.firebase.encoders.b
        /* renamed from: b */
        public void a(v.d.AbstractC0173d abstractC0173d, com.google.firebase.encoders.c cVar) throws IOException {
            cVar.b("timestamp", abstractC0173d.e());
            cVar.e("type", abstractC0173d.f());
            cVar.e("app", abstractC0173d.b());
            cVar.e("device", abstractC0173d.c());
            cVar.e("log", abstractC0173d.d());
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    private static final class r implements com.google.firebase.encoders.b<v.d.AbstractC0173d.AbstractC0184d> {
        static final r a = new r();

        private r() {
        }

        @Override // com.google.firebase.encoders.b
        /* renamed from: b */
        public void a(v.d.AbstractC0173d.AbstractC0184d abstractC0184d, com.google.firebase.encoders.c cVar) throws IOException {
            cVar.e("content", abstractC0184d.b());
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    private static final class s implements com.google.firebase.encoders.b<v.d.e> {
        static final s a = new s();

        private s() {
        }

        @Override // com.google.firebase.encoders.b
        /* renamed from: b */
        public void a(v.d.e eVar, com.google.firebase.encoders.c cVar) throws IOException {
            cVar.c("platform", eVar.c());
            cVar.e(ClientCookie.VERSION_ATTR, eVar.d());
            cVar.e("buildVersion", eVar.b());
            cVar.a("jailbroken", eVar.e());
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes2.dex */
    private static final class t implements com.google.firebase.encoders.b<v.d.f> {
        static final t a = new t();

        private t() {
        }

        @Override // com.google.firebase.encoders.b
        /* renamed from: b */
        public void a(v.d.f fVar, com.google.firebase.encoders.c cVar) throws IOException {
            cVar.e("identifier", fVar.b());
        }
    }

    private a() {
    }

    @Override // com.google.firebase.encoders.f.a
    public void a(com.google.firebase.encoders.f.b<?> bVar) {
        b bVar2 = b.a;
        bVar.a(v.class, bVar2);
        bVar.a(com.google.firebase.crashlytics.c.i.b.class, bVar2);
        h hVar = h.a;
        bVar.a(v.d.class, hVar);
        bVar.a(com.google.firebase.crashlytics.c.i.f.class, hVar);
        e eVar = e.a;
        bVar.a(v.d.a.class, eVar);
        bVar.a(com.google.firebase.crashlytics.c.i.g.class, eVar);
        f fVar = f.a;
        bVar.a(v.d.a.b.class, fVar);
        bVar.a(com.google.firebase.crashlytics.c.i.h.class, fVar);
        t tVar = t.a;
        bVar.a(v.d.f.class, tVar);
        bVar.a(u.class, tVar);
        s sVar = s.a;
        bVar.a(v.d.e.class, sVar);
        bVar.a(com.google.firebase.crashlytics.c.i.t.class, sVar);
        g gVar = g.a;
        bVar.a(v.d.c.class, gVar);
        bVar.a(com.google.firebase.crashlytics.c.i.i.class, gVar);
        q qVar = q.a;
        bVar.a(v.d.AbstractC0173d.class, qVar);
        bVar.a(com.google.firebase.crashlytics.c.i.j.class, qVar);
        i iVar = i.a;
        bVar.a(v.d.AbstractC0173d.a.class, iVar);
        bVar.a(com.google.firebase.crashlytics.c.i.k.class, iVar);
        k kVar = k.a;
        bVar.a(v.d.AbstractC0173d.a.b.class, kVar);
        bVar.a(com.google.firebase.crashlytics.c.i.l.class, kVar);
        n nVar = n.a;
        bVar.a(v.d.AbstractC0173d.a.b.e.class, nVar);
        bVar.a(com.google.firebase.crashlytics.c.i.p.class, nVar);
        o oVar = o.a;
        bVar.a(v.d.AbstractC0173d.a.b.e.AbstractC0182b.class, oVar);
        bVar.a(com.google.firebase.crashlytics.c.i.q.class, oVar);
        l lVar = l.a;
        bVar.a(v.d.AbstractC0173d.a.b.c.class, lVar);
        bVar.a(com.google.firebase.crashlytics.c.i.n.class, lVar);
        m mVar = m.a;
        bVar.a(v.d.AbstractC0173d.a.b.AbstractC0179d.class, mVar);
        bVar.a(com.google.firebase.crashlytics.c.i.o.class, mVar);
        j jVar = j.a;
        bVar.a(v.d.AbstractC0173d.a.b.AbstractC0175a.class, jVar);
        bVar.a(com.google.firebase.crashlytics.c.i.m.class, jVar);
        C0170a c0170a = C0170a.a;
        bVar.a(v.b.class, c0170a);
        bVar.a(com.google.firebase.crashlytics.c.i.c.class, c0170a);
        p pVar = p.a;
        bVar.a(v.d.AbstractC0173d.c.class, pVar);
        bVar.a(com.google.firebase.crashlytics.c.i.r.class, pVar);
        r rVar = r.a;
        bVar.a(v.d.AbstractC0173d.AbstractC0184d.class, rVar);
        bVar.a(com.google.firebase.crashlytics.c.i.s.class, rVar);
        c cVar = c.a;
        bVar.a(v.c.class, cVar);
        bVar.a(com.google.firebase.crashlytics.c.i.d.class, cVar);
        d dVar = d.a;
        bVar.a(v.c.b.class, dVar);
        bVar.a(com.google.firebase.crashlytics.c.i.e.class, dVar);
    }
}
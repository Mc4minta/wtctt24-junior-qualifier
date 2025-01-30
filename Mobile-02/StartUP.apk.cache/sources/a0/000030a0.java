package com.google.android.datatransport.cct.b;

import java.io.IOException;

/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.1 */
/* loaded from: classes2.dex */
public final class b implements com.google.firebase.encoders.f.a {
    public static final com.google.firebase.encoders.f.a a = new b();

    /* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.1 */
    /* loaded from: classes2.dex */
    private static final class a implements com.google.firebase.encoders.b<com.google.android.datatransport.cct.b.a> {
        static final a a = new a();

        private a() {
        }

        @Override // com.google.firebase.encoders.b
        public void a(Object obj, Object obj2) throws IOException {
            com.google.android.datatransport.cct.b.a aVar = (com.google.android.datatransport.cct.b.a) obj;
            com.google.firebase.encoders.c cVar = (com.google.firebase.encoders.c) obj2;
            cVar.e("sdkVersion", aVar.i());
            cVar.e("model", aVar.f());
            cVar.e("hardware", aVar.d());
            cVar.e("device", aVar.b());
            cVar.e("product", aVar.h());
            cVar.e("osBuild", aVar.g());
            cVar.e("manufacturer", aVar.e());
            cVar.e("fingerprint", aVar.c());
        }
    }

    /* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.1 */
    /* renamed from: com.google.android.datatransport.cct.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static final class C0132b implements com.google.firebase.encoders.b<j> {
        static final C0132b a = new C0132b();

        private C0132b() {
        }

        @Override // com.google.firebase.encoders.b
        public void a(Object obj, Object obj2) throws IOException {
            ((com.google.firebase.encoders.c) obj2).e("logRequest", ((j) obj).b());
        }
    }

    /* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.1 */
    /* loaded from: classes2.dex */
    private static final class c implements com.google.firebase.encoders.b<k> {
        static final c a = new c();

        private c() {
        }

        @Override // com.google.firebase.encoders.b
        public void a(Object obj, Object obj2) throws IOException {
            k kVar = (k) obj;
            com.google.firebase.encoders.c cVar = (com.google.firebase.encoders.c) obj2;
            cVar.e("clientType", kVar.c());
            cVar.e("androidClientInfo", kVar.b());
        }
    }

    /* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.1 */
    /* loaded from: classes2.dex */
    private static final class d implements com.google.firebase.encoders.b<l> {
        static final d a = new d();

        private d() {
        }

        @Override // com.google.firebase.encoders.b
        public void a(Object obj, Object obj2) throws IOException {
            l lVar = (l) obj;
            com.google.firebase.encoders.c cVar = (com.google.firebase.encoders.c) obj2;
            cVar.b("eventTimeMs", lVar.d());
            cVar.e("eventCode", lVar.c());
            cVar.b("eventUptimeMs", lVar.e());
            cVar.e("sourceExtension", lVar.g());
            cVar.e("sourceExtensionJsonProto3", lVar.h());
            cVar.b("timezoneOffsetSeconds", lVar.i());
            cVar.e("networkConnectionInfo", lVar.f());
        }
    }

    /* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.1 */
    /* loaded from: classes2.dex */
    private static final class e implements com.google.firebase.encoders.b<m> {
        static final e a = new e();

        private e() {
        }

        @Override // com.google.firebase.encoders.b
        public void a(Object obj, Object obj2) throws IOException {
            m mVar = (m) obj;
            com.google.firebase.encoders.c cVar = (com.google.firebase.encoders.c) obj2;
            cVar.b("requestTimeMs", mVar.g());
            cVar.b("requestUptimeMs", mVar.h());
            cVar.e("clientInfo", mVar.b());
            cVar.e("logSource", mVar.d());
            cVar.e("logSourceName", mVar.e());
            cVar.e("logEvent", mVar.c());
            cVar.e("qosTier", mVar.f());
        }
    }

    /* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.1 */
    /* loaded from: classes2.dex */
    private static final class f implements com.google.firebase.encoders.b<o> {
        static final f a = new f();

        private f() {
        }

        @Override // com.google.firebase.encoders.b
        public void a(Object obj, Object obj2) throws IOException {
            o oVar = (o) obj;
            com.google.firebase.encoders.c cVar = (com.google.firebase.encoders.c) obj2;
            cVar.e("networkType", oVar.c());
            cVar.e("mobileSubtype", oVar.b());
        }
    }

    private b() {
    }

    @Override // com.google.firebase.encoders.f.a
    public void a(com.google.firebase.encoders.f.b<?> bVar) {
        C0132b c0132b = C0132b.a;
        bVar.a(j.class, c0132b);
        bVar.a(com.google.android.datatransport.cct.b.d.class, c0132b);
        e eVar = e.a;
        bVar.a(m.class, eVar);
        bVar.a(g.class, eVar);
        c cVar = c.a;
        bVar.a(k.class, cVar);
        bVar.a(com.google.android.datatransport.cct.b.e.class, cVar);
        a aVar = a.a;
        bVar.a(com.google.android.datatransport.cct.b.a.class, aVar);
        bVar.a(com.google.android.datatransport.cct.b.c.class, aVar);
        d dVar = d.a;
        bVar.a(l.class, dVar);
        bVar.a(com.google.android.datatransport.cct.b.f.class, dVar);
        f fVar = f.a;
        bVar.a(o.class, fVar);
        bVar.a(i.class, fVar);
    }
}
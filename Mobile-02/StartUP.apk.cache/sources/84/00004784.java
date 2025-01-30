package e.g.a.c.i;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* loaded from: classes2.dex */
final class o<T> implements e.g.a.c.f<T> {
    private final l a;

    /* renamed from: b  reason: collision with root package name */
    private final String f13009b;

    /* renamed from: c  reason: collision with root package name */
    private final e.g.a.c.b f13010c;

    /* renamed from: d  reason: collision with root package name */
    private final e.g.a.c.e<T, byte[]> f13011d;

    /* renamed from: e  reason: collision with root package name */
    private final p f13012e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(l lVar, String str, e.g.a.c.b bVar, e.g.a.c.e<T, byte[]> eVar, p pVar) {
        this.a = lVar;
        this.f13009b = str;
        this.f13010c = bVar;
        this.f13011d = eVar;
        this.f13012e = pVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void c(Exception exc) {
    }

    @Override // e.g.a.c.f
    public void a(e.g.a.c.c<T> cVar) {
        b(cVar, n.b());
    }

    @Override // e.g.a.c.f
    public void b(e.g.a.c.c<T> cVar, e.g.a.c.h hVar) {
        this.f13012e.a(k.a().e(this.a).c(cVar).f(this.f13009b).d(this.f13011d).b(this.f13010c).a(), hVar);
    }
}
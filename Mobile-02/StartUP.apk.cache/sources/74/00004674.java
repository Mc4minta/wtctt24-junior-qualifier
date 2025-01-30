package e.f.j.l;

/* compiled from: PostprocessedBitmapMemoryCacheProducer.java */
/* loaded from: classes2.dex */
public class h0 implements j0<com.facebook.common.references.a<e.f.j.i.b>> {
    private final e.f.j.d.p<e.f.b.a.d, e.f.j.i.b> a;

    /* renamed from: b  reason: collision with root package name */
    private final e.f.j.d.f f12634b;

    /* renamed from: c  reason: collision with root package name */
    private final j0<com.facebook.common.references.a<e.f.j.i.b>> f12635c;

    /* compiled from: PostprocessedBitmapMemoryCacheProducer.java */
    /* loaded from: classes2.dex */
    public static class a extends n<com.facebook.common.references.a<e.f.j.i.b>, com.facebook.common.references.a<e.f.j.i.b>> {

        /* renamed from: c  reason: collision with root package name */
        private final e.f.b.a.d f12636c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f12637d;

        /* renamed from: e  reason: collision with root package name */
        private final e.f.j.d.p<e.f.b.a.d, e.f.j.i.b> f12638e;

        /* renamed from: f  reason: collision with root package name */
        private final boolean f12639f;

        public a(k<com.facebook.common.references.a<e.f.j.i.b>> kVar, e.f.b.a.d dVar, boolean z, e.f.j.d.p<e.f.b.a.d, e.f.j.i.b> pVar, boolean z2) {
            super(kVar);
            this.f12636c = dVar;
            this.f12637d = z;
            this.f12638e = pVar;
            this.f12639f = z2;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // e.f.j.l.b
        /* renamed from: p */
        public void h(com.facebook.common.references.a<e.f.j.i.b> aVar, int i2) {
            if (aVar == null) {
                if (b.d(i2)) {
                    o().c(null, i2);
                }
            } else if (!b.e(i2) || this.f12637d) {
                com.facebook.common.references.a<e.f.j.i.b> a = this.f12639f ? this.f12638e.a(this.f12636c, aVar) : null;
                try {
                    o().b(1.0f);
                    k<com.facebook.common.references.a<e.f.j.i.b>> o = o();
                    if (a != null) {
                        aVar = a;
                    }
                    o.c(aVar, i2);
                } finally {
                    com.facebook.common.references.a.f(a);
                }
            }
        }
    }

    public h0(e.f.j.d.p<e.f.b.a.d, e.f.j.i.b> pVar, e.f.j.d.f fVar, j0<com.facebook.common.references.a<e.f.j.i.b>> j0Var) {
        this.a = pVar;
        this.f12634b = fVar;
        this.f12635c = j0Var;
    }

    @Override // e.f.j.l.j0
    public void b(k<com.facebook.common.references.a<e.f.j.i.b>> kVar, k0 k0Var) {
        m0 f2 = k0Var.f();
        String id = k0Var.getId();
        com.facebook.imagepipeline.request.b c2 = k0Var.c();
        Object a2 = k0Var.a();
        com.facebook.imagepipeline.request.c g2 = c2.g();
        if (g2 != null && g2.c() != null) {
            f2.b(id, c());
            e.f.b.a.d c3 = this.f12634b.c(c2, a2);
            com.facebook.common.references.a<e.f.j.i.b> aVar = this.a.get(c3);
            if (aVar != null) {
                f2.i(id, c(), f2.f(id) ? e.f.d.c.f.of("cached_value_found", "true") : null);
                f2.e(id, "PostprocessedBitmapMemoryCacheProducer", true);
                kVar.b(1.0f);
                kVar.c(aVar, 1);
                aVar.close();
                return;
            }
            a aVar2 = new a(kVar, c3, g2 instanceof com.facebook.imagepipeline.request.d, this.a, k0Var.c().u());
            f2.i(id, c(), f2.f(id) ? e.f.d.c.f.of("cached_value_found", "false") : null);
            this.f12635c.b(aVar2, k0Var);
            return;
        }
        this.f12635c.b(kVar, k0Var);
    }

    protected String c() {
        return "PostprocessedBitmapMemoryCacheProducer";
    }
}
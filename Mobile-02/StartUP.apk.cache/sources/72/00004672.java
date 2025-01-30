package e.f.j.l;

import com.facebook.imagepipeline.request.b;

/* compiled from: BitmapMemoryCacheProducer.java */
/* loaded from: classes2.dex */
public class h implements j0<com.facebook.common.references.a<e.f.j.i.b>> {
    private final e.f.j.d.p<e.f.b.a.d, e.f.j.i.b> a;

    /* renamed from: b  reason: collision with root package name */
    private final e.f.j.d.f f12629b;

    /* renamed from: c  reason: collision with root package name */
    private final j0<com.facebook.common.references.a<e.f.j.i.b>> f12630c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BitmapMemoryCacheProducer.java */
    /* loaded from: classes2.dex */
    public class a extends n<com.facebook.common.references.a<e.f.j.i.b>, com.facebook.common.references.a<e.f.j.i.b>> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ e.f.b.a.d f12631c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ boolean f12632d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(k kVar, e.f.b.a.d dVar, boolean z) {
            super(kVar);
            this.f12631c = dVar;
            this.f12632d = z;
        }

        @Override // e.f.j.l.b
        /* renamed from: p */
        public void h(com.facebook.common.references.a<e.f.j.i.b> aVar, int i2) {
            com.facebook.common.references.a<e.f.j.i.b> aVar2;
            boolean d2;
            try {
                if (e.f.j.m.b.d()) {
                    e.f.j.m.b.a("BitmapMemoryCacheProducer#onNewResultImpl");
                }
                boolean d3 = b.d(i2);
                if (aVar == null) {
                    if (d3) {
                        o().c(null, i2);
                    }
                    if (d2) {
                        return;
                    }
                    return;
                }
                if (!aVar.n().c() && !b.m(i2, 8)) {
                    if (!d3 && (aVar2 = h.this.a.get(this.f12631c)) != null) {
                        e.f.j.i.g a = aVar.n().a();
                        e.f.j.i.g a2 = aVar2.n().a();
                        if (!a2.a() && a2.c() < a.c()) {
                            com.facebook.common.references.a.f(aVar2);
                        } else {
                            o().c(aVar2, i2);
                            com.facebook.common.references.a.f(aVar2);
                            if (e.f.j.m.b.d()) {
                                e.f.j.m.b.b();
                                return;
                            }
                            return;
                        }
                    }
                    com.facebook.common.references.a<e.f.j.i.b> a3 = this.f12632d ? h.this.a.a(this.f12631c, aVar) : null;
                    if (d3) {
                        o().b(1.0f);
                    }
                    k<com.facebook.common.references.a<e.f.j.i.b>> o = o();
                    if (a3 != null) {
                        aVar = a3;
                    }
                    o.c(aVar, i2);
                    com.facebook.common.references.a.f(a3);
                    if (e.f.j.m.b.d()) {
                        e.f.j.m.b.b();
                        return;
                    }
                    return;
                }
                o().c(aVar, i2);
                if (e.f.j.m.b.d()) {
                    e.f.j.m.b.b();
                }
            } finally {
                if (e.f.j.m.b.d()) {
                    e.f.j.m.b.b();
                }
            }
        }
    }

    public h(e.f.j.d.p<e.f.b.a.d, e.f.j.i.b> pVar, e.f.j.d.f fVar, j0<com.facebook.common.references.a<e.f.j.i.b>> j0Var) {
        this.a = pVar;
        this.f12629b = fVar;
        this.f12630c = j0Var;
    }

    @Override // e.f.j.l.j0
    public void b(k<com.facebook.common.references.a<e.f.j.i.b>> kVar, k0 k0Var) {
        boolean d2;
        try {
            if (e.f.j.m.b.d()) {
                e.f.j.m.b.a("BitmapMemoryCacheProducer#produceResults");
            }
            m0 f2 = k0Var.f();
            String id = k0Var.getId();
            f2.b(id, d());
            e.f.b.a.d a2 = this.f12629b.a(k0Var.c(), k0Var.a());
            com.facebook.common.references.a<e.f.j.i.b> aVar = this.a.get(a2);
            if (aVar != null) {
                boolean a3 = aVar.n().a().a();
                if (a3) {
                    f2.i(id, d(), f2.f(id) ? e.f.d.c.f.of("cached_value_found", "true") : null);
                    f2.e(id, d(), true);
                    kVar.b(1.0f);
                }
                kVar.c(aVar, b.k(a3));
                aVar.close();
                if (a3) {
                    if (d2) {
                        return;
                    }
                    return;
                }
            }
            if (k0Var.h().n() >= b.EnumC0109b.BITMAP_MEMORY_CACHE.n()) {
                f2.i(id, d(), f2.f(id) ? e.f.d.c.f.of("cached_value_found", "false") : null);
                f2.e(id, d(), false);
                kVar.c(null, 1);
                if (e.f.j.m.b.d()) {
                    e.f.j.m.b.b();
                    return;
                }
                return;
            }
            k<com.facebook.common.references.a<e.f.j.i.b>> e2 = e(kVar, a2, k0Var.c().u());
            f2.i(id, d(), f2.f(id) ? e.f.d.c.f.of("cached_value_found", "false") : null);
            if (e.f.j.m.b.d()) {
                e.f.j.m.b.a("mInputProducer.produceResult");
            }
            this.f12630c.b(e2, k0Var);
            if (e.f.j.m.b.d()) {
                e.f.j.m.b.b();
            }
            if (e.f.j.m.b.d()) {
                e.f.j.m.b.b();
            }
        } finally {
            if (e.f.j.m.b.d()) {
                e.f.j.m.b.b();
            }
        }
    }

    protected String d() {
        return "BitmapMemoryCacheProducer";
    }

    protected k<com.facebook.common.references.a<e.f.j.i.b>> e(k<com.facebook.common.references.a<e.f.j.i.b>> kVar, e.f.b.a.d dVar, boolean z) {
        return new a(kVar, dVar, z);
    }
}
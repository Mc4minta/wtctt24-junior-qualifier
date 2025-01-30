package e.f.j.l;

import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.request.b;

/* compiled from: EncodedMemoryCacheProducer.java */
/* loaded from: classes2.dex */
public class r implements j0<e.f.j.i.d> {
    private final e.f.j.d.p<e.f.b.a.d, PooledByteBuffer> a;

    /* renamed from: b  reason: collision with root package name */
    private final e.f.j.d.f f12725b;

    /* renamed from: c  reason: collision with root package name */
    private final j0<e.f.j.i.d> f12726c;

    /* compiled from: EncodedMemoryCacheProducer.java */
    /* loaded from: classes2.dex */
    private static class a extends n<e.f.j.i.d, e.f.j.i.d> {

        /* renamed from: c  reason: collision with root package name */
        private final e.f.j.d.p<e.f.b.a.d, PooledByteBuffer> f12727c;

        /* renamed from: d  reason: collision with root package name */
        private final e.f.b.a.d f12728d;

        /* renamed from: e  reason: collision with root package name */
        private final boolean f12729e;

        public a(k<e.f.j.i.d> kVar, e.f.j.d.p<e.f.b.a.d, PooledByteBuffer> pVar, e.f.b.a.d dVar, boolean z) {
            super(kVar);
            this.f12727c = pVar;
            this.f12728d = dVar;
            this.f12729e = z;
        }

        @Override // e.f.j.l.b
        /* renamed from: p */
        public void h(e.f.j.i.d dVar, int i2) {
            boolean d2;
            try {
                if (e.f.j.m.b.d()) {
                    e.f.j.m.b.a("EncodedMemoryCacheProducer#onNewResultImpl");
                }
                if (!b.e(i2) && dVar != null && !b.l(i2, 10) && dVar.v() != e.f.i.c.a) {
                    com.facebook.common.references.a<PooledByteBuffer> e2 = dVar.e();
                    if (e2 != null) {
                        com.facebook.common.references.a<PooledByteBuffer> a = this.f12729e ? this.f12727c.a(this.f12728d, e2) : null;
                        com.facebook.common.references.a.f(e2);
                        if (a != null) {
                            e.f.j.i.d dVar2 = new e.f.j.i.d(a);
                            dVar2.d(dVar);
                            com.facebook.common.references.a.f(a);
                            o().b(1.0f);
                            o().c(dVar2, i2);
                            e.f.j.i.d.c(dVar2);
                            if (d2) {
                                return;
                            }
                            return;
                        }
                    }
                    o().c(dVar, i2);
                    if (e.f.j.m.b.d()) {
                        e.f.j.m.b.b();
                        return;
                    }
                    return;
                }
                o().c(dVar, i2);
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

    public r(e.f.j.d.p<e.f.b.a.d, PooledByteBuffer> pVar, e.f.j.d.f fVar, j0<e.f.j.i.d> j0Var) {
        this.a = pVar;
        this.f12725b = fVar;
        this.f12726c = j0Var;
    }

    @Override // e.f.j.l.j0
    public void b(k<e.f.j.i.d> kVar, k0 k0Var) {
        try {
            if (e.f.j.m.b.d()) {
                e.f.j.m.b.a("EncodedMemoryCacheProducer#produceResults");
            }
            String id = k0Var.getId();
            m0 f2 = k0Var.f();
            f2.b(id, "EncodedMemoryCacheProducer");
            e.f.b.a.d d2 = this.f12725b.d(k0Var.c(), k0Var.a());
            com.facebook.common.references.a<PooledByteBuffer> aVar = this.a.get(d2);
            if (aVar != null) {
                e.f.j.i.d dVar = new e.f.j.i.d(aVar);
                f2.i(id, "EncodedMemoryCacheProducer", f2.f(id) ? e.f.d.c.f.of("cached_value_found", "true") : null);
                f2.e(id, "EncodedMemoryCacheProducer", true);
                kVar.b(1.0f);
                kVar.c(dVar, 1);
                e.f.j.i.d.c(dVar);
                com.facebook.common.references.a.f(aVar);
            } else if (k0Var.h().n() >= b.EnumC0109b.ENCODED_MEMORY_CACHE.n()) {
                f2.i(id, "EncodedMemoryCacheProducer", f2.f(id) ? e.f.d.c.f.of("cached_value_found", "false") : null);
                f2.e(id, "EncodedMemoryCacheProducer", false);
                kVar.c(null, 1);
                com.facebook.common.references.a.f(aVar);
                if (e.f.j.m.b.d()) {
                    e.f.j.m.b.b();
                }
            } else {
                a aVar2 = new a(kVar, this.a, d2, k0Var.c().u());
                f2.i(id, "EncodedMemoryCacheProducer", f2.f(id) ? e.f.d.c.f.of("cached_value_found", "false") : null);
                this.f12726c.b(aVar2, k0Var);
                com.facebook.common.references.a.f(aVar);
                if (e.f.j.m.b.d()) {
                    e.f.j.m.b.b();
                }
            }
        } finally {
            if (e.f.j.m.b.d()) {
                e.f.j.m.b.b();
            }
        }
    }
}
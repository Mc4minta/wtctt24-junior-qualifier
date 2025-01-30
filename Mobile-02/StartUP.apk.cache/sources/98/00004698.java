package e.f.j.l;

import com.facebook.imagepipeline.request.b;

/* compiled from: DiskCacheWriteProducer.java */
/* loaded from: classes2.dex */
public class p implements j0<e.f.j.i.d> {
    private final e.f.j.d.e a;

    /* renamed from: b  reason: collision with root package name */
    private final e.f.j.d.e f12713b;

    /* renamed from: c  reason: collision with root package name */
    private final e.f.j.d.f f12714c;

    /* renamed from: d  reason: collision with root package name */
    private final j0<e.f.j.i.d> f12715d;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DiskCacheWriteProducer.java */
    /* loaded from: classes2.dex */
    public static class b extends n<e.f.j.i.d, e.f.j.i.d> {

        /* renamed from: c  reason: collision with root package name */
        private final k0 f12716c;

        /* renamed from: d  reason: collision with root package name */
        private final e.f.j.d.e f12717d;

        /* renamed from: e  reason: collision with root package name */
        private final e.f.j.d.e f12718e;

        /* renamed from: f  reason: collision with root package name */
        private final e.f.j.d.f f12719f;

        @Override // e.f.j.l.b
        /* renamed from: p */
        public void h(e.f.j.i.d dVar, int i2) {
            if (!e.f.j.l.b.e(i2) && dVar != null && !e.f.j.l.b.l(i2, 10) && dVar.v() != e.f.i.c.a) {
                com.facebook.imagepipeline.request.b c2 = this.f12716c.c();
                e.f.b.a.d d2 = this.f12719f.d(c2, this.f12716c.a());
                if (c2.c() == b.a.SMALL) {
                    this.f12718e.o(d2, dVar);
                } else {
                    this.f12717d.o(d2, dVar);
                }
                o().c(dVar, i2);
                return;
            }
            o().c(dVar, i2);
        }

        private b(k<e.f.j.i.d> kVar, k0 k0Var, e.f.j.d.e eVar, e.f.j.d.e eVar2, e.f.j.d.f fVar) {
            super(kVar);
            this.f12716c = k0Var;
            this.f12717d = eVar;
            this.f12718e = eVar2;
            this.f12719f = fVar;
        }
    }

    public p(e.f.j.d.e eVar, e.f.j.d.e eVar2, e.f.j.d.f fVar, j0<e.f.j.i.d> j0Var) {
        this.a = eVar;
        this.f12713b = eVar2;
        this.f12714c = fVar;
        this.f12715d = j0Var;
    }

    private void c(k<e.f.j.i.d> kVar, k0 k0Var) {
        if (k0Var.h().n() >= b.EnumC0109b.DISK_CACHE.n()) {
            kVar.c(null, 1);
            return;
        }
        if (k0Var.c().t()) {
            kVar = new b(kVar, k0Var, this.a, this.f12713b, this.f12714c);
        }
        this.f12715d.b(kVar, k0Var);
    }

    @Override // e.f.j.l.j0
    public void b(k<e.f.j.i.d> kVar, k0 k0Var) {
        c(kVar, k0Var);
    }
}
package e.f.j.l;

/* compiled from: BranchOnSeparateImagesProducer.java */
/* loaded from: classes2.dex */
public class j implements j0<e.f.j.i.d> {
    private final j0<e.f.j.i.d> a;

    /* renamed from: b  reason: collision with root package name */
    private final j0<e.f.j.i.d> f12662b;

    /* compiled from: BranchOnSeparateImagesProducer.java */
    /* loaded from: classes2.dex */
    private class b extends n<e.f.j.i.d, e.f.j.i.d> {

        /* renamed from: c  reason: collision with root package name */
        private k0 f12663c;

        @Override // e.f.j.l.n, e.f.j.l.b
        protected void g(Throwable th) {
            j.this.f12662b.b(o(), this.f12663c);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // e.f.j.l.b
        /* renamed from: p */
        public void h(e.f.j.i.d dVar, int i2) {
            com.facebook.imagepipeline.request.b c2 = this.f12663c.c();
            boolean d2 = e.f.j.l.b.d(i2);
            boolean c3 = x0.c(dVar, c2.m());
            if (dVar != null && (c3 || c2.e())) {
                if (d2 && c3) {
                    o().c(dVar, i2);
                } else {
                    o().c(dVar, e.f.j.l.b.n(i2, 1));
                }
            }
            if (!d2 || c3) {
                return;
            }
            e.f.j.i.d.c(dVar);
            j.this.f12662b.b(o(), this.f12663c);
        }

        private b(k<e.f.j.i.d> kVar, k0 k0Var) {
            super(kVar);
            this.f12663c = k0Var;
        }
    }

    public j(j0<e.f.j.i.d> j0Var, j0<e.f.j.i.d> j0Var2) {
        this.a = j0Var;
        this.f12662b = j0Var2;
    }

    @Override // e.f.j.l.j0
    public void b(k<e.f.j.i.d> kVar, k0 k0Var) {
        this.a.b(new b(kVar, k0Var), k0Var);
    }
}
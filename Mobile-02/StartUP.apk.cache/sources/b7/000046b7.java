package e.f.j.l;

/* compiled from: ThumbnailBranchProducer.java */
/* loaded from: classes2.dex */
public class v0 implements j0<e.f.j.i.d> {
    private final w0<e.f.j.i.d>[] a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ThumbnailBranchProducer.java */
    /* loaded from: classes2.dex */
    public class a extends n<e.f.j.i.d, e.f.j.i.d> {

        /* renamed from: c  reason: collision with root package name */
        private final k0 f12773c;

        /* renamed from: d  reason: collision with root package name */
        private final int f12774d;

        /* renamed from: e  reason: collision with root package name */
        private final com.facebook.imagepipeline.common.e f12775e;

        public a(k<e.f.j.i.d> kVar, k0 k0Var, int i2) {
            super(kVar);
            this.f12773c = k0Var;
            this.f12774d = i2;
            this.f12775e = k0Var.c().m();
        }

        @Override // e.f.j.l.n, e.f.j.l.b
        protected void g(Throwable th) {
            if (v0.this.e(this.f12774d + 1, o(), this.f12773c)) {
                return;
            }
            o().onFailure(th);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // e.f.j.l.b
        /* renamed from: p */
        public void h(e.f.j.i.d dVar, int i2) {
            if (dVar != null && (b.e(i2) || x0.c(dVar, this.f12775e))) {
                o().c(dVar, i2);
            } else if (b.d(i2)) {
                e.f.j.i.d.c(dVar);
                if (v0.this.e(this.f12774d + 1, o(), this.f12773c)) {
                    return;
                }
                o().c(null, 1);
            }
        }
    }

    public v0(w0<e.f.j.i.d>... w0VarArr) {
        w0<e.f.j.i.d>[] w0VarArr2 = (w0[]) e.f.d.c.i.g(w0VarArr);
        this.a = w0VarArr2;
        e.f.d.c.i.e(0, w0VarArr2.length);
    }

    private int d(int i2, com.facebook.imagepipeline.common.e eVar) {
        while (true) {
            w0<e.f.j.i.d>[] w0VarArr = this.a;
            if (i2 >= w0VarArr.length) {
                return -1;
            }
            if (w0VarArr[i2].a(eVar)) {
                return i2;
            }
            i2++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(int i2, k<e.f.j.i.d> kVar, k0 k0Var) {
        int d2 = d(i2, k0Var.c().m());
        if (d2 == -1) {
            return false;
        }
        this.a[d2].b(new a(kVar, k0Var, d2), k0Var);
        return true;
    }

    @Override // e.f.j.l.j0
    public void b(k<e.f.j.i.d> kVar, k0 k0Var) {
        if (k0Var.c().m() == null) {
            kVar.c(null, 1);
        } else if (e(0, kVar, k0Var)) {
        } else {
            kVar.c(null, 1);
        }
    }
}
package e.f.j.l;

/* compiled from: AddImageTransformMetaDataProducer.java */
/* loaded from: classes2.dex */
public class a implements j0<e.f.j.i.d> {
    private final j0<e.f.j.i.d> a;

    /* compiled from: AddImageTransformMetaDataProducer.java */
    /* loaded from: classes2.dex */
    private static class b extends n<e.f.j.i.d, e.f.j.i.d> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // e.f.j.l.b
        /* renamed from: p */
        public void h(e.f.j.i.d dVar, int i2) {
            if (dVar == null) {
                o().c(null, i2);
                return;
            }
            if (!e.f.j.i.d.V(dVar)) {
                dVar.e0();
            }
            o().c(dVar, i2);
        }

        private b(k<e.f.j.i.d> kVar) {
            super(kVar);
        }
    }

    public a(j0<e.f.j.i.d> j0Var) {
        this.a = j0Var;
    }

    @Override // e.f.j.l.j0
    public void b(k<e.f.j.i.d> kVar, k0 k0Var) {
        this.a.b(new b(kVar), k0Var);
    }
}
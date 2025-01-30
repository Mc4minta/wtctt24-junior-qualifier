package e.f.j.l;

/* compiled from: SwallowResultProducer.java */
/* loaded from: classes2.dex */
public class r0<T> implements j0<Void> {
    private final j0<T> a;

    /* compiled from: SwallowResultProducer.java */
    /* loaded from: classes2.dex */
    class a extends n<T, Void> {
        a(k kVar) {
            super(kVar);
        }

        @Override // e.f.j.l.b
        protected void h(T t, int i2) {
            if (b.d(i2)) {
                o().c(null, i2);
            }
        }
    }

    public r0(j0<T> j0Var) {
        this.a = j0Var;
    }

    @Override // e.f.j.l.j0
    public void b(k<Void> kVar, k0 k0Var) {
        this.a.b(new a(kVar), k0Var);
    }
}
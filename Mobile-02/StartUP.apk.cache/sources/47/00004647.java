package e.f.j.f;

import e.f.j.l.j0;
import e.f.j.l.p0;

/* compiled from: CloseableProducerToDataSourceAdapter.java */
/* loaded from: classes2.dex */
public class c<T> extends a<com.facebook.common.references.a<T>> {
    private c(j0<com.facebook.common.references.a<T>> j0Var, p0 p0Var, e.f.j.j.c cVar) {
        super(j0Var, p0Var, cVar);
    }

    public static <T> e.f.e.c<com.facebook.common.references.a<T>> C(j0<com.facebook.common.references.a<T>> j0Var, p0 p0Var, e.f.j.j.c cVar) {
        if (e.f.j.m.b.d()) {
            e.f.j.m.b.a("CloseableProducerToDataSourceAdapter#create");
        }
        c cVar2 = new c(j0Var, p0Var, cVar);
        if (e.f.j.m.b.d()) {
            e.f.j.m.b.b();
        }
        return cVar2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e.f.e.a
    /* renamed from: B */
    public void h(com.facebook.common.references.a<T> aVar) {
        com.facebook.common.references.a.f(aVar);
    }

    @Override // e.f.e.a, e.f.e.c
    /* renamed from: D */
    public com.facebook.common.references.a<T> f() {
        return com.facebook.common.references.a.e((com.facebook.common.references.a) super.f());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e.f.j.f.a
    /* renamed from: E */
    public void A(com.facebook.common.references.a<T> aVar, int i2) {
        super.A(com.facebook.common.references.a.e(aVar), i2);
    }
}
package e.f.j.f;

import e.f.d.c.i;
import e.f.j.l.j0;
import e.f.j.l.k;
import e.f.j.l.p0;

/* compiled from: AbstractProducerToDataSourceAdapter.java */
/* loaded from: classes2.dex */
public abstract class a<T> extends e.f.e.a<T> {

    /* renamed from: g  reason: collision with root package name */
    private final p0 f12561g;

    /* renamed from: h  reason: collision with root package name */
    private final e.f.j.j.c f12562h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AbstractProducerToDataSourceAdapter.java */
    /* renamed from: e.f.j.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0276a extends e.f.j.l.b<T> {
        C0276a() {
        }

        @Override // e.f.j.l.b
        protected void f() {
            a.this.y();
        }

        @Override // e.f.j.l.b
        protected void g(Throwable th) {
            a.this.z(th);
        }

        @Override // e.f.j.l.b
        protected void h(T t, int i2) {
            a.this.A(t, i2);
        }

        @Override // e.f.j.l.b
        protected void i(float f2) {
            a.this.p(f2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(j0<T> j0Var, p0 p0Var, e.f.j.j.c cVar) {
        if (e.f.j.m.b.d()) {
            e.f.j.m.b.a("AbstractProducerToDataSourceAdapter()");
        }
        this.f12561g = p0Var;
        this.f12562h = cVar;
        if (e.f.j.m.b.d()) {
            e.f.j.m.b.a("AbstractProducerToDataSourceAdapter()->onRequestStart");
        }
        cVar.a(p0Var.c(), p0Var.a(), p0Var.getId(), p0Var.e());
        if (e.f.j.m.b.d()) {
            e.f.j.m.b.b();
        }
        if (e.f.j.m.b.d()) {
            e.f.j.m.b.a("AbstractProducerToDataSourceAdapter()->produceResult");
        }
        j0Var.b(x(), p0Var);
        if (e.f.j.m.b.d()) {
            e.f.j.m.b.b();
        }
        if (e.f.j.m.b.d()) {
            e.f.j.m.b.b();
        }
    }

    private k<T> x() {
        return new C0276a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void y() {
        i.i(j());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(Throwable th) {
        if (super.n(th)) {
            this.f12562h.g(this.f12561g.c(), this.f12561g.getId(), th, this.f12561g.e());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void A(T t, int i2) {
        boolean d2 = e.f.j.l.b.d(i2);
        if (super.r(t, d2) && d2) {
            this.f12562h.c(this.f12561g.c(), this.f12561g.getId(), this.f12561g.e());
        }
    }

    @Override // e.f.e.a, e.f.e.c
    public boolean close() {
        if (super.close()) {
            if (super.b()) {
                return true;
            }
            this.f12562h.k(this.f12561g.getId());
            this.f12561g.m();
            return true;
        }
        return false;
    }
}
package h.c.n0.e.b;

/* compiled from: FlowableMaterialize.java */
/* loaded from: classes3.dex */
public final class d2<T> extends h.c.n0.e.b.a<T, h.c.r<T>> {

    /* compiled from: FlowableMaterialize.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends h.c.n0.h.s<T, h.c.r<T>> {
        a(k.a.c<? super h.c.r<T>> cVar) {
            super(cVar);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // h.c.n0.h.s
        /* renamed from: c */
        public void b(h.c.r<T> rVar) {
            if (rVar.g()) {
                h.c.r0.a.u(rVar.d());
            }
        }

        @Override // k.a.c
        public void onComplete() {
            a(h.c.r.a());
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            a(h.c.r.b(th));
        }

        @Override // k.a.c
        public void onNext(T t) {
            this.f16747d++;
            this.a.onNext(h.c.r.c(t));
        }
    }

    public d2(h.c.h<T> hVar) {
        super(hVar);
    }

    @Override // h.c.h
    protected void subscribeActual(k.a.c<? super h.c.r<T>> cVar) {
        this.a.subscribe((h.c.m) new a(cVar));
    }
}
package h.c.n0.e.g;

/* compiled from: SingleDoOnSubscribe.java */
/* loaded from: classes3.dex */
public final class s<T> extends h.c.b0<T> {
    final h.c.h0<T> a;

    /* renamed from: b  reason: collision with root package name */
    final h.c.m0.f<? super h.c.k0.b> f16557b;

    /* compiled from: SingleDoOnSubscribe.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements h.c.e0<T> {
        final h.c.e0<? super T> a;

        /* renamed from: b  reason: collision with root package name */
        final h.c.m0.f<? super h.c.k0.b> f16558b;

        /* renamed from: c  reason: collision with root package name */
        boolean f16559c;

        a(h.c.e0<? super T> e0Var, h.c.m0.f<? super h.c.k0.b> fVar) {
            this.a = e0Var;
            this.f16558b = fVar;
        }

        @Override // h.c.e0
        public void onError(Throwable th) {
            if (this.f16559c) {
                h.c.r0.a.u(th);
            } else {
                this.a.onError(th);
            }
        }

        @Override // h.c.e0
        public void onSubscribe(h.c.k0.b bVar) {
            try {
                this.f16558b.accept(bVar);
                this.a.onSubscribe(bVar);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f16559c = true;
                bVar.dispose();
                h.c.n0.a.d.z(th, this.a);
            }
        }

        @Override // h.c.e0
        public void onSuccess(T t) {
            if (this.f16559c) {
                return;
            }
            this.a.onSuccess(t);
        }
    }

    public s(h.c.h0<T> h0Var, h.c.m0.f<? super h.c.k0.b> fVar) {
        this.a = h0Var;
        this.f16557b = fVar;
    }

    @Override // h.c.b0
    protected void subscribeActual(h.c.e0<? super T> e0Var) {
        this.a.subscribe(new a(e0Var, this.f16557b));
    }
}
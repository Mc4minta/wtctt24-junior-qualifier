package h.c.n0.h;

/* compiled from: BasicFuseableConditionalSubscriber.java */
/* loaded from: classes3.dex */
public abstract class a<T, R> implements h.c.n0.c.a<T>, h.c.n0.c.g<R> {
    protected final h.c.n0.c.a<? super R> a;

    /* renamed from: b  reason: collision with root package name */
    protected k.a.d f16707b;

    /* renamed from: c  reason: collision with root package name */
    protected h.c.n0.c.g<T> f16708c;

    /* renamed from: d  reason: collision with root package name */
    protected boolean f16709d;

    /* renamed from: e  reason: collision with root package name */
    protected int f16710e;

    public a(h.c.n0.c.a<? super R> aVar) {
        this.a = aVar;
    }

    protected void a() {
    }

    protected boolean b() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c(Throwable th) {
        io.reactivex.exceptions.a.b(th);
        this.f16707b.cancel();
        onError(th);
    }

    @Override // k.a.d
    public void cancel() {
        this.f16707b.cancel();
    }

    @Override // h.c.n0.c.j
    public void clear() {
        this.f16708c.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int d(int i2) {
        h.c.n0.c.g<T> gVar = this.f16708c;
        if (gVar == null || (i2 & 4) != 0) {
            return 0;
        }
        int n = gVar.n(i2);
        if (n != 0) {
            this.f16710e = n;
        }
        return n;
    }

    @Override // h.c.n0.c.j
    public boolean isEmpty() {
        return this.f16708c.isEmpty();
    }

    @Override // h.c.n0.c.j
    public final boolean offer(R r) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // k.a.c
    public void onComplete() {
        if (this.f16709d) {
            return;
        }
        this.f16709d = true;
        this.a.onComplete();
    }

    @Override // k.a.c
    public void onError(Throwable th) {
        if (this.f16709d) {
            h.c.r0.a.u(th);
            return;
        }
        this.f16709d = true;
        this.a.onError(th);
    }

    @Override // h.c.m, k.a.c
    public final void onSubscribe(k.a.d dVar) {
        if (h.c.n0.i.g.C(this.f16707b, dVar)) {
            this.f16707b = dVar;
            if (dVar instanceof h.c.n0.c.g) {
                this.f16708c = (h.c.n0.c.g) dVar;
            }
            if (b()) {
                this.a.onSubscribe(this);
                a();
            }
        }
    }

    @Override // k.a.d
    public void request(long j2) {
        this.f16707b.request(j2);
    }
}
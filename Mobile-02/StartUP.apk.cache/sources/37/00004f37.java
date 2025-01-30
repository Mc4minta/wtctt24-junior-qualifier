package h.c.n0.e.e;

/* compiled from: ObservableLift.java */
/* loaded from: classes3.dex */
public final class u1<R, T> extends a<T, R> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.w<? extends R, ? super T> f16260b;

    public u1(h.c.x<T> xVar, h.c.w<? extends R, ? super T> wVar) {
        super(xVar);
        this.f16260b = wVar;
    }

    @Override // h.c.s
    public void subscribeActual(h.c.z<? super R> zVar) {
        try {
            h.c.z<? super Object> a = this.f16260b.a(zVar);
            this.a.subscribe((h.c.z) h.c.n0.b.b.e(a, "Operator " + this.f16260b + " returned a null Observer"));
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            h.c.r0.a.u(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }
}
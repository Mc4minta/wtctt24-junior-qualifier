package h.c.n0.e.b;

/* compiled from: FlowableLift.java */
/* loaded from: classes3.dex */
public final class y1<R, T> extends a<T, R> {

    /* renamed from: b  reason: collision with root package name */
    final h.c.l<? extends R, ? super T> f15253b;

    public y1(h.c.h<T> hVar, h.c.l<? extends R, ? super T> lVar) {
        super(hVar);
        this.f15253b = lVar;
    }

    @Override // h.c.h
    public void subscribeActual(k.a.c<? super R> cVar) {
        try {
            k.a.c<? super Object> a = this.f15253b.a(cVar);
            if (a != null) {
                this.a.subscribe(a);
                return;
            }
            throw new NullPointerException("Operator " + this.f15253b + " returned a null Subscriber");
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
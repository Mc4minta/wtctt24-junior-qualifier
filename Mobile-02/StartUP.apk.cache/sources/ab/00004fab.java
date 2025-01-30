package h.c.n0.e.g;

/* compiled from: SingleLift.java */
/* loaded from: classes3.dex */
public final class j0<T, R> extends h.c.b0<R> {
    final h.c.h0<T> a;

    /* renamed from: b  reason: collision with root package name */
    final h.c.g0<? extends R, ? super T> f16521b;

    public j0(h.c.h0<T> h0Var, h.c.g0<? extends R, ? super T> g0Var) {
        this.a = h0Var;
        this.f16521b = g0Var;
    }

    @Override // h.c.b0
    protected void subscribeActual(h.c.e0<? super R> e0Var) {
        try {
            this.a.subscribe((h.c.e0) h.c.n0.b.b.e(this.f16521b.a(e0Var), "The onLift returned a null SingleObserver"));
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            h.c.n0.a.d.z(th, e0Var);
        }
    }
}
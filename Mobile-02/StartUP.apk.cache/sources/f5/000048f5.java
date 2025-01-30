package e.h.a;

import h.c.s;
import h.c.z;

/* compiled from: InitialValueObservable.java */
/* loaded from: classes2.dex */
public abstract class a<T> extends s<T> {

    /* compiled from: InitialValueObservable.java */
    /* renamed from: e.h.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private final class C0313a extends s<T> {
        C0313a() {
        }

        @Override // h.c.s
        protected void subscribeActual(z<? super T> zVar) {
            a.this.d(zVar);
        }
    }

    protected abstract T b();

    public final s<T> c() {
        return new C0313a();
    }

    protected abstract void d(z<? super T> zVar);

    @Override // h.c.s
    protected final void subscribeActual(z<? super T> zVar) {
        d(zVar);
        zVar.onNext(b());
    }
}
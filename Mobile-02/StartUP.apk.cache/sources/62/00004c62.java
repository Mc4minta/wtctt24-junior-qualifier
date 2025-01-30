package h.c.n0.e.b;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: BlockingFlowableMostRecent.java */
/* loaded from: classes3.dex */
public final class d<T> implements Iterable<T> {
    final h.c.h<T> a;

    /* renamed from: b  reason: collision with root package name */
    final T f14303b;

    /* compiled from: BlockingFlowableMostRecent.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends h.c.w0.a<T> {

        /* renamed from: b  reason: collision with root package name */
        volatile Object f14304b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: BlockingFlowableMostRecent.java */
        /* renamed from: h.c.n0.e.b.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public final class C0346a implements Iterator<T> {
            private Object a;

            C0346a() {
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                Object obj = a.this.f14304b;
                this.a = obj;
                return !h.c.n0.j.m.D(obj);
            }

            @Override // java.util.Iterator
            public T next() {
                try {
                    if (this.a == null) {
                        this.a = a.this.f14304b;
                    }
                    if (!h.c.n0.j.m.D(this.a)) {
                        if (!h.c.n0.j.m.E(this.a)) {
                            return (T) h.c.n0.j.m.C(this.a);
                        }
                        throw h.c.n0.j.j.e(h.c.n0.j.m.B(this.a));
                    }
                    throw new NoSuchElementException();
                } finally {
                    this.a = null;
                }
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Read only iterator");
            }
        }

        a(T t) {
            this.f14304b = h.c.n0.j.m.F(t);
        }

        public a<T>.C0346a c() {
            return new C0346a();
        }

        @Override // k.a.c
        public void onComplete() {
            this.f14304b = h.c.n0.j.m.y();
        }

        @Override // k.a.c
        public void onError(Throwable th) {
            this.f14304b = h.c.n0.j.m.A(th);
        }

        @Override // k.a.c
        public void onNext(T t) {
            this.f14304b = h.c.n0.j.m.F(t);
        }
    }

    public d(h.c.h<T> hVar, T t) {
        this.a = hVar;
        this.f14303b = t;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        a aVar = new a(this.f14303b);
        this.a.subscribe((h.c.m) aVar);
        return aVar.c();
    }
}
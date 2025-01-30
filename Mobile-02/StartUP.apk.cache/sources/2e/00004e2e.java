package h.c.n0.e.e;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: BlockingObservableMostRecent.java */
/* loaded from: classes3.dex */
public final class d<T> implements Iterable<T> {
    final h.c.x<T> a;

    /* renamed from: b  reason: collision with root package name */
    final T f15567b;

    /* compiled from: BlockingObservableMostRecent.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends h.c.p0.b<T> {

        /* renamed from: b  reason: collision with root package name */
        volatile Object f15568b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: BlockingObservableMostRecent.java */
        /* renamed from: h.c.n0.e.e.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public final class C0378a implements Iterator<T> {
            private Object a;

            C0378a() {
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                Object obj = a.this.f15568b;
                this.a = obj;
                return !h.c.n0.j.m.D(obj);
            }

            @Override // java.util.Iterator
            public T next() {
                try {
                    if (this.a == null) {
                        this.a = a.this.f15568b;
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
            this.f15568b = h.c.n0.j.m.F(t);
        }

        public a<T>.C0378a b() {
            return new C0378a();
        }

        @Override // h.c.z, k.a.c
        public void onComplete() {
            this.f15568b = h.c.n0.j.m.y();
        }

        @Override // h.c.z, k.a.c
        public void onError(Throwable th) {
            this.f15568b = h.c.n0.j.m.A(th);
        }

        @Override // h.c.z, k.a.c
        public void onNext(T t) {
            this.f15568b = h.c.n0.j.m.F(t);
        }
    }

    public d(h.c.x<T> xVar, T t) {
        this.a = xVar;
        this.f15567b = t;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        a aVar = new a(this.f15567b);
        this.a.subscribe(aVar);
        return aVar.b();
    }
}
package h.c.n0.f;

import h.c.n0.c.i;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: MpscLinkedQueue.java */
/* loaded from: classes3.dex */
public final class a<T> implements i<T> {
    private final AtomicReference<C0397a<T>> a = new AtomicReference<>();

    /* renamed from: b  reason: collision with root package name */
    private final AtomicReference<C0397a<T>> f16609b = new AtomicReference<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MpscLinkedQueue.java */
    /* renamed from: h.c.n0.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0397a<E> extends AtomicReference<C0397a<E>> {
        private E a;

        C0397a() {
        }

        public E a() {
            E b2 = b();
            e(null);
            return b2;
        }

        public E b() {
            return this.a;
        }

        public C0397a<E> c() {
            return get();
        }

        public void d(C0397a<E> c0397a) {
            lazySet(c0397a);
        }

        public void e(E e2) {
            this.a = e2;
        }

        C0397a(E e2) {
            e(e2);
        }
    }

    public a() {
        C0397a<T> c0397a = new C0397a<>();
        d(c0397a);
        e(c0397a);
    }

    C0397a<T> a() {
        return this.f16609b.get();
    }

    C0397a<T> b() {
        return this.f16609b.get();
    }

    C0397a<T> c() {
        return this.a.get();
    }

    @Override // h.c.n0.c.j
    public void clear() {
        while (poll() != null && !isEmpty()) {
        }
    }

    void d(C0397a<T> c0397a) {
        this.f16609b.lazySet(c0397a);
    }

    C0397a<T> e(C0397a<T> c0397a) {
        return this.a.getAndSet(c0397a);
    }

    @Override // h.c.n0.c.j
    public boolean isEmpty() {
        return b() == c();
    }

    @Override // h.c.n0.c.j
    public boolean offer(T t) {
        Objects.requireNonNull(t, "Null is not a valid element");
        C0397a<T> c0397a = new C0397a<>(t);
        e(c0397a).d(c0397a);
        return true;
    }

    @Override // h.c.n0.c.i, h.c.n0.c.j
    public T poll() {
        C0397a<T> c2;
        C0397a<T> a = a();
        C0397a<T> c3 = a.c();
        if (c3 != null) {
            T a2 = c3.a();
            d(c3);
            return a2;
        } else if (a != c()) {
            do {
                c2 = a.c();
            } while (c2 == null);
            T a3 = c2.a();
            d(c2);
            return a3;
        } else {
            return null;
        }
    }
}
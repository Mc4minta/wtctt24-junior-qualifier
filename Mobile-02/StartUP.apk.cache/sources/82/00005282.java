package kotlin.k0;

import java.util.Iterator;

/* compiled from: Sequences.kt */
/* loaded from: classes3.dex */
public final class r<T, R> implements h<R> {
    private final h<T> a;

    /* renamed from: b  reason: collision with root package name */
    private final kotlin.e0.c.l<T, R> f17345b;

    /* compiled from: Sequences.kt */
    /* loaded from: classes3.dex */
    public static final class a implements Iterator<R>, kotlin.jvm.internal.n0.a {
        private final Iterator<T> a;

        a() {
            this.a = r.this.a.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a.hasNext();
        }

        @Override // java.util.Iterator
        public R next() {
            return (R) r.this.f17345b.invoke(this.a.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public r(h<? extends T> sequence, kotlin.e0.c.l<? super T, ? extends R> transformer) {
        kotlin.jvm.internal.m.g(sequence, "sequence");
        kotlin.jvm.internal.m.g(transformer, "transformer");
        this.a = sequence;
        this.f17345b = transformer;
    }

    public final <E> h<E> d(kotlin.e0.c.l<? super R, ? extends Iterator<? extends E>> iterator) {
        kotlin.jvm.internal.m.g(iterator, "iterator");
        return new f(this.a, this.f17345b, iterator);
    }

    @Override // kotlin.k0.h
    public Iterator<R> iterator() {
        return new a();
    }
}
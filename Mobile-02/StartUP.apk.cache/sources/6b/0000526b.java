package kotlin.k0;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: Sequences.kt */
/* loaded from: classes3.dex */
public final class f<T, R, E> implements h<E> {
    private final h<T> a;

    /* renamed from: b  reason: collision with root package name */
    private final kotlin.e0.c.l<T, R> f17331b;

    /* renamed from: c  reason: collision with root package name */
    private final kotlin.e0.c.l<R, Iterator<E>> f17332c;

    /* compiled from: Sequences.kt */
    /* loaded from: classes3.dex */
    public static final class a implements Iterator<E>, kotlin.jvm.internal.n0.a {
        private final Iterator<T> a;

        /* renamed from: b  reason: collision with root package name */
        private Iterator<? extends E> f17333b;

        a() {
            this.a = f.this.a.iterator();
        }

        private final boolean b() {
            Iterator<? extends E> it = this.f17333b;
            if (it != null && !it.hasNext()) {
                this.f17333b = null;
            }
            while (true) {
                if (this.f17333b == null) {
                    if (!this.a.hasNext()) {
                        return false;
                    }
                    Iterator<? extends E> it2 = (Iterator) f.this.f17332c.invoke(f.this.f17331b.invoke(this.a.next()));
                    if (it2.hasNext()) {
                        this.f17333b = it2;
                        break;
                    }
                } else {
                    break;
                }
            }
            return true;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return b();
        }

        @Override // java.util.Iterator
        public E next() {
            if (b()) {
                Iterator<? extends E> it = this.f17333b;
                kotlin.jvm.internal.m.e(it);
                return it.next();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(h<? extends T> sequence, kotlin.e0.c.l<? super T, ? extends R> transformer, kotlin.e0.c.l<? super R, ? extends Iterator<? extends E>> iterator) {
        kotlin.jvm.internal.m.g(sequence, "sequence");
        kotlin.jvm.internal.m.g(transformer, "transformer");
        kotlin.jvm.internal.m.g(iterator, "iterator");
        this.a = sequence;
        this.f17331b = transformer;
        this.f17332c = iterator;
    }

    @Override // kotlin.k0.h
    public Iterator<E> iterator() {
        return new a();
    }
}
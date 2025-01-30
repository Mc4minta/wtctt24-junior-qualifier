package kotlin.k0;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: Sequences.kt */
/* loaded from: classes3.dex */
public final class e<T> implements h<T> {
    private final h<T> a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f17326b;

    /* renamed from: c  reason: collision with root package name */
    private final kotlin.e0.c.l<T, Boolean> f17327c;

    /* compiled from: Sequences.kt */
    /* loaded from: classes3.dex */
    public static final class a implements Iterator<T>, kotlin.jvm.internal.n0.a {
        private final Iterator<T> a;

        /* renamed from: b  reason: collision with root package name */
        private int f17328b = -1;

        /* renamed from: c  reason: collision with root package name */
        private T f17329c;

        a() {
            this.a = e.this.a.iterator();
        }

        private final void b() {
            while (this.a.hasNext()) {
                T next = this.a.next();
                if (((Boolean) e.this.f17327c.invoke(next)).booleanValue() == e.this.f17326b) {
                    this.f17329c = next;
                    this.f17328b = 1;
                    return;
                }
            }
            this.f17328b = 0;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f17328b == -1) {
                b();
            }
            return this.f17328b == 1;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.f17328b == -1) {
                b();
            }
            if (this.f17328b != 0) {
                T t = this.f17329c;
                this.f17329c = null;
                this.f17328b = -1;
                return t;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(h<? extends T> sequence, boolean z, kotlin.e0.c.l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.m.g(sequence, "sequence");
        kotlin.jvm.internal.m.g(predicate, "predicate");
        this.a = sequence;
        this.f17326b = z;
        this.f17327c = predicate;
    }

    @Override // kotlin.k0.h
    public Iterator<T> iterator() {
        return new a();
    }
}
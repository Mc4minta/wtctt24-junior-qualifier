package kotlin.k0;

import java.util.Iterator;

/* compiled from: Sequences.kt */
/* loaded from: classes3.dex */
public final class b<T> implements h<T>, c<T> {
    private final h<T> a;

    /* renamed from: b  reason: collision with root package name */
    private final int f17323b;

    /* compiled from: Sequences.kt */
    /* loaded from: classes3.dex */
    public static final class a implements Iterator<T>, kotlin.jvm.internal.n0.a {
        private final Iterator<T> a;

        /* renamed from: b  reason: collision with root package name */
        private int f17324b;

        a() {
            this.a = b.this.a.iterator();
            this.f17324b = b.this.f17323b;
        }

        private final void b() {
            while (this.f17324b > 0 && this.a.hasNext()) {
                this.a.next();
                this.f17324b--;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            b();
            return this.a.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            b();
            return this.a.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(h<? extends T> sequence, int i2) {
        kotlin.jvm.internal.m.g(sequence, "sequence");
        this.a = sequence;
        this.f17323b = i2;
        if (i2 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i2 + '.').toString());
    }

    @Override // kotlin.k0.c
    public h<T> a(int i2) {
        int i3 = this.f17323b + i2;
        return i3 < 0 ? new b(this, i2) : new b(this.a, i3);
    }

    @Override // kotlin.k0.h
    public Iterator<T> iterator() {
        return new a();
    }
}
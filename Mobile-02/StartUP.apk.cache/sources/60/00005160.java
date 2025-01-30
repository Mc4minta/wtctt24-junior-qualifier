package kotlin.a0;

import java.util.Iterator;

/* compiled from: Iterators.kt */
/* loaded from: classes3.dex */
public final class g0<T> implements Iterator<e0<? extends T>>, kotlin.jvm.internal.n0.a {
    private int a;

    /* renamed from: b  reason: collision with root package name */
    private final Iterator<T> f17214b;

    /* JADX WARN: Multi-variable type inference failed */
    public g0(Iterator<? extends T> iterator) {
        kotlin.jvm.internal.m.g(iterator, "iterator");
        this.f17214b = iterator;
    }

    @Override // java.util.Iterator
    /* renamed from: b */
    public final e0<T> next() {
        int i2 = this.a;
        this.a = i2 + 1;
        if (i2 < 0) {
            r.q();
        }
        return new e0<>(i2, this.f17214b.next());
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f17214b.hasNext();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
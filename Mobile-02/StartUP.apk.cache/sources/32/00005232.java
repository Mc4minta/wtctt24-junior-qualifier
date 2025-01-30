package kotlin.jvm.internal;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: ArrayIterator.kt */
/* loaded from: classes3.dex */
final class a<T> implements Iterator<T>, kotlin.jvm.internal.n0.a {
    private int a;

    /* renamed from: b  reason: collision with root package name */
    private final T[] f17307b;

    public a(T[] array) {
        m.g(array, "array");
        this.f17307b = array;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.a < this.f17307b.length;
    }

    @Override // java.util.Iterator
    public T next() {
        try {
            T[] tArr = this.f17307b;
            int i2 = this.a;
            this.a = i2 + 1;
            return tArr[i2];
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.a--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
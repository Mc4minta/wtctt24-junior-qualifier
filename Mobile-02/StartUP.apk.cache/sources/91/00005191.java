package kotlin.a0.w0;

import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.m;

/* compiled from: MapBuilder.kt */
/* loaded from: classes3.dex */
public final class f<V> extends kotlin.a0.e<V> implements Collection<V>, kotlin.jvm.internal.n0.b {
    private final c<?, V> a;

    public f(c<?, V> backing) {
        m.g(backing, "backing");
        this.a = backing;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean add(V v) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection<? extends V> elements) {
        m.g(elements, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return this.a.containsValue(obj);
    }

    @Override // kotlin.a0.e
    public int i() {
        return this.a.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<V> iterator() {
        return this.a.L();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object obj) {
        return this.a.K(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection<? extends Object> elements) {
        m.g(elements, "elements");
        this.a.k();
        return super.removeAll(elements);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean retainAll(Collection<? extends Object> elements) {
        m.g(elements, "elements");
        this.a.k();
        return super.retainAll(elements);
    }
}
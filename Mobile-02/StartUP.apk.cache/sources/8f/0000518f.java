package kotlin.a0.w0;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.m;

/* compiled from: MapBuilder.kt */
/* loaded from: classes3.dex */
public final class d<K, V> extends a<Map.Entry<K, V>, K, V> {
    private final c<K, V> a;

    public d(c<K, V> backing) {
        m.g(backing, "backing");
        this.a = backing;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends Map.Entry<K, V>> elements) {
        m.g(elements, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<? extends Object> elements) {
        m.g(elements, "elements");
        return this.a.m(elements);
    }

    @Override // kotlin.a0.h
    public int i() {
        return this.a.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<Map.Entry<K, V>> iterator() {
        return this.a.r();
    }

    @Override // kotlin.a0.w0.a
    public boolean l(Map.Entry<? extends K, ? extends V> element) {
        m.g(element, "element");
        return this.a.n(element);
    }

    @Override // kotlin.a0.w0.a
    public boolean m(Map.Entry element) {
        m.g(element, "element");
        return this.a.G(element);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    /* renamed from: o */
    public boolean add(Map.Entry<K, V> element) {
        m.g(element, "element");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection<? extends Object> elements) {
        m.g(elements, "elements");
        this.a.k();
        return super.removeAll(elements);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection<? extends Object> elements) {
        m.g(elements, "elements");
        this.a.k();
        return super.retainAll(elements);
    }
}
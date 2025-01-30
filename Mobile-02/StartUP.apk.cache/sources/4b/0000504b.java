package h.c.n0.j;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: VolatileSizeArrayList.java */
/* loaded from: classes3.dex */
public final class s<T> extends AtomicInteger implements List<T>, RandomAccess {
    final ArrayList<T> a = new ArrayList<>();

    @Override // java.util.List, java.util.Collection
    public boolean add(T t) {
        boolean add = this.a.add(t);
        lazySet(this.a.size());
        return add;
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        boolean addAll = this.a.addAll(collection);
        lazySet(this.a.size());
        return addAll;
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        this.a.clear();
        lazySet(0);
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        return this.a.contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        return this.a.containsAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(Object obj) {
        if (obj instanceof s) {
            return this.a.equals(((s) obj).a);
        }
        return this.a.equals(obj);
    }

    @Override // java.util.List
    public T get(int i2) {
        return this.a.get(i2);
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        return this.a.indexOf(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return get() == 0;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return this.a.iterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        return this.a.lastIndexOf(obj);
    }

    @Override // java.util.List
    public ListIterator<T> listIterator() {
        return this.a.listIterator();
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        boolean remove = this.a.remove(obj);
        lazySet(this.a.size());
        return remove;
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        boolean removeAll = this.a.removeAll(collection);
        lazySet(this.a.size());
        return removeAll;
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        boolean retainAll = this.a.retainAll(collection);
        lazySet(this.a.size());
        return retainAll;
    }

    @Override // java.util.List
    public T set(int i2, T t) {
        return this.a.set(i2, t);
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        return get();
    }

    @Override // java.util.List
    public List<T> subList(int i2, int i3) {
        return this.a.subList(i2, i3);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return this.a.toArray();
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public String toString() {
        return this.a.toString();
    }

    @Override // java.util.List
    public ListIterator<T> listIterator(int i2) {
        return this.a.listIterator(i2);
    }

    @Override // java.util.List, java.util.Collection
    public <E> E[] toArray(E[] eArr) {
        return (E[]) this.a.toArray(eArr);
    }

    @Override // java.util.List
    public void add(int i2, T t) {
        this.a.add(i2, t);
        lazySet(this.a.size());
    }

    @Override // java.util.List
    public boolean addAll(int i2, Collection<? extends T> collection) {
        boolean addAll = this.a.addAll(i2, collection);
        lazySet(this.a.size());
        return addAll;
    }

    @Override // java.util.List
    public T remove(int i2) {
        T remove = this.a.remove(i2);
        lazySet(this.a.size());
        return remove;
    }
}
package com.google.protobuf;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ProtobufArrayList.java */
/* loaded from: classes2.dex */
final class r<E> extends c<E> {

    /* renamed from: b  reason: collision with root package name */
    private static final r<Object> f9737b;

    /* renamed from: c  reason: collision with root package name */
    private final List<E> f9738c;

    static {
        r<Object> rVar = new r<>();
        f9737b = rVar;
        rVar.v();
    }

    r() {
        this(new ArrayList(10));
    }

    public static <E> r<E> i() {
        return (r<E>) f9737b;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i2, E e2) {
        h();
        this.f9738c.add(i2, e2);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i2) {
        return this.f9738c.get(i2);
    }

    @Override // com.google.protobuf.k.a
    /* renamed from: k */
    public r<E> G(int i2) {
        if (i2 >= size()) {
            ArrayList arrayList = new ArrayList(i2);
            arrayList.addAll(this.f9738c);
            return new r<>(arrayList);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    public E remove(int i2) {
        h();
        E remove = this.f9738c.remove(i2);
        ((AbstractList) this).modCount++;
        return remove;
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int i2, E e2) {
        h();
        E e3 = this.f9738c.set(i2, e2);
        ((AbstractList) this).modCount++;
        return e3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f9738c.size();
    }

    private r(List<E> list) {
        this.f9738c = list;
    }
}
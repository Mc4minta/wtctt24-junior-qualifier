package com.google.android.gms.internal.clearcut;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
final class v2<E> extends t<E> {

    /* renamed from: b  reason: collision with root package name */
    private static final v2<Object> f6577b;

    /* renamed from: c  reason: collision with root package name */
    private final List<E> f6578c;

    static {
        v2<Object> v2Var = new v2<>();
        f6577b = v2Var;
        v2Var.j();
    }

    v2() {
        this(new ArrayList(10));
    }

    private v2(List<E> list) {
        this.f6578c = list;
    }

    public static <E> v2<E> i() {
        return (v2<E>) f6577b;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i2, E e2) {
        h();
        this.f6578c.add(i2, e2);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final E get(int i2) {
        return this.f6578c.get(i2);
    }

    @Override // java.util.AbstractList, java.util.List
    public final E remove(int i2) {
        h();
        E remove = this.f6578c.remove(i2);
        ((AbstractList) this).modCount++;
        return remove;
    }

    @Override // java.util.AbstractList, java.util.List
    public final E set(int i2, E e2) {
        h();
        E e3 = this.f6578c.set(i2, e2);
        ((AbstractList) this).modCount++;
        return e3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f6578c.size();
    }

    @Override // com.google.android.gms.internal.clearcut.j1
    public final /* synthetic */ j1 x0(int i2) {
        if (i2 >= size()) {
            ArrayList arrayList = new ArrayList(i2);
            arrayList.addAll(this.f6578c);
            return new v2(arrayList);
        }
        throw new IllegalArgumentException();
    }
}
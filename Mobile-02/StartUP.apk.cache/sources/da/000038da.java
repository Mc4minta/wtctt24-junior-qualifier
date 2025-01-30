package com.google.common.collect;

/* compiled from: SingletonImmutableList.java */
/* loaded from: classes2.dex */
final class i0<E> extends l<E> {
    final transient E a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i0(E e2) {
        this.a = (E) com.google.common.base.l.i(e2);
    }

    @Override // java.util.List
    public E get(int i2) {
        com.google.common.base.l.g(i2, 1);
        return this.a;
    }

    @Override // com.google.common.collect.l, com.google.common.collect.j, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* renamed from: l */
    public l0<E> iterator() {
        return s.i(this.a);
    }

    @Override // com.google.common.collect.l, java.util.List
    /* renamed from: r */
    public l<E> subList(int i2, int i3) {
        com.google.common.base.l.n(i2, i3, 1);
        return i2 == i3 ? l.p() : this;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return '[' + this.a.toString() + ']';
    }
}
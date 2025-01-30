package com.google.common.collect;

import com.google.errorprone.annotations.concurrent.LazyInit;

/* compiled from: SingletonImmutableSet.java */
/* loaded from: classes2.dex */
final class j0<E> extends r<E> {

    /* renamed from: b  reason: collision with root package name */
    final transient E f8482b;
    @LazyInit

    /* renamed from: c  reason: collision with root package name */
    private transient int f8483c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j0(E e2) {
        this.f8482b = (E) com.google.common.base.l.i(e2);
    }

    @Override // com.google.common.collect.j, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.f8482b.equals(obj);
    }

    @Override // com.google.common.collect.j
    int h(Object[] objArr, int i2) {
        objArr[i2] = this.f8482b;
        return i2 + 1;
    }

    @Override // com.google.common.collect.r, java.util.Collection, java.util.Set
    public final int hashCode() {
        int i2 = this.f8483c;
        if (i2 == 0) {
            int hashCode = this.f8482b.hashCode();
            this.f8483c = hashCode;
            return hashCode;
        }
        return i2;
    }

    @Override // com.google.common.collect.r
    l<E> m() {
        return l.q(this.f8482b);
    }

    @Override // com.google.common.collect.r
    boolean o() {
        return this.f8483c != 0;
    }

    @Override // com.google.common.collect.r, com.google.common.collect.j, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* renamed from: p */
    public l0<E> iterator() {
        return s.i(this.f8482b);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return '[' + this.f8482b.toString() + ']';
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j0(E e2, int i2) {
        this.f8482b = e2;
        this.f8483c = i2;
    }
}
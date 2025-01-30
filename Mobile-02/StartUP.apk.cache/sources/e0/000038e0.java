package com.google.common.collect;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: ImmutableList.java */
/* loaded from: classes2.dex */
public abstract class l<E> extends j<E> implements List<E>, RandomAccess {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ImmutableList.java */
    /* loaded from: classes2.dex */
    public class a extends com.google.common.collect.a<E> {
        a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // com.google.common.collect.a
        protected E b(int i2) {
            return l.this.get(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ImmutableList.java */
    /* loaded from: classes2.dex */
    public class b extends l<E> {
        final transient int a;

        /* renamed from: b  reason: collision with root package name */
        final transient int f8486b;

        b(int i2, int i3) {
            this.a = i2;
            this.f8486b = i3;
        }

        @Override // java.util.List
        public E get(int i2) {
            com.google.common.base.l.g(i2, this.f8486b);
            return l.this.get(i2 + this.a);
        }

        @Override // com.google.common.collect.l, com.google.common.collect.j, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // com.google.common.collect.l, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return super.listIterator();
        }

        @Override // com.google.common.collect.l, java.util.List
        /* renamed from: r */
        public l<E> subList(int i2, int i3) {
            com.google.common.base.l.n(i2, i3, this.f8486b);
            l lVar = l.this;
            int i4 = this.a;
            return lVar.subList(i2 + i4, i3 + i4);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f8486b;
        }

        @Override // com.google.common.collect.l, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator(int i2) {
            return super.listIterator(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> l<E> i(Object[] objArr) {
        return k(objArr, objArr.length);
    }

    static <E> l<E> k(Object[] objArr, int i2) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 < objArr.length) {
                    objArr = y.a(objArr, i2);
                }
                return new d0(objArr);
            }
            return new i0(objArr[0]);
        }
        return p();
    }

    public static <E> l<E> p() {
        return (l<E>) d0.a;
    }

    public static <E> l<E> q(E e2) {
        return new i0(e2);
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i2, E e2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @CanIgnoreReturnValue
    @Deprecated
    public final boolean addAll(int i2, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.j, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        return t.a(this, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.j
    public int h(Object[] objArr, int i2) {
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            objArr[i2 + i3] = get(i3);
        }
        return i2 + size;
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        int size = size();
        int i2 = 1;
        for (int i3 = 0; i3 < size; i3++) {
            i2 = ~(~((i2 * 31) + get(i3).hashCode()));
        }
        return i2;
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        return t.b(this, obj);
    }

    @Override // com.google.common.collect.j, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* renamed from: l */
    public l0<E> iterator() {
        return listIterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        return t.d(this, obj);
    }

    @Override // java.util.List
    /* renamed from: m */
    public m0<E> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    /* renamed from: o */
    public m0<E> listIterator(int i2) {
        return new a(size(), i2);
    }

    @Override // java.util.List
    /* renamed from: r */
    public l<E> subList(int i2, int i3) {
        com.google.common.base.l.n(i2, i3, size());
        int i4 = i3 - i2;
        if (i4 == size()) {
            return this;
        }
        if (i4 != 0) {
            if (i4 != 1) {
                return s(i2, i3);
            }
            return q(get(i2));
        }
        return p();
    }

    @Override // java.util.List
    @CanIgnoreReturnValue
    @Deprecated
    public final E remove(int i2) {
        throw new UnsupportedOperationException();
    }

    l<E> s(int i2, int i3) {
        return new b(i2, i3 - i2);
    }

    @Override // java.util.List
    @CanIgnoreReturnValue
    @Deprecated
    public final E set(int i2, E e2) {
        throw new UnsupportedOperationException();
    }
}
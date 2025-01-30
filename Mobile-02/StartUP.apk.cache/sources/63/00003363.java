package com.google.android.gms.internal.p000firebaseperf;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.e8  reason: invalid package */
/* loaded from: classes2.dex */
public abstract class e8<E> extends f8<E> implements List<E>, RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    private static final t8<Object> f6715b = new h8(l8.f6820c, 0);

    public static <E> e8<E> q() {
        return (e8<E>) l8.f6820c;
    }

    public static <E> e8<E> r(Collection<? extends E> collection) {
        if (collection instanceof f8) {
            e8<E> k2 = ((f8) collection).k();
            if (k2.p()) {
                Object[] array = k2.toArray();
                int length = array.length;
                if (length == 0) {
                    return (e8<E>) l8.f6820c;
                }
                return new l8(array, length);
            }
            return k2;
        }
        Object[] array2 = collection.toArray();
        int length2 = array2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            if (array2[i2] == null) {
                StringBuilder sb = new StringBuilder(20);
                sb.append("at index ");
                sb.append(i2);
                throw new NullPointerException(sb.toString());
            }
        }
        int length3 = array2.length;
        if (length3 == 0) {
            return (e8<E>) l8.f6820c;
        }
        return new l8(array2, length3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> e8<E> s(Object[] objArr) {
        int length = objArr.length;
        if (length == 0) {
            return (e8<E>) l8.f6820c;
        }
        return new l8(objArr, length);
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i2, E e2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final boolean addAll(int i2, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.f8, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(@NullableDecl Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(@NullableDecl Object obj) {
        if (obj == c2.b(this)) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (list instanceof RandomAccess) {
                    for (int i2 = 0; i2 < size; i2++) {
                        if (d3.a(get(i2), list.get(i2))) {
                        }
                    }
                    return true;
                }
                int size2 = size();
                Iterator<E> it = list.iterator();
                int i3 = 0;
                while (true) {
                    if (i3 < size2) {
                        if (!it.hasNext()) {
                            break;
                        }
                        E e2 = get(i3);
                        i3++;
                        if (!d3.a(e2, it.next())) {
                            break;
                        }
                    } else if (!it.hasNext()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p000firebaseperf.f8
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

    @Override // com.google.android.gms.internal.p000firebaseperf.f8
    public final q8<E> i() {
        return (t8) listIterator();
    }

    @Override // java.util.List
    public int indexOf(@NullableDecl Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (obj.equals(get(i2))) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.f8, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.f8
    public final e8<E> k() {
        return this;
    }

    @Override // java.util.List
    public int lastIndexOf(@NullableDecl Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    @Override // java.util.List
    public /* synthetic */ ListIterator listIterator(int i2) {
        c2.f(i2, size());
        if (isEmpty()) {
            return f6715b;
        }
        return new h8(this, i2);
    }

    @Override // java.util.List
    @Deprecated
    public final E remove(int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final E set(int i2, E e2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    /* renamed from: t */
    public e8<E> subList(int i2, int i3) {
        c2.e(i2, i3, size());
        int i4 = i3 - i2;
        if (i4 == size()) {
            return this;
        }
        if (i4 == 0) {
            return (e8<E>) l8.f6820c;
        }
        return new g8(this, i2, i4);
    }

    @Override // java.util.List
    public /* synthetic */ ListIterator listIterator() {
        return (t8) listIterator(0);
    }
}
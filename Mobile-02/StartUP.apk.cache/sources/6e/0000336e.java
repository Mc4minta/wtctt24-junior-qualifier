package com.google.android.gms.internal.p000firebaseperf;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.f8  reason: invalid package */
/* loaded from: classes2.dex */
public abstract class f8<E> extends AbstractCollection<E> implements Serializable {
    private static final Object[] a = new Object[0];

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean add(E e2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public abstract boolean contains(@NullableDecl Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h(Object[] objArr, int i2) {
        q8 q8Var = (q8) iterator();
        while (q8Var.hasNext()) {
            objArr[i2] = q8Var.next();
            i2++;
        }
        return i2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    /* renamed from: i */
    public abstract q8<E> iterator();

    public e8<E> k() {
        return isEmpty() ? e8.q() : e8.s(toArray());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NullableDecl
    public Object[] l() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int m() {
        throw new UnsupportedOperationException();
    }

    int o() {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean p();

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        return toArray(a);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final <T> T[] toArray(T[] tArr) {
        c2.b(tArr);
        int size = size();
        if (tArr.length < size) {
            Object[] l2 = l();
            if (l2 != null) {
                return (T[]) Arrays.copyOfRange(l2, m(), o(), tArr.getClass());
            }
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), size));
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        h(tArr, 0);
        return tArr;
    }
}
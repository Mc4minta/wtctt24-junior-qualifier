package com.google.common.collect;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.lwansbrough.RCTCamera.RCTCameraModule;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: ImmutableCollection.java */
/* loaded from: classes2.dex */
public abstract class j<E> extends AbstractCollection<E> implements Serializable {

    /* compiled from: ImmutableCollection.java */
    /* loaded from: classes2.dex */
    public static abstract class a<E> {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static int a(int i2, int i3) {
            if (i3 >= 0) {
                int i4 = i2 + (i2 >> 1) + 1;
                if (i4 < i3) {
                    i4 = Integer.highestOneBit(i3 - 1) << 1;
                }
                return i4 < 0 ? RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO : i4;
            }
            throw new AssertionError("cannot store more than MAX_VALUE elements");
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    @Deprecated
    public final boolean add(E e2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public abstract boolean contains(Object obj);

    @CanIgnoreReturnValue
    int h(Object[] objArr, int i2) {
        Iterator it = iterator();
        while (it.hasNext()) {
            objArr[i2] = it.next();
            i2++;
        }
        return i2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public abstract /* bridge */ /* synthetic */ Iterator iterator();

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    @Deprecated
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        int size = size();
        if (size == 0) {
            return y.a;
        }
        Object[] objArr = new Object[size];
        h(objArr, 0);
        return objArr;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    public final <T> T[] toArray(T[] tArr) {
        com.google.common.base.l.i(tArr);
        int size = size();
        if (tArr.length < size) {
            tArr = (T[]) y.c(tArr, size);
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        h(tArr, 0);
        return tArr;
    }
}
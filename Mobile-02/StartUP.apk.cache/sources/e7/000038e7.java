package com.google.common.collect;

import java.util.ListIterator;

/* compiled from: UnmodifiableListIterator.java */
/* loaded from: classes2.dex */
public abstract class m0<E> extends l0<E> implements ListIterator<E> {
    @Override // java.util.ListIterator
    @Deprecated
    public final void add(E e2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    @Deprecated
    public final void set(E e2) {
        throw new UnsupportedOperationException();
    }
}
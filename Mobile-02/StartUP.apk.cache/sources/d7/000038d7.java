package com.google.common.collect;

/* compiled from: ImmutableAsList.java */
/* loaded from: classes2.dex */
abstract class h<E> extends l<E> {
    @Override // com.google.common.collect.l, com.google.common.collect.j, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return t().contains(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return t().isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return t().size();
    }

    abstract j<E> t();
}
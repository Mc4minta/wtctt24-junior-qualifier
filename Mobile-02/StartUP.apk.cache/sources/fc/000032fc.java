package com.google.android.gms.internal.clearcut;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
public final class u3 extends AbstractList<String> implements r1, RandomAccess {
    private final r1 a;

    public u3(r1 r1Var) {
        this.a = r1Var;
    }

    @Override // com.google.android.gms.internal.clearcut.r1
    public final List<?> N() {
        return this.a.N();
    }

    @Override // com.google.android.gms.internal.clearcut.r1
    public final r1 R0() {
        return this;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        return (String) this.a.get(i2);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator<String> iterator() {
        return new w3(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator<String> listIterator(int i2) {
        return new v3(this, i2);
    }

    @Override // com.google.android.gms.internal.clearcut.r1
    public final Object n(int i2) {
        return this.a.n(i2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.a.size();
    }
}
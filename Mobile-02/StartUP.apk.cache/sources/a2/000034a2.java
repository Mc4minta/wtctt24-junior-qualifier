package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
/* loaded from: classes2.dex */
public final class e7 extends AbstractList<String> implements e5, RandomAccess {
    private final e5 a;

    public e7(e5 e5Var) {
        this.a = e5Var;
    }

    @Override // com.google.android.gms.internal.measurement.e5
    public final void L0(h3 h3Var) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.measurement.e5
    public final Object c(int i2) {
        return this.a.c(i2);
    }

    @Override // com.google.android.gms.internal.measurement.e5
    public final List<?> d() {
        return this.a.d();
    }

    @Override // com.google.android.gms.internal.measurement.e5
    public final e5 e() {
        return this;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        return (String) this.a.get(i2);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator<String> iterator() {
        return new g7(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator<String> listIterator(int i2) {
        return new h7(this, i2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.a.size();
    }
}
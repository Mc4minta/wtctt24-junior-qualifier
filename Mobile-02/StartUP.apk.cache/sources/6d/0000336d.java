package com.google.android.gms.internal.p000firebaseperf;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.f7  reason: invalid package */
/* loaded from: classes2.dex */
public final class f7 extends AbstractList<String> implements b5, RandomAccess {
    private final b5 a;

    public f7(b5 b5Var) {
        this.a = b5Var;
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.b5
    public final List<?> X0() {
        return this.a.X0();
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        return (String) this.a.get(i2);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator<String> iterator() {
        return new h7(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator<String> listIterator(int i2) {
        return new i7(this, i2);
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.b5
    public final Object n(int i2) {
        return this.a.n(i2);
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.b5
    public final b5 r0() {
        return this;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.a.size();
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.b5
    public final void y0(i3 i3Var) {
        throw new UnsupportedOperationException();
    }
}
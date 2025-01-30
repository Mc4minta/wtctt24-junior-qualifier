package com.google.android.gms.internal.p000firebaseperf;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.d5  reason: invalid package */
/* loaded from: classes2.dex */
public final class d5 extends h3<String> implements b5, RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    private static final d5 f6707b;

    /* renamed from: c  reason: collision with root package name */
    private static final b5 f6708c;

    /* renamed from: d  reason: collision with root package name */
    private final List<Object> f6709d;

    static {
        d5 d5Var = new d5();
        f6707b = d5Var;
        d5Var.Q0();
        f6708c = d5Var;
    }

    public d5() {
        this(10);
    }

    private static String i(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof i3) {
            return ((i3) obj).r();
        }
        return n4.h((byte[]) obj);
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.t4
    public final /* synthetic */ t4 J0(int i2) {
        if (i2 >= size()) {
            ArrayList arrayList = new ArrayList(i2);
            arrayList.addAll(this.f6709d);
            return new d5(arrayList);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.h3, com.google.android.gms.internal.p000firebaseperf.t4
    public final /* bridge */ /* synthetic */ boolean K() {
        return super.K();
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.b5
    public final List<?> X0() {
        return Collections.unmodifiableList(this.f6709d);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i2, Object obj) {
        h();
        this.f6709d.add(i2, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.h3, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.h3, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        h();
        this.f6709d.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.h3, java.util.AbstractList, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        Object obj = this.f6709d.get(i2);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof i3) {
            i3 i3Var = (i3) obj;
            String r = i3Var.r();
            if (i3Var.s()) {
                this.f6709d.set(i2, r);
            }
            return r;
        }
        byte[] bArr = (byte[]) obj;
        String h2 = n4.h(bArr);
        if (n4.g(bArr)) {
            this.f6709d.set(i2, h2);
        }
        return h2;
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.h3, java.util.AbstractList, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.b5
    public final Object n(int i2) {
        return this.f6709d.get(i2);
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.b5
    public final b5 r0() {
        return K() ? new f7(this) : this;
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.h3, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.h3, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.h3, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i2, Object obj) {
        h();
        return i(this.f6709d.set(i2, (String) obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f6709d.size();
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.b5
    public final void y0(i3 i3Var) {
        h();
        this.f6709d.add(i3Var);
        ((AbstractList) this).modCount++;
    }

    public d5(int i2) {
        this(new ArrayList(i2));
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.h3, java.util.AbstractList, java.util.List
    public final boolean addAll(int i2, Collection<? extends String> collection) {
        h();
        if (collection instanceof b5) {
            collection = ((b5) collection).X0();
        }
        boolean addAll = this.f6709d.addAll(i2, collection);
        ((AbstractList) this).modCount++;
        return addAll;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i2) {
        h();
        Object remove = this.f6709d.remove(i2);
        ((AbstractList) this).modCount++;
        return i(remove);
    }

    private d5(ArrayList<Object> arrayList) {
        this.f6709d = arrayList;
    }

    @Override // com.google.android.gms.internal.p000firebaseperf.h3, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        return super.add(obj);
    }
}
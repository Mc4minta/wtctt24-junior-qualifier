package com.google.android.gms.internal.clearcut;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
public final class q1 extends t<String> implements r1, RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    private static final q1 f6539b;

    /* renamed from: c  reason: collision with root package name */
    private static final r1 f6540c;

    /* renamed from: d  reason: collision with root package name */
    private final List<Object> f6541d;

    static {
        q1 q1Var = new q1();
        f6539b = q1Var;
        q1Var.j();
        f6540c = q1Var;
    }

    public q1() {
        this(10);
    }

    public q1(int i2) {
        this(new ArrayList(i2));
    }

    private q1(ArrayList<Object> arrayList) {
        this.f6541d = arrayList;
    }

    private static String i(Object obj) {
        return obj instanceof String ? (String) obj : obj instanceof a0 ? ((a0) obj).u() : g1.h((byte[]) obj);
    }

    @Override // com.google.android.gms.internal.clearcut.r1
    public final List<?> N() {
        return Collections.unmodifiableList(this.f6541d);
    }

    @Override // com.google.android.gms.internal.clearcut.r1
    public final r1 R0() {
        return g() ? new u3(this) : this;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i2, Object obj) {
        h();
        this.f6541d.add(i2, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.clearcut.t, java.util.AbstractList, java.util.List
    public final boolean addAll(int i2, Collection<? extends String> collection) {
        h();
        if (collection instanceof r1) {
            collection = ((r1) collection).N();
        }
        boolean addAll = this.f6541d.addAll(i2, collection);
        ((AbstractList) this).modCount++;
        return addAll;
    }

    @Override // com.google.android.gms.internal.clearcut.t, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // com.google.android.gms.internal.clearcut.t, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        h();
        this.f6541d.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.clearcut.t, java.util.AbstractList, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.android.gms.internal.clearcut.t, com.google.android.gms.internal.clearcut.j1
    public final /* bridge */ /* synthetic */ boolean g() {
        return super.g();
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        Object obj = this.f6541d.get(i2);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof a0) {
            a0 a0Var = (a0) obj;
            String u = a0Var.u();
            if (a0Var.m()) {
                this.f6541d.set(i2, u);
            }
            return u;
        }
        byte[] bArr = (byte[]) obj;
        String h2 = g1.h(bArr);
        if (g1.g(bArr)) {
            this.f6541d.set(i2, h2);
        }
        return h2;
    }

    @Override // com.google.android.gms.internal.clearcut.t, java.util.AbstractList, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.android.gms.internal.clearcut.r1
    public final Object n(int i2) {
        return this.f6541d.get(i2);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i2) {
        h();
        Object remove = this.f6541d.remove(i2);
        ((AbstractList) this).modCount++;
        return i(remove);
    }

    @Override // com.google.android.gms.internal.clearcut.t, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    @Override // com.google.android.gms.internal.clearcut.t, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Override // com.google.android.gms.internal.clearcut.t, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i2, Object obj) {
        h();
        return i(this.f6541d.set(i2, (String) obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f6541d.size();
    }

    @Override // com.google.android.gms.internal.clearcut.j1
    public final /* synthetic */ j1 x0(int i2) {
        if (i2 >= size()) {
            ArrayList arrayList = new ArrayList(i2);
            arrayList.addAll(this.f6541d);
            return new q1(arrayList);
        }
        throw new IllegalArgumentException();
    }
}
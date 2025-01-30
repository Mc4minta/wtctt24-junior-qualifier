package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
/* loaded from: classes2.dex */
public final class b5 extends b3<String> implements e5, RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    private static final b5 f7040b;

    /* renamed from: c  reason: collision with root package name */
    private static final e5 f7041c;

    /* renamed from: d  reason: collision with root package name */
    private final List<Object> f7042d;

    static {
        b5 b5Var = new b5();
        f7040b = b5Var;
        b5Var.b();
        f7041c = b5Var;
    }

    public b5() {
        this(10);
    }

    private static String i(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof h3) {
            return ((h3) obj).w();
        }
        return q4.i((byte[]) obj);
    }

    @Override // com.google.android.gms.internal.measurement.e5
    public final void L0(h3 h3Var) {
        h();
        this.f7042d.add(h3Var);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.b3, com.google.android.gms.internal.measurement.v4
    public final /* bridge */ /* synthetic */ boolean a() {
        return super.a();
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i2, Object obj) {
        h();
        this.f7042d.add(i2, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.b3, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // com.google.android.gms.internal.measurement.e5
    public final Object c(int i2) {
        return this.f7042d.get(i2);
    }

    @Override // com.google.android.gms.internal.measurement.b3, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        h();
        this.f7042d.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.e5
    public final List<?> d() {
        return Collections.unmodifiableList(this.f7042d);
    }

    @Override // com.google.android.gms.internal.measurement.e5
    public final e5 e() {
        return a() ? new e7(this) : this;
    }

    @Override // com.google.android.gms.internal.measurement.b3, java.util.AbstractList, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.android.gms.internal.measurement.v4
    public final /* synthetic */ v4 f(int i2) {
        if (i2 >= size()) {
            ArrayList arrayList = new ArrayList(i2);
            arrayList.addAll(this.f7042d);
            return new b5(arrayList);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i2) {
        Object obj = this.f7042d.get(i2);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof h3) {
            h3 h3Var = (h3) obj;
            String w = h3Var.w();
            if (h3Var.y()) {
                this.f7042d.set(i2, w);
            }
            return w;
        }
        byte[] bArr = (byte[]) obj;
        String i3 = q4.i(bArr);
        if (q4.h(bArr)) {
            this.f7042d.set(i2, i3);
        }
        return i3;
    }

    @Override // com.google.android.gms.internal.measurement.b3, java.util.AbstractList, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.android.gms.internal.measurement.b3, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    @Override // com.google.android.gms.internal.measurement.b3, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Override // com.google.android.gms.internal.measurement.b3, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i2, Object obj) {
        h();
        return i(this.f7042d.set(i2, (String) obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f7042d.size();
    }

    public b5(int i2) {
        this(new ArrayList(i2));
    }

    @Override // com.google.android.gms.internal.measurement.b3, java.util.AbstractList, java.util.List
    public final boolean addAll(int i2, Collection<? extends String> collection) {
        h();
        if (collection instanceof e5) {
            collection = ((e5) collection).d();
        }
        boolean addAll = this.f7042d.addAll(i2, collection);
        ((AbstractList) this).modCount++;
        return addAll;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i2) {
        h();
        Object remove = this.f7042d.remove(i2);
        ((AbstractList) this).modCount++;
        return i(remove);
    }

    private b5(ArrayList<Object> arrayList) {
        this.f7042d = arrayList;
    }

    @Override // com.google.android.gms.internal.measurement.b3, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        return super.add(obj);
    }
}
package com.google.common.collect;

import com.google.common.collect.r;

/* compiled from: RegularImmutableSet.java */
/* loaded from: classes2.dex */
final class f0<E> extends r.a<E> {

    /* renamed from: b  reason: collision with root package name */
    static final f0<Object> f8474b = new f0<>(y.a, 0, null, 0);

    /* renamed from: c  reason: collision with root package name */
    private final transient Object[] f8475c;

    /* renamed from: d  reason: collision with root package name */
    final transient Object[] f8476d;

    /* renamed from: e  reason: collision with root package name */
    private final transient int f8477e;

    /* renamed from: f  reason: collision with root package name */
    private final transient int f8478f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f0(Object[] objArr, int i2, Object[] objArr2, int i3) {
        this.f8475c = objArr;
        this.f8476d = objArr2;
        this.f8477e = i3;
        this.f8478f = i2;
    }

    @Override // com.google.common.collect.j, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        Object[] objArr = this.f8476d;
        if (obj == null || objArr == null) {
            return false;
        }
        int c2 = g.c(obj);
        while (true) {
            int i2 = c2 & this.f8477e;
            Object obj2 = objArr[i2];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            c2 = i2 + 1;
        }
    }

    @Override // com.google.common.collect.r.a
    E get(int i2) {
        return (E) this.f8475c[i2];
    }

    @Override // com.google.common.collect.j
    int h(Object[] objArr, int i2) {
        Object[] objArr2 = this.f8475c;
        System.arraycopy(objArr2, 0, objArr, i2, objArr2.length);
        return i2 + this.f8475c.length;
    }

    @Override // com.google.common.collect.r, java.util.Collection, java.util.Set
    public int hashCode() {
        return this.f8478f;
    }

    @Override // com.google.common.collect.r.a, com.google.common.collect.r
    l<E> m() {
        return this.f8476d == null ? l.p() : new b0(this, this.f8475c);
    }

    @Override // com.google.common.collect.r
    boolean o() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f8475c.length;
    }
}
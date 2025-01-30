package com.google.common.collect;

/* compiled from: RegularImmutableList.java */
/* loaded from: classes2.dex */
class d0<E> extends l<E> {
    static final l<Object> a = new d0(y.a);

    /* renamed from: b  reason: collision with root package name */
    private final transient Object[] f8469b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d0(Object[] objArr) {
        this.f8469b = objArr;
    }

    @Override // java.util.List
    public E get(int i2) {
        return (E) this.f8469b[i2];
    }

    @Override // com.google.common.collect.l, com.google.common.collect.j
    int h(Object[] objArr, int i2) {
        Object[] objArr2 = this.f8469b;
        System.arraycopy(objArr2, 0, objArr, i2, objArr2.length);
        return i2 + this.f8469b.length;
    }

    @Override // com.google.common.collect.l, java.util.List
    /* renamed from: o */
    public m0<E> listIterator(int i2) {
        Object[] objArr = this.f8469b;
        return s.g(objArr, 0, objArr.length, i2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f8469b.length;
    }
}
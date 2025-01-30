package com.google.common.collect;

/* compiled from: RegularImmutableAsList.java */
/* loaded from: classes2.dex */
class b0<E> extends h<E> {
    private final j<E> a;

    /* renamed from: b  reason: collision with root package name */
    private final l<? extends E> f8458b;

    b0(j<E> jVar, l<? extends E> lVar) {
        this.a = jVar;
        this.f8458b = lVar;
    }

    @Override // java.util.List
    public E get(int i2) {
        return this.f8458b.get(i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.l, com.google.common.collect.j
    public int h(Object[] objArr, int i2) {
        return this.f8458b.h(objArr, i2);
    }

    @Override // com.google.common.collect.l, java.util.List
    /* renamed from: o */
    public m0<E> listIterator(int i2) {
        return (m0<? extends E>) this.f8458b.listIterator(i2);
    }

    @Override // com.google.common.collect.h
    j<E> t() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b0(j<E> jVar, Object[] objArr) {
        this(jVar, l.i(objArr));
    }
}
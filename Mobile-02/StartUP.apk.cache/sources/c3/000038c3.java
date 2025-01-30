package com.google.common.collect;

import java.util.NoSuchElementException;

/* compiled from: AbstractIndexedListIterator.java */
/* loaded from: classes2.dex */
abstract class a<E> extends m0<E> {
    private final int a;

    /* renamed from: b  reason: collision with root package name */
    private int f8457b;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(int i2, int i3) {
        com.google.common.base.l.l(i3, i2);
        this.a = i2;
        this.f8457b = i3;
    }

    protected abstract E b(int i2);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f8457b < this.a;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f8457b > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final E next() {
        if (hasNext()) {
            int i2 = this.f8457b;
            this.f8457b = i2 + 1;
            return b(i2);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f8457b;
    }

    @Override // java.util.ListIterator
    public final E previous() {
        if (hasPrevious()) {
            int i2 = this.f8457b - 1;
            this.f8457b = i2;
            return b(i2);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f8457b - 1;
    }
}
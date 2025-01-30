package com.google.android.gms.internal.p000firebaseperf;

import java.util.NoSuchElementException;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.d4  reason: invalid package */
/* loaded from: classes2.dex */
abstract class d4<E> extends t8<E> {
    private final int a;

    /* renamed from: b  reason: collision with root package name */
    private int f6706b;

    /* JADX INFO: Access modifiers changed from: protected */
    public d4(int i2, int i3) {
        c2.f(i3, i2);
        this.a = i2;
        this.f6706b = i3;
    }

    protected abstract E b(int i2);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f6706b < this.a;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f6706b > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final E next() {
        if (hasNext()) {
            int i2 = this.f6706b;
            this.f6706b = i2 + 1;
            return b(i2);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f6706b;
    }

    @Override // java.util.ListIterator
    public final E previous() {
        if (hasPrevious()) {
            int i2 = this.f6706b - 1;
            this.f6706b = i2;
            return b(i2);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f6706b - 1;
    }
}
package com.google.android.gms.internal.p000firebaseperf;

import java.util.ListIterator;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.i7  reason: invalid package */
/* loaded from: classes2.dex */
final class i7 implements ListIterator<String> {
    private ListIterator<String> a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ int f6762b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ f7 f6763c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i7(f7 f7Var, int i2) {
        b5 b5Var;
        this.f6763c = f7Var;
        this.f6762b = i2;
        b5Var = f7Var.a;
        this.a = b5Var.listIterator(i2);
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ void add(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.a.hasNext();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.a.hasPrevious();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final /* synthetic */ Object next() {
        return this.a.next();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.a.nextIndex();
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ String previous() {
        return this.a.previous();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.a.previousIndex();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ void set(String str) {
        throw new UnsupportedOperationException();
    }
}
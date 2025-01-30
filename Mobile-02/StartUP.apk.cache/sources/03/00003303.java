package com.google.android.gms.internal.clearcut;

import java.util.ListIterator;

/* loaded from: classes2.dex */
final class v3 implements ListIterator<String> {
    private ListIterator<String> a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ int f6579b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ u3 f6580c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v3(u3 u3Var, int i2) {
        r1 r1Var;
        this.f6580c = u3Var;
        this.f6579b = i2;
        r1Var = u3Var.a;
        this.a = r1Var.listIterator(i2);
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